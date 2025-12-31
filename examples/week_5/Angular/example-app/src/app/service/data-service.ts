import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class DataService {

  private http = inject(HttpClient);
  private api = "https://jsonplaceholder.typicode.com/";

  // GET
  getPosts(){
    return this.http.get<any[]>(`${this.api}/posts`);
  }

  getPost(id: number){
    return this.http.get<any[]>(`${this.api}/posts/${id}`);
  }

  // PUT
  updatePost(id: number, post: any){
    return this.http.put<any>(`${this.api}/posts/${id}`, post);
  }

  // DELETE
  deletePost(id: number){
    return this.http.delete<void>(`${this.api}/posts/${id}`);
  }
  
}
