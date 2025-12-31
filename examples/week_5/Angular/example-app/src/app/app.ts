import { Component } from '@angular/core';

import { LifecycleDemo } from "./lifecycle-demo/lifecycle-demo";
import { ParentExample } from "./parent-example/parent-example";
import { RouterOutlet, RouterLinkWithHref, RouterLinkActive, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, LifecycleDemo, ParentExample, RouterLinkWithHref, RouterLinkActive],
  template: `

    <nav>
      <a routerLink="/hello" routerLinkActive="active">Hello</a>
      <a routerLink="/parent" routerLinkActive="active">Parent</a>
      <a routerLink="/products" routerLinkActive="active">Products</a>
      <a routerLink="/signals" routerLinkActive="active">Signals</a>
      <a routerLink="/http" routerLinkActive="active">HTTP</a>
      <a routerLink="/observable" routerLinkActive="active">Observable</a>
    <nav>

    <main>
      <input type="number" (input)="updateParam($event)"/>
      <input type="button" value="Search" (click)="navigateToParams()">
      <router-outlet></router-outlet>
    </main>
  `,
  styles: ``
})
export class App {
  paramId = '';

  constructor(private router: Router){}

  updateParam(event: Event): void {
    const input = event.target as HTMLInputElement;
    this.paramId = input.value;
  }

  navigateToParams(): void {
    this.router.navigate(['/access-params', this.paramId]);
  }
}
