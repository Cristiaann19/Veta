import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { DialogModule } from 'primeng/dialog';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { PaginatorModule } from 'primeng/paginator';
import { ChangeDetectorRef } from '@angular/core';
import { MascotasService } from '../../../services/mascotas-service';
import { Mascota } from '../../../models/mascota';
import { TableModule } from "primeng/table";

@Component({
  selector: 'app-mascotas',
  standalone: true,
  imports: [TableModule, InputTextModule, ButtonModule, PaginatorModule, DialogModule, FormsModule, CommonModule],
  templateUrl: './mascotas.html',
})
export class Mascotas implements OnInit {

  mascotas: Mascota[] = [];
  mascotasFiltradas: Mascota[] = [];
  mascotasMostradas: Mascota[] = [];

  terminoBusqueda: string = '';

  displayEdit: Boolean = true;
  displayNew: Boolean = true;
  displayDelete: Boolean = true;
  displayHistorial: Boolean = true;

  mascotaSeleccionada: Mascota | null = null;

  first: number = 0;
  rows: number = 8;

  constructor(private mascotasService: MascotasService, private cdr: ChangeDetectorRef) { }

  ngOnInit(): void {
    this.cargarMascotas();
  }

  cargarMascotas(): void {
    this.mascotasService.listarMascotas().subscribe({
      next: (data) => {
        this.mascotas = data;
        this.filtrar();
        this.cdr.detectChanges();
      },
      error: (err) => console.error('Error:', err)
    });
  }

  filtrar(): void {
    const termino = this.terminoBusqueda.toLowerCase();

    this.mascotasFiltradas = this.mascotas.filter(m => {
      const coincideNombre = m.nombre.toLowerCase().includes(termino);
      return coincideNombre;
    });

    this.first = 0;
    this.actualizarVista();
  }

  actualizarVista(): void {
    this.mascotasMostradas = this.mascotasFiltradas.slice(this.first, this.first + this.rows);
  }

  onPageChange(event: any): void {
    this.first = event.first;
    this.actualizarVista();
  }

  abrirNuevo(): void {
    console.log("abrir nuevo")
  }

  abrirEditar(mascota: Mascota): void {
    this.mascotaSeleccionada = { ...mascota };
    this.displayEdit = true;
  }

  abrirEliminar(mascota: Mascota): void {
    this.mascotaSeleccionada = { ...mascota };
    this.displayDelete = true;
  }

  guardar(): void {
    if (this.mascotaSeleccionada?.id) {
      this.mascotasService.actualizarMascota(this.mascotaSeleccionada).subscribe({
        next: () => {
          this.cargarMascotas();
          this.displayEdit = false;
        },
        error: (err) => console.error('Error:', err)
      });
    } else {
      this.mascotasService.crearMascota(this.mascotaSeleccionada!).subscribe({
        next: () => {
          this.cargarMascotas();
          this.displayNew = false;
        },
        error: (err) => console.error('Error:', err)
      });
    }
  }

  eliminar(): void {
    if (this.mascotaSeleccionada?.id) {
      this.mascotasService.eliminarMascota(this.mascotaSeleccionada.id).subscribe({
        next: () => {
          this.cargarMascotas();
          this.displayDelete = false;
        },
        error: (err) => console.error('Error:', err)
      });
    }
  }

  verHistorial(mascota: Mascota): void {
    this.mascotaSeleccionada = { ...mascota };
    this.displayHistorial = true;
  }
}
