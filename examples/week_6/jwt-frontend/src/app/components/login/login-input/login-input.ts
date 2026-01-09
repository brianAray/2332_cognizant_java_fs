import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-login-input',
  imports: [],
  template: `

  <input #username type="text" placeholder="Username">
  <input #password type="password" placeholder="Password">
  <button (click)="onSubmit(username.value, password.value)">Submit</button>
  
  `,
  styles: ``,
})
export class LoginInput {

  @Output() submit = new EventEmitter<any>();

  onSubmit(username: string, password: string){
    this.submit.emit({username, password});
  }

}
