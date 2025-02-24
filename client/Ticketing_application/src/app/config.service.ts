import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Configuration } from './vendor';
import { Observable } from 'rxjs';

@Injectable({
  providedIn:'root',
})
export class ConfigService {
  private apiServerUrl:string;
  constructor(private http:HttpClient) { 
    this.apiServerUrl='http://localhost:8080/'

  }

  public addConfiguration(config:Configuration){
    
    
    return this.http.post<Configuration>(this.apiServerUrl+'add',config,{headers:new HttpHeaders().set('Content-Type', 'application/json')});
  }

  public findAll(): Observable<Configuration[]> {
    return this.http.get<Configuration[]>(`${this.apiServerUrl}findall`);
  }
  

}
