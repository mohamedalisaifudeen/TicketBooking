import { Component } from '@angular/core';
import { ConfigData } from '../configData.service';
import { Configuration } from '../vendor';
import { HttpClient } from '@angular/common/http';
import {TicketService} from "../ticket.service";
import {PurchaseNumberService} from "../customerNumber.service";
import {KeyValuePipe, NgForOf} from "@angular/common";
import {TicketReleaseRateService} from "../ticketReleaseRate.service";


@Component({
  selector: 'app-customer',
  standalone: true,
  imports: [
    KeyValuePipe,
    NgForOf
  ],
  templateUrl: './customer.component.html',
  styleUrl: './customer.component.css'
})
export class CustomerComponent {
  latestConfig:Configuration=new Configuration();
  tickets_Released:any;
  ticketsPurchased:{[key:string]:number}|null=null;
  ticketReleaseRate:string="0";
  ticketPurchaseTotal:string="0";




  constructor(
    private configData:ConfigData,
    private http:HttpClient,
    private  ticketService:TicketService,
    private customerPurchase:PurchaseNumberService,
    private ticketRelease:TicketReleaseRateService,
  ){
  }

  public getcustomerPurchase(){
    this.customerPurchase.VendorTicketData().subscribe((event)=>{
      this.ticketsPurchased=event;
    })
  }

  ngOnInit():void{
    this.latestConfig=this.configData.getConfig()
    this.getcustomerPurchase();

    this.ticketRelease.TicketReleaseRate().subscribe({
      next:(value:string)=>{
        this.ticketReleaseRate=value;
      }
    })

    this.ticketRelease.CustomerPurcahaseCount().subscribe({
      next:(value:string)=>{
        console.log("noo"+value)
        this.ticketPurchaseTotal=value;
      }
    })

    this.ticketService.getTicketCountObs().subscribe((count) => {
      this.tickets_Released = count
      console.log("aaa" + this.tickets_Released);
    });
  }

  ButtonClick(num:number){
    return this.http.post('http://localhost:8080/api/customer/start',{num}).subscribe({
      next:(response)=>{
        console.log("Data passed "+response)
      }
    })
  }


}

