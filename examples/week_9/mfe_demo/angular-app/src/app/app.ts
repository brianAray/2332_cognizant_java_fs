import { Component, signal } from '@angular/core';

interface Product {
  id: number;
  name: string;
  price: number;
  description: string;
}

@Component({
  selector: 'app-root',
  standalone: false,
  template: `
    <h1>Product Catalogue</h1>
    @for(product of products; track product.id){
      <div>
        <h3>{{product.name}}</h3>
        <p>{{product.description}}</p>
        <h5>{{product.price | currency}}</h5>
        <button (click)="addToCart(product)">Add to Cart</button>
      </div>
    }

    <!-- <div *ngFor="let product of products">
        <h3>{{product.name}}</h3>
        <p>{{product.description}}</p>
        <h5>{{product.price | currency}}</h5>
    </div> -->

    @if(cartCount){
      <h3>Cart: {{cartCount}} Items</h3>
    }@else {
      <h3>Cart is empty</h3>
    }

    <!-- <h3 *ngIf="cartCount">Cart: {{cartCount}}</h3> -->
    
  `,
  styleUrl: './app.css'
})
export class App {
  products: Product[] = [
    {id: 1, name: "Laptop", price: 1000.00, description: "This is a laptop"},
    {id: 2, name: "Mouse", price: 30.00, description: "This is a mouse"},
    {id: 3, name: "Keyboard", price: 100.00, description: "This is a keyboard"},
  ]

  cartCount = 0;

  addToCart(product: Product){
    this.cartCount++;
    window.dispatchEvent(new CustomEvent('cart:updated', {
      detail: {count: this.cartCount, product}
    }))
  }

}
