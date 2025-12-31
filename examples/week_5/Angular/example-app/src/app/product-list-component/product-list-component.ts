import { Component, inject } from '@angular/core';
import { ProductService } from '../service/product-service';
import { Item } from './Item';
import { CommonModule } from '@angular/common';
import { CartComponent } from "../cart-component/cart-component";

@Component({
  selector: 'app-product-list-component',
  imports: [CommonModule, CartComponent],
  template: `

  <app-cart-component/>
  @for (item of items; track item.id) {
    {{item.name}} - {{item.price | currency}}
    <button (click)="addToCart(item)">Add to cart</button>
  }
  
  `,
  styles: ``,
})
export class ProductListComponent {

  private productService = inject(ProductService);

  items: Item[] = [
    {id: 1, name: 'Laptop', price: 999},
    {id: 2, name: 'Phone', price: 599},
    {id: 3, name: 'Tablet', price: 499}
  ]

  addToCart(item: Item): void {
    // add item to cart
    this.productService.addItem(item);
  }

}
