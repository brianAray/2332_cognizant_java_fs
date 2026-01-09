import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { UserService } from './user-service';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private http = inject(HttpClient);
  private userService = inject(UserService);
  private api = `http://localhost:8080/api`;

  // Login
  login(username: string, password: string){
    this.http.post(`${this.api}/auth/login`, {username, password}).subscribe({
      next: (response: any) => {
        this.userService.user.set({username: response.username, id: response.userId, empId: response.employeeId})
        this.userService.token.set(response.token);
      }
    })
  }
  
}
