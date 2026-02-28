import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { DialogModule } from 'primeng/dialog';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { PaginatorModule } from 'primeng/paginator';
import { TableModule } from 'primeng/table';
import { Trabajador } from '../../../models/trabajador';
import { TrabajadorService } from '../../../services/trabajador-service';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-trabajadores',
  imports: [CommonModule, FormsModule, DialogModule, ButtonModule, InputTextModule, PaginatorModule, TableModule],
  templateUrl: './trabajadores.html',
  standalone: true
})
export class Trabajadores implements OnInit {
  trabajadores: Trabajador[] = [];
  trabajadoresMostrados: Trabajador[] = [];
  trabajadoresFiltrados: Trabajador[] = [];
  terminoBusqueda: string = '';

  //modales
  displayEdit: boolean = false;
  displayDelete: boolean = false;
  displayNew: boolean = false;

  //enfermedad seleccionada
  selectedTrabajador: Trabajador = {} as Trabajador;

  //paginacion
  first: number = 0;
  rows: number = 8;

  constructor(private trabajadorService: TrabajadorService, private cdr: ChangeDetectorRef) { }

  ngOnInit(): void {
    this.listarTrabajadores();
  }

  listarTrabajadores() {
    this.trabajadorService.listarTrabajadores().subscribe({
      next: (data) => {
        this.trabajadores = data;
        this.filtrar();
        this.cdr.detectChanges();
      },
      error: (err) => console.error('Error:', err)
    });
  }

  filtrar(): void {
    const termino = this.terminoBusqueda.toLowerCase();
    this.trabajadoresFiltrados = this.trabajadores.filter(t =>
      t.nombres.toLowerCase().includes(termino) ||
      t.apellidos.toLowerCase().includes(termino) ||
      t.dni.includes(termino) ||
      t.cargo.toLowerCase().includes(termino)
    );
    this.actualizarVista();
  }

  onPageChange(event: any): void {
    this.first = event.first;
    this.actualizarVista();
  }

  actualizarVista(): void {
    this.trabajadoresMostrados = this.trabajadoresFiltrados.slice(this.first, this.first + this.rows);
  }

  abrirEditar(trabajador: Trabajador): void {
    this.selectedTrabajador = { ...trabajador };
    this.displayEdit = true;
  }

  confirmarEliminar(trabajador: Trabajador): void {
    this.selectedTrabajador = trabajador;
    this.displayDelete = true;
  }

  abrirNuevo(): void {
    this.selectedTrabajador = {} as Trabajador;
    this.displayNew = true;
  }
}
