import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

import {interval, Observable, switchMap} from "rxjs";

@Injectable({
  providedIn: 'root',
})
export class VendorNumberService {


  private apiUrl='http://localhost:8080/api/vendor-list';


  constructor(private http:HttpClient){
    interval(1000).subscribe(()=>{
      this.VendorTicketData();
    })
  }

  VendorTicketData():Observable<{[key:string]:number}>{
    return interval(1000).pipe(
      switchMap(()=>this.http.get<{[key:string]:number}>(this.apiUrl))
    )
  }



}
