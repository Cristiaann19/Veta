import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { DialogModule } from 'primeng/dialog';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { PaginatorModule } from 'primeng/paginator';
import { ChangeDetectorRef } from '@angular/core';
import { EnfermedadesService } from '../../../services/enfermedades';
import { Enfermedad } from '../../../models/enfermedad';
import { TableModule } from "primeng/table";

@Component({
  selector: 'app-enfermedades',
  standalone: true,
  imports: [CommonModule, FormsModule, DialogModule, ButtonModule, InputTextModule, PaginatorModule, TableModule],
  templateUrl: './enfermedades.html',
})
export class Enfermedades implements OnInit {
  enfermedades: Enfermedad[] = [];
  enfermedadesFiltradas: Enfermedad[] = [];
  enfermedadesMostradas: Enfermedad[] = [];

  //filtro
  terminoBusqueda: string = '';

  //modales
  displayEdit: boolean = false;
  displayDelete: boolean = false;
  displayNew: boolean = false;

  //enfermedad seleccionada
  selectedEnfermedad: Enfermedad = {} as Enfermedad;

  //paginacion
  first: number = 0;
  rows: number = 8;

  constructor(private enfermedadesService: EnfermedadesService, private cdr: ChangeDetectorRef) { }

  ngOnInit(): void {
    this.cargarEnfermedades();
  }

  cargarEnfermedades(): void {
    this.enfermedadesService.listarEnfermedades().subscribe({
      next: (data) => {
        this.enfermedades = data;
        this.filtrar();
        this.cdr.detectChanges();
      },
      error: (err) => console.error('Error:', err)
    });
  }

  filtrar(): void {
    const termino = this.terminoBusqueda.toLowerCase();

    this.enfermedadesFiltradas = this.enfermedades.filter(e => {
      const coincideNombre = e.nombre.toLowerCase().includes(termino);
      const coincideEspecie = e.especies && e.especies.some(especie =>
        especie.nombre.toLowerCase().includes(termino)
      );
      return coincideNombre || coincideEspecie;
    });

    this.first = 0;
    this.actualizarVista();
  }

  actualizarVista(): void {
    this.enfermedadesMostradas = this.enfermedadesFiltradas.slice(this.first, this.first + this.rows);
  }

  onPageChange(event: any): void {
    this.first = event.first;
    this.actualizarVista();
  }
}
