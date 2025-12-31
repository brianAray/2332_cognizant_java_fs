import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { ProductService } from '../service/product-service';

@Component({
  selector: 'app-cart-component',
  imports: [CommonModule],
  template: `
  <header>
    <h3>Cart: {{itemCount()}} items</h3>
    <h3>Total: {{total() | currency}} items</h3>
  </header>
  
  `,
  styles: ``,
})
export class CartComponent {
  public productService = inject(ProductService);

  readonly itemCount = this.productService.itemCount;
  readonly total = this.productService.total;

}
