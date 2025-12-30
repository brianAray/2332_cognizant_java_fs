import { Component } from '@angular/core';

@Component({
  selector: 'app-template-demo',
  imports: [],
  template: `
  <!-- Section 1 - Interpolation -->

  <section>

    <h3>{{title}}</h3>

    <p>Price: {{formatPrice(price)}}</p>
    <p>Quantity: {{quantity}}</p>
    <p>Total: {{formatPrice(getTotal())}}</p>

    <p>Tags: {{tags.join(', ')}}</p>

  </section>

  <!-- Section 2 - Property Binding -->

  <section>

    <button [disabled]="isDisabled">{{isDisabled ? "Disabled" : "Enabled" }}</button>
    <button (click)="isDisabled = !isDisabled">Toggle State</button>

  </section>

  <!-- Section 3 - Event Binding -->

  <section>
    <div>
      <input (keyup)="handleKeyup($event)" placeholder="Press any key...">
      <p>Last key pressed: {{lastKey || "No Key Pressed"}}</p>
    </div>
  </section>

  <!-- Section 4 - Template References -->

  <section>

    <input #nameInput placeholder="Enter your name">
    <button (click)="greet(nameInput.value)">Greet</button>
    <p>Current Value: {{nameInput.value}}</p>

  </section>
  
  `,
  styles: ``,
})
export class TemplateDemo {

  // Interpolation
  title = 'Template Demo';
  price = 29.99;
  quantity = 3;
  isAvailable = true;

  user = {
    name: 'Mike',
    email: 'mike@email.com',
    role: 'Admin'
  };

  tags = ['Angular', 'Typescript', 'Frontend'];


  // Property Binding Data
  isDisabled = false;
  inputValue = 'Default Text';


  // Event Binding State
  lastKey = '';



  formatPrice(value: number): string {
    return `$${value.toFixed(2)}`;
  }

  getTotal(): number {
    return this.price * this.quantity;
  }


  // Event Handlers
  handleKeyup(event: KeyboardEvent): void {
    this.lastKey = event.key;
    console.log(`Key pressed: ${event.key}`);
  }


  greet(name: string): void {
    console.log(`Hello ${name}`);
  }
}
