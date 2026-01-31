import { Routes } from '@angular/router';
import { Layout } from './components/layout/layout'; // Tu componente con Sidebar
import { Login } from './components/login/login';
import { Dashboard } from './components/layout/dashboard/dashboard';
import { Clientes } from './components/layout/clientes/clientes';
import { Mascotas } from './components/layout/mascotas/mascotas';
import { Vacunas } from './components/layout/vacunas/vacunas';
import { Enfermedades } from './components/layout/enfermedades/enfermedades';
import { Trabajadores } from './components/layout/trabajadores/trabajadores';
import { Productos } from './components/layout/productos/productos';
import { Ventas } from './components/layout/ventas/ventas';
import { Citas } from './components/layout/citas/citas';
import { Servicios } from './components/layout/servicios/servicios';
import { Inicio } from './components/inicio/inicio';

export const routes: Routes = [
    { path: 'login', component: Login, data: { title: 'Iniciar Sesión' } },
    { path: 'inicio', component: Inicio, data: { title: 'Inicio' } },

    {
        path: '',
        component: Layout,
        children: [
            { path: 'dashboard', component: Dashboard, data: { title: 'Dashboard' } },
            { path: 'clientes', component: Clientes, data: { title: 'Gestion de Clientes' } },
            { path: 'mascotas', component: Mascotas, data: { title: 'Gestion de Mascotas' } },
            { path: 'vacunas', component: Vacunas, data: { title: 'Gestion de Vacunas' } },
            { path: 'enfermedades', component: Enfermedades, data: { title: 'Gestion de Enfermedades' } },
            { path: 'trabajadores', component: Trabajadores, data: { title: 'Gestion de Trabajadores' } },
            { path: 'productos', component: Productos, data: { title: 'Gestion de Productos' } },
            { path: 'ventas', component: Ventas, data: { title: 'Gestion de Ventas' } },
            { path: 'citas', component: Citas, data: { title: 'Gestion de Citas' } },
            { path: 'servicios', component: Servicios, data: { title: 'Gestion de Servicios' } },
            { path: '', redirectTo: 'dashboard', pathMatch: 'full' }
        ]
    },

    // COMODÍN (Si la ruta no existe, va al login o dashboard)
    { path: '**', redirectTo: 'login' }
];