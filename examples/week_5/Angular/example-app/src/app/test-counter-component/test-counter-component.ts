import { Component } from '@angular/core';

@Component({
  selector: 'app-test-counter-component',
  imports: [],
  template: `
    <p>Count: {{count}}</p>
    <button (click)="increment()">+</button>
  `,
  styles: ``,
})
export class TestCounterComponent {
  count = 0;

  increment(): void {
      this.count++;
  }
}
