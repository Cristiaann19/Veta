import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { ChangeDetectorRef } from '@angular/core';

interface CitaHoy {
  id: number;
  fechaHora: string;
  mascotaNombre: string;
  servicioNombre: string;
  trabajadorNombre: string;
  estado: string;
}

interface DashboardData {
  citasHoy: number;
  clientesActivos: number;
  totalMascotas: number;
  ventasMes: number;
  citasDeHoy: CitaHoy[];
}

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard.html',
})
export class Dashboard implements OnInit {

  data: DashboardData = {
    citasHoy: 0,
    clientesActivos: 0,
    totalMascotas: 0,
    ventasMes: 0,
    citasDeHoy: []
  };

  constructor(private http: HttpClient, private cdr : ChangeDetectorRef) {}

  ngOnInit(): void {
    this.cargarDashboard();
  }

  cargarDashboard(): void {
    this.http.get<DashboardData>('http://localhost:8080/api/citas/dashboard')
      .subscribe({
        next: (data) => {
          this.data = { ...data }; // ← spread para forzar nuevo objeto
          this.cdr.detectChanges(); // ← forzar re-render
        },
        error: (err) => console.error('Error al cargar dashboard:', err)
      });
  }

  getEstadoClass(estado: string): string {
    const clases: Record<string, string> = {
      'PENDIENTE':  'bg-yellow-100 text-yellow-700',
      'CONFIRMADA': 'bg-blue-100 text-blue-700',
      'REALIZADA':  'bg-green-100 text-green-700',
      'CANCELADA':  'bg-red-100 text-red-700'
    };
    return clases[estado] ?? 'bg-gray-100 text-gray-700';
  }

  formatHora(fechaHora: string): string {
    return new Date(fechaHora).toLocaleTimeString('es-PE', {
      hour: '2-digit',
      minute: '2-digit'
    });
  }
}
