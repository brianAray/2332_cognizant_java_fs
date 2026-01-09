import { Component, inject } from '@angular/core';
import { LoginInput } from "../login-input/login-input";
import { ApiService } from '../../../services/api-service';

@Component({
  selector: 'app-login-manager',
  imports: [LoginInput],
  template: `

  <h1>Login Page</h1>
  <app-login-input
    (submit)="handleSubmit($event)"
  />
  
  `,
  styles: ``,
})
export class LoginManager {

  private apiService = inject(ApiService);

  handleSubmit(loginInput: any){
    this.apiService.login(loginInput.username, loginInput.password);
  }

}
