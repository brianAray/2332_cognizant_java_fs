import { AfterViewInit, Component, Input, OnChanges, OnDestroy, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-lifecycle-demo',
  imports: [],
  template: `

  <h3>Lifecycle Demo</h3>
  <p>Message: {{message}}</p>
  <p>Hooks fired: {{hooksFired.length}}<p>
  
  `,
  styles: ``,
})
export class LifecycleDemo implements OnInit, OnChanges, AfterViewInit, OnDestroy{
  @Input() message = '';
  hooksFired: string[] = []

  constructor(){
    console.log('1. Constructor - Class Instantiation');
    this.log('constructor');
  }

  ngOnInit(): void {
      console.log('2. ngOnInit - Component Initialized');
      this.log('ngOnInit');
      // Good place for HTTP calls
  }

  ngOnChanges(changes: SimpleChanges): void {
      console.log('3. ngOnChanges - Input changed:', changes);
      this.log('ngOnChanges');
  }

  ngAfterViewInit(): void {
      console.log('7. ngAfterViewInit - View Ready');
      // this.log('ngAfterViewInit');
  }

  ngOnDestroy(): void {
      console.log('12. ngOnDestroy - Cleanup');
      this.log('ngOnDestroy');
      // cleanup of components
      // unsubscribe from observables (essentially promises that are a stream of async data)
  }


  private log(hook: string): void {
    this.hooksFired.push(hook);
  }
}
