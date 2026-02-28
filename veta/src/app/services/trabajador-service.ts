import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Trabajador } from '../models/trabajador';

@Injectable({
  providedIn: 'root',
})
export class TrabajadorService {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/trabajadores';

  // GET: listarActivos()
  listarTrabajadores(): Observable<Trabajador[]> {
    return this.http.get<Trabajador[]>(this.apiUrl);
  }

  // POST: guardar()
  // Gracias a cascade = CascadeType.ALL en Java, 
  // si envías el objeto usuario dentro del trabajador, se creará ambos.
  guardarTrabajador(trabajador: Trabajador): Observable<Trabajador> {
    return this.http.post<Trabajador>(this.apiUrl, trabajador);
  }
}
