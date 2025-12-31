import { Component, computed, signal } from '@angular/core';

@Component({
  selector: 'app-signal-example',
  imports: [],
  template: `

  <h1>Signal Example</h1>
  <p>Count: {{count()}}</p>
  <button (click)="updateValue()">Set to 5</button>
  <button (click)="increment()">Increment</button>

  <p>Double: {{doubled()}}</p>
  <p>is Even: {{isEven() ? 'Yes' : 'No'}}</p>
  
  `,
  styles: ``,
})
export class SignalExample {

  // Create a signal
  count = signal(0);

  // Computed signals (derived state)
  doubled = computed(() => this.count() * 2);
  isEven = computed(() => this.count() % 2 === 0);

  updateValue() {
    this.count.set(5); // set to 5
  }

  increment(){
    this.count.update(c => c + 1); // increment
  }


}
