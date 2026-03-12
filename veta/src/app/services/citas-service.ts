import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Cita} from '../models/cita';

@Injectable({
  providedIn: 'root',
})
export class CitasService {
  private http = inject(HttpClient)
  private apiUrl = 'http://localhost:8080/api/citas'

  //get
  listarCitas():Observable<Cita[]>{
    return this.http.get<Cita[]>(this.apiUrl);
  }
}
