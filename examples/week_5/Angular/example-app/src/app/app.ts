import { Component } from '@angular/core';

import { LifecycleDemo } from "./lifecycle-demo/lifecycle-demo";

@Component({
  selector: 'app-root',
  imports: [LifecycleDemo],
  template: `
    <h1>Hello</h1>
    <!-- <app-hello/> -->
    <!-- <app-template-demo/> -->
    <app-lifecycle-demo/>
  `,
  styles: ``
})
export class App {
  
}
