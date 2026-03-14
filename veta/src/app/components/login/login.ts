import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.html',
})
export class Login {

  tabActivo: 'login' | 'register' = 'login';
  mostrarPassword = false;
  mostrarPasswordReg = false;

  // Alertas
  errorMsg: string = '';
  successMsg: string = '';

  // Login
  loginData = {
    username: '',
    password: '',
    rememberMe: false
  };

  // Registro
  registerData = {
    nombres: '',
    apellidos: '',
    dni: '',
    telefono: '',
    direccion: '',
    correo: '',
    password: ''
  };

  constructor(private authService: AuthService,private http: HttpClient, private router: Router) {}

  cambiarTab(tab: 'login' | 'register'): void {
    this.tabActivo = tab;
    this.errorMsg = '';
    this.successMsg = '';
  }

  iniciarSesion(): void {
    this.errorMsg = '';
    this.authService.login(this.loginData.username, this.loginData.password)
      .subscribe({
        next: (res) => {
          this.authService.guardarSesion(res);
          this.router.navigate(['/dashboard']);
        },
        error: () => {
          this.errorMsg = 'Usuario o contraseña incorrectos.';
        }
      });
  }

  registrarse(): void {
    this.errorMsg = '';
    this.http.post('http://localhost:8080/api/auth/register', this.registerData)
      .subscribe({
        next: () => {
          this.successMsg = '¡Cuenta creada correctamente! Ya puedes iniciar sesión.';
          this.tabActivo = 'login';
        },
        error: (err) => {
          this.errorMsg = err.error?.message ?? 'Error al crear la cuenta.';
        }
      });
  }

}
