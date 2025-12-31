import { Component, inject, OnInit, signal } from '@angular/core';
import { DataService } from '../service/data-service';

@Component({
  selector: 'app-post-list-component',
  imports: [],
  template: `

  <ul>
  @for (post of posts(); track post.id) {
    
    <li>
      <h4>{{post.title}}</h4>
      <p>{{post.body}}</p>
      <button (click)="delete(post.id)">Delete</button>
    <li>
  }
  </ul>
  
  `,
  styles: ``,
})
export class PostListComponent implements OnInit{

  private dataService = inject(DataService);

  posts = signal([] as any[]);

  ngOnInit(): void {
    this.loadPosts();
  }

  loadPosts(): void {
    this.dataService.getPosts().subscribe({
      next: posts => {
        this.posts.set(posts);
      },
      error: err => {
        console.error(err);
      }
    })
  }

  delete(id: number): void {
    this.dataService.deletePost(id).subscribe({
      next: () => {
        this.posts.update((posts) => posts.filter(p => p.id !== id));
      }
    })
  }




}
