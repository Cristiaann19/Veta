import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import { FormsModule } from "@angular/forms";
import { CommonModule} from '@angular/common';
import { DialogModule} from 'primeng/dialog';
import { ButtonModule} from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { PaginatorModule } from 'primeng/paginator';
import { TableModule } from 'primeng/table';
import { Cita } from '../../../models/cita';
import { CitasService } from '../../../services/citas-service';

@Component({
  selector: 'app-citas',
    imports: [
        FormsModule, CommonModule, FormsModule, DialogModule, ButtonModule, InputTextModule, PaginatorModule, TableModule
    ],
  templateUrl: './citas.html',
})
export class Citas implements OnInit {
  citas: Cita[] = [];
  citasMostradas: Cita[] = [];
  citasFiltradas: Cita[] = [];
  terminoBusqueda: string = '';

  //modales
  displayEdit: boolean = false;
  displayDelete: boolean = false;
  displayNew: boolean = false;

  //cita seleccionada
  selectedCita: Cita = {} as Cita;

  //paginacion
  first: number = 0;
  rows: number = 8;

  constructor(private citaService: CitasService, private cdr: ChangeDetectorRef) {
  }

  ngOnInit(): void {
    this.listarCitas();
  }

  listarCitas(){
    this.citaService.listarCitas().subscribe({
      next: (data) => {
        this.citas = data;
        this.filtrar();
        this.cdr.detectChanges();
      },
      error: (err)=> console.error('Error',err)
    });
  }

  filtrar():void{
    const termino = this.terminoBusqueda.toLowerCase();
    this.citasFiltradas = this.citas.filter(c =>
      c.servicioNombre.toLowerCase().includes(termino)||
      c.mascotaNombre.toLowerCase().includes(termino) ||
      c.clienteNombre.toLowerCase().includes(termino));
    this.first = 0;
    this.actualizarVista();
  }
  onPageChange(event: any): void {
    this.first = event.first;
    this.actualizarVista();
  }

  actualizarVista(): void {
    this.citasMostradas = this.citasFiltradas.slice(this.first, this.first + this.rows);
  }

}
