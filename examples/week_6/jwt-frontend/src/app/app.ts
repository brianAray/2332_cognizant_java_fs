import { Component, inject, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoginManager } from "./components/login/login-manager/login-manager";
import { UserService } from './services/user-service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, LoginManager],
  template: `

  <h1>Homepage</h1>

  <h3>Current Token: {{userService.token()}}</h3>
  <h3>Currently logged in user: {{userService.user().username}}</h3>

  <app-login-manager/>
  
  `,
  styles: ``
})
export class App {

  public userService = inject(UserService);

}
