import { Component, OnInit, inject, ChangeDetectorRef } from '@angular/core';
import { TableModule } from 'primeng/table';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Cliente } from '../../../models/cliente';
import { ClienteService } from '../../../services/cliente-service';

@Component({
  selector: 'app-clientes',
  standalone: true,
  imports: [TableModule, CommonModule, FormsModule],
  templateUrl: './clientes.html'
})
export class Clientes implements OnInit {
  private clienteService = inject(ClienteService);
  private cdr = inject(ChangeDetectorRef);

  clientes: Cliente[] = [];
  clientesFiltrados: Cliente[] = [];
  terminoBusqueda: string = '';

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

  // Métodos para botones (Próximamente diálogos)
  abrirNuevo() { console.log('Nuevo cliente'); }
  abrirEditar(cliente: Cliente) { console.log('Editar', cliente); }
  confirmarEliminar(cliente: Cliente) { console.log('Eliminar', cliente); }
}