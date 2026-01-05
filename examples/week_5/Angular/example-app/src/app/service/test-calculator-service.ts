import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TestCalculatorService {
  private http = inject(HttpClient);
  getUsers(): Observable<any[]>{
    return this.http.get<any[]>('/api/users');
  }
  add(a: number, b: number): number {
    return a + b;
  }
  multiply(a: number, b: number): number{
    return a * b;
  } 
}
