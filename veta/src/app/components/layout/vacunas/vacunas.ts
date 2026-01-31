import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common'; // IMPORTANTE
import { Vacuna } from '../../../models/vacuna';
import { VacunaService } from '../../../services/vacuna';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-vacunas',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './vacunas.html',
})
export class Vacunas implements OnInit {
  vacunas: Vacuna[] = [];

  constructor(private vacunaService: VacunaService, private cdr: ChangeDetectorRef) { }

  ngOnInit(): void {
    this.cargarVacunas();
  }

  cargarVacunas(): void {
    this.vacunaService.listarVacunas().subscribe({
      next: (data) => {
        this.vacunas = data;
        this.cdr.detectChanges();
      },
      error: (err) => console.error('Error:', err)
    });
  }

  eliminar(id: number): void {
    if (confirm('¿Seguro que deseas eliminar esta vacuna?')) {
      this.vacunaService.eliminarVacuna(id).subscribe(() => this.cargarVacunas());
    }
  }

  editar(vacuna: Vacuna): void {
    console.log('Editando:', vacuna);
  }

  nuevaVacuna(): void {
    console.log('Navegando a formulario de nueva vacuna');
  }
}