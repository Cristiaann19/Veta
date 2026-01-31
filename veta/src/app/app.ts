import { Component, signal } from '@angular/core';
import { RouterOutlet, NavigationEnd, ActivatedRoute } from '@angular/router';
import { filter } from 'rxjs/operators';
import { Router } from '@angular/router';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
})

export class App {
  protected readonly title = signal('veteFrontend');
  titulo = '';
  constructor(private router: Router, private route: ActivatedRoute) {

    this.router.events
      .pipe(filter(event => event instanceof NavigationEnd))
      .subscribe(() => {

        let currentRoute = this.route.firstChild;
        while (currentRoute?.firstChild) {
          currentRoute = currentRoute.firstChild;
        }

        this.titulo = currentRoute?.snapshot.data['title'] || 'Dashboard';
      });
  }


}
