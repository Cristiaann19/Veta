import { Cliente } from './cliente';

export interface Mascota {
    id?: number;
    nombre: string;
    especie: string;
    raza: string;
    sexo: string;
    edad: string;
    peso: number;
    observaciones?: string;
    cliente?: Cliente;
}
