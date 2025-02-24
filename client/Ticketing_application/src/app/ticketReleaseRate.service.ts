import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

import {interval, Observable, switchMap} from "rxjs";

@Injectable({
  providedIn: 'root',
})
export class TicketReleaseRateService {


  private apiUrl='http://localhost:8080/api/ticket-release';


  constructor(private http:HttpClient){
    interval(1000).subscribe(()=>{
      this.TicketReleaseRate();
      this.CustomerPurcahaseCount()
    })
  }

  TicketReleaseRate():Observable<string>{
    return interval(1000).pipe(
      switchMap(()=>this.http.get<string>(this.apiUrl))
    )
  }
  CustomerPurcahaseCount():Observable<string>{
    return interval(1000).pipe(
      switchMap(()=>this.http.get<string>("http://localhost:8080/api/customer-purchase"))
    )
  }

}
