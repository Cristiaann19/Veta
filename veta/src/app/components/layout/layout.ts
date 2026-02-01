import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from "@angular/router";
import { RouterLink } from "@angular/router";
import { RouterLinkActive } from "@angular/router";
import { CommonModule } from '@angular/common';
import { Router, NavigationEnd, ActivatedRoute } from '@angular/router';
import { filter, map, mergeMap } from 'rxjs/operators';

@Component({
  selector: 'app-layout',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive, CommonModule],
  templateUrl: './layout.html',
})
export class Layout implements OnInit {
  titulo: string = 'Dashboard';

  constructor(private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd),
      map(() => this.activatedRoute),
      map(route => {
        while (route.firstChild) route = route.firstChild;
        return route;
      }),
      mergeMap(route => route.data)
    ).subscribe(data => {
      this.titulo = data['title'] || 'Veterinaria';
    });
  }
}