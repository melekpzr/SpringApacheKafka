import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Messagedb } from './messagedb';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(private http:HttpClient) { }

  getDashboardMessage(): Observable<Messagedb[]>{
    return this.http.get<Messagedb[]>('http://localhost:8080/jsa/kafka/dashboard');
  }
}
