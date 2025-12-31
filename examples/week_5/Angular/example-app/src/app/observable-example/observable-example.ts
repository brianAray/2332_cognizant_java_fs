import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { catchError, debounceTime, distinctUntilChanged, filter, from, interval, map, of, Subject, switchMap, tap, timer } from 'rxjs';

@Component({
  selector: 'app-observable-example',
  imports: [CommonModule],
  template: `

  <button (click)="pipeExample()">Pipe Example</button>

  <input #search (input)="onSearch(search.value)">
  <ul>
    @if(results$ | async; as results){
      @for(result of results; track $index){
        <li>{{result.title}}<li>
      }@empty {
        <li>No results found</li>
      }
    }@else {
      <p>Loading results...</p>
    }

  </ul>
  
  `,
  styles: ``,
})
export class ObservableExample {

  // from static variables
  numbers$ = of(1, 2, 3);
  array$ = from([1, 2, 3]);

  // from time
  timer$ = interval(1000); // emit every second
  delayed$ = timer(2000); // emit once after 2 seconds

  subscription = this.numbers$.subscribe({
    next: value => console.log('value: ', value),
    error: err => console.error(err),
    complete: () => console.log('Done!')
  })

  pipeExample(){
    this.numbers$.pipe(
      filter(n => n > 2), // keeps only numbs > 2
      map(n => n * 10), // multiply by 10
      tap(n => console.log(n)) // side effect (log value)
    ).subscribe(result => {
      console.log(result);
    })
  }

  private http = inject(HttpClient);

  private searchSubject = new Subject<string>();

  results$ = this.searchSubject.pipe(
    debounceTime(300), // wait for a pause
    distinctUntilChanged(), //skip duplicates
    filter(term => term.length >= 2), // keep only matching terms
    switchMap(term => this.http.get<any>(`https://dummyjson.com/products/search?q=${term}`).pipe(
      map(response => response.products || []), // map to arrays
      catchError(err => {
        // handle errors
        console.error(err);
        return of([]);
      })
    ))
  )

  onSearch(term: string): void{
    this.searchSubject.next(term);
  }




}
