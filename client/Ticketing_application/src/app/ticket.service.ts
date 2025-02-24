import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { BehaviorSubject, interval, Subject } from "rxjs";

@Injectable({
  providedIn: 'root',
})
export class TicketService {
  private ticketCountS=new BehaviorSubject<number>(0);

  private apiUrl='http://localhost:8080/api/ticket-count';


  constructor(private http:HttpClient){
    interval(500).subscribe(()=>{
      this.getTicketCount();
    })
  }

  getTicketCount(){
    this.http.get<number>(this.apiUrl).subscribe((count)=>{
      this.ticketCountS.next(count);
    },(error)=>{
      console.log(error)
    })
  }

  getTicketCountObs(){
    return this.ticketCountS.asObservable();
  }
}
