import { Component } from '@angular/core';
import { User } from './user';
import { ChildExample } from "../child-example/child-example";

@Component({
  selector: 'app-parent-example',
  imports: [ChildExample],
  template: `
  
  <h1>Parent Component</h1>
  @if(selectedUser){
  <p>Selected: {{selectedUser.name}}</p>
  }@else {
    <p>User not selected</p>
  }

  @for (user of users; track user.id) {
    <!-- <app-child-example
      [user]="user"
      (delete)="handleDelete($event)"
      (select)="handleSelect($event)"



    /> -->
  }

  <h4>Quantity: {{quantity}}</h4>
  <!-- <app-child-example
      [value]="quantity"
      (valueChange)="quantity = $event"
    > -->
  <app-child-example
    [(value)]="quantity"/>
  
  `,
  styles: ``,
})
export class ParentExample {

  quantity: number = 0;

  users: User[]= [
    {id: 1, name: "Mike", email: "mike@email.com"},
    {id: 2, name: "John", email: "john@email.com"},
    {id: 3, name: "Jane", email: "jane@email.com"}
  ];

  selectedUser: User | null = null;

  handleDelete(userId: number): void{
    this.users = this.users.filter(u => u.id !== userId);
  }

  handleSelect(user: User): void {
    this.selectedUser = user;
  }


}

