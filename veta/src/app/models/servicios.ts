export interface Servicio {
    id: number;
    nombre: string;
    descripcion: string;
    precio: number;
    estado: 'ACTIVO' | 'INACTIVO';
    icono: string;
}