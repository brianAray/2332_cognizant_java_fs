import { Component, inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-access-params-example',
  imports: [],
  template: `

  <h1>Path param: {{paramId}}</h1>
  <button (click)="goBackHome()">Back</button>
  
  `,
  styles: ``,
})
export class AccessParamsExample {

  private route = inject(ActivatedRoute);
  private router = inject(Router);

  paramId = '';

  constructor(){
    this.paramId = this.route.snapshot.paramMap.get('id') || '';
  }

  goBackHome(): void {
    this.router.navigate(['/']);
  }

}
