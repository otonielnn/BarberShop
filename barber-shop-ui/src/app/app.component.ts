import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router, RouterOutlet } from '@angular/router';
import { CardHeaderComponent } from './commons/components/card-header/card-header.component';
import { filter, map, Subscription } from 'rxjs';
import { MenuBarComponent } from './commons/components/menu-bar/menu-bar.component';

@Component({
  selector: 'app-root',
  imports: [
    RouterOutlet,
    CardHeaderComponent,
    MenuBarComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit, OnDestroy{
  title = 'barber-shop-ui';

  private routeSubcription?: Subscription;

  constructor(private readonly router: Router, private readonly activated: ActivatedRoute) {
  }

  ngOnDestroy(): void {
    if (this.routeSubcription) {
      this.routeSubcription.unsubscribe();
    }
  }

  ngOnInit(): void {
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd),
      map(() => this.getRouteTitle(this.activated))
      ).subscribe(title => this.title = title)
  }

  private getRouteTitle(route: ActivatedRoute): string {
    let child = route;
    while (child.firstChild) {
      child = child.firstChild
    }
    return child.snapshot.data['title'] || 'Default title';
  }
}
