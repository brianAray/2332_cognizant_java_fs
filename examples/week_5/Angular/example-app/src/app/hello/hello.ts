import { Component } from '@angular/core';

@Component({
  selector: 'app-hello',
  imports: [],
  template: `
    <h1>{{username}}</h1>

    <p>Today is {{currentDate.toLocaleDateString()}} </p>

    @if(isLoggedIn){
      <p>You are logged in</p>
    }

    <button (click)="incrementClicks()">Click Me</button>

    <p>Clicks: {{clickCount}}</p>

  `,
  styles: ``,
})
export class Hello {

  username = "Angular Developer";
  currentDate = new Date();
  isLoggedIn = false;
  clickCount = 0;

  // methods
  incrementClicks(): void {
    this.clickCount++;
  }
}
