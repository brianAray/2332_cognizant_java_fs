import { Component, EventEmitter, Input, Output } from '@angular/core';
import { User } from '../parent-example/user';

@Component({
  selector: 'app-child-example',
  imports: [],
  template: `

  @if(user){
    <h2>{{user.name}}</h2>
    <p>{{user.email}}<p>
    
    <div>
      <button (click)="onDelete()">Delete</button>
      <button (click)="onSelect()">Select</button>
    </div>
  }@else {
    <h3>User not provided</h3>
    <div>
      <p>{{value}}</p>
      <button (click)="increment()">+</button>
      <button (click)="decrement()">-</button>

    </div>
  }
  
  `,
  styles: ``,
})
export class ChildExample {

  @Input() value!: number;

  @Output() valueChange = new EventEmitter<number>();

  increment(): void {
    this.value++;
    this.valueChange.emit(this.value);
  }

  decrement(): void{
    this.value--;
    this.valueChange.emit(this.value);
  }

  @Input() user!: User;

  // Emit Events UP to parent
  @Output() delete = new EventEmitter<number>();
  @Output() select = new EventEmitter<User>();

  onDelete(): void {
    this.delete.emit(this.user.id);
  }

  onSelect(): void {
    this.select.emit(this.user);
  }

}
