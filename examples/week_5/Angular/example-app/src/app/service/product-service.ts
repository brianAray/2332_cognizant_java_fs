import { computed, Injectable, Signal, signal } from '@angular/core';
import { Item } from '../product-list-component/Item';

@Injectable({
  providedIn: 'root', // Singleton for the entire app
})
export class ProductService {

  private items = signal<Item[]>([]);
  
  readonly cartItems = this.items.asReadonly();

  readonly itemCount: Signal<number> = computed(() => this.items().reduce((sum, item) => sum + (item.quantity ? item.quantity : 0), 0));

  readonly total: Signal<number> = computed(() => this.items().reduce((sum, item) => sum + (item.price * (item.quantity ? item.quantity : 0)), 0))

  // methods
  addItem(item: Omit<Item, 'quantity'>): void {
    const existing = this.items().find(i => i.id === item.id);

    if(existing){
      this.updateQuantity(item.id, (existing.quantity ? existing.quantity : 0)  + 1);
    }else{
      this.items.update(items => [...items, {...item, quantity: 1}]);
    }
  }

  updateQuantity(id: number, quantity: number): void {
    this.items.update(items => items.map(item => item.id === id ? {...item, quantity} : item));
  }

}
