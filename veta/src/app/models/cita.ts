export interface Cita {
  id?: number;
  estado: 'PENDIENTE' | 'CONFIRMADA' | 'REALIZADA' | 'CANCELADA';
  fechaHora: string;
  motivo: string;
  precioAcordado: number;
  servicioId: number;
  servicioNombre: string;

  // ✅ Nuevos campos
  mascotaId: number;
  mascotaNombre: string;

  clienteId: number;
  clienteNombre: string;

  trabajadorId: number;
  trabajadorNombre: string;
}
