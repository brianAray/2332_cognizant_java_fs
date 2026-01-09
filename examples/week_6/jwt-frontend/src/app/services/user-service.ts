import { Injectable, signal } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  
  public user: any = signal({});
  public token = signal("");

}
