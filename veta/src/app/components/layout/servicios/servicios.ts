import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Servicio } from '../../../models/servicios';
import { ServiciosService } from '../../../services/servicios';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { DialogModule } from 'primeng/dialog';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { PaginatorModule } from 'primeng/paginator';
import { TableModule } from 'primeng/table';

@Component({
  selector: 'app-servicios',
  imports: [CommonModule, FormsModule, DialogModule, ButtonModule, InputTextModule, PaginatorModule, TableModule],
  templateUrl: './servicios.html'
})
export class Servicios implements OnInit {
  servicios: Servicio[] = [];
  serviciosFiltrados: Servicio[] = [];
  serviciosMostrados: Servicio[] = [];

  terminoBusqueda: string = '';

  //modales
  displayEdit: boolean = false;
  displayDelete: boolean = false;
  displayNew: boolean = false;

  selectedServicio: Servicio = {} as Servicio;

  //Paginacion
  first: number = 0;
  rows: number = 10;

  constructor(private servicioService: ServiciosService, private cdr: ChangeDetectorRef) { }

  ngOnInit(): void {
    this.cargarServicios();
  }

  cargarServicios(): void {
    this.servicioService.listar().subscribe({
      next: (data) => {
        this.servicios = data;
        this.filtrar();
        this.cdr.detectChanges();
      },
      error: (err) => console.error('Error: ', err)
    })
  }

  filtrar(): void {
    this.serviciosFiltrados = this.servicios.filter(v =>
      v.nombre.toLocaleLowerCase().
        includes(this.terminoBusqueda.toLocaleLowerCase()));
    this.first = 0;
    this.actualizarVista();
  }
  actualizarVista(): void {
    this.serviciosMostrados = this.serviciosFiltrados.slice(this.first, this.first + this.rows);
  }

  onPageChange(event: any): void {
    this.first = event.first;
    this.rows = event.rows;
    this.actualizarVista();
  }
}
