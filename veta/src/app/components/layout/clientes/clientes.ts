import { Component, OnInit, inject, ChangeDetectorRef } from '@angular/core';
import { TableModule } from 'primeng/table';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Cliente } from '../../../models/cliente';
import { ClienteService } from '../../../services/cliente-service';
import {Paginator} from 'primeng/paginator';

@Component({
  selector: 'app-clientes',
  standalone: true,
  imports: [TableModule, CommonModule, FormsModule, Paginator],
  templateUrl: './clientes.html'
})
export class Clientes implements OnInit {

  clientes: Cliente[] = [];
  clientesMostrados: Cliente[] = [];
  clientesFiltrados: Cliente[] = [];
  terminoBusqueda: string = '';

  //modales
  displayEdit : boolean = false;
  displayDelete : boolean = false;
  displayNew : boolean = false;

  /*enfermedad seleccionada*/
  selectedCliente: Cliente  = {} as Cliente;

  //Paginacion
  first: number = 0
  rows: number = 8

  constructor(private clienteService: ClienteService, private cdr: ChangeDetectorRef) {
  }

  ngOnInit(): void {
    this.cargarClientes();
  }

  cargarClientes(): void {
    this.clienteService.listarClientes().subscribe({
      next: (data) => {
        setTimeout(() => {
          this.clientes = data;
          this.filtrar();
          this.cdr.detectChanges();
        }, 0);
      },
      error: (err) => console.error('Error al cargar clientes:', err)
    });
  }

  filtrar(): void {
    const termino = this.terminoBusqueda.toLowerCase();
    this.clientesFiltrados = this.clientes.filter(c =>
      c.nombres.toLowerCase().includes(termino) ||
      c.apellidos.toLowerCase().includes(termino) ||
      c.dni.includes(termino) ||
      (c.correo && c.correo.toLowerCase().includes(termino))
    );
  }

  onPageChange(event : any):void{
    this.first = event.first;
    this.actualizarVista();
  }

  actualizarVista():void{
    this.clientesMostrados=this.clientesFiltrados.slice(this.first,this.first + this.rows);
  }

  // Métodos para botones (Próximamente diálogos)
  abrirNuevo() { console.log('Nuevo cliente'); }
  abrirEditar(cliente: Cliente) { console.log('Editar', cliente); }
  confirmarEliminar(cliente: Cliente) { console.log('Eliminar', cliente); }

}
