import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import {interval, Observable, switchMap} from "rxjs";

@Injectable({
  providedIn: 'root',
})
export class PurchaseNumberService {


  private apiUrl='http://localhost:8080/api/customer-list';


  constructor(private http:HttpClient){

  }

  VendorTicketData():Observable<{[key:string]:number}>{
    return interval(1000).pipe(
      switchMap(()=>this.http.get<{[key:string]:number}>(this.apiUrl))
    )
  }


}
