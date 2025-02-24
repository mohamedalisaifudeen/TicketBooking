import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {RouterLink, Route, ActivatedRoute, NavigationEnd} from '@angular/router';
import { Router } from '@angular/router';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Configuration } from '../vendor';
import { ConfigService } from '../config.service';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { TicketService } from '../ticket.service';
import { TicketFormComponent } from '../ticket-form/ticket-form.component';
import { ConfigData } from '../configData.service';
import {Subscription} from "rxjs";
import {VendorNumberService} from "../vendorNumber.service";
import {TicketReleaseRateService} from "../ticketReleaseRate.service";



@Component({
  selector: 'app-vender-page',
  standalone: true,
  imports: [FormsModule,CommonModule,HttpClientModule,TicketFormComponent],
  templateUrl: './vender-page.component.html',
  styleUrl: './vender-page.component.css',
  encapsulation:ViewEncapsulation.None,
  providers:[ConfigService],
})

export class VenderPageComponent implements OnInit {
  config: Configuration;
  latestConfig: Configuration = new Configuration()
  tickets_Released: any;
  newDictionary: object = new Object();
  private navigationSubscription!: Subscription;
  ticketData: { [key: string]: number } | null = null;
  ticketReleaseRate:string="0";
  ticketPurchaseTotal:string="0";


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private configService: ConfigService,
    private ticketService: TicketService,
    private http: HttpClient,
    private configData: ConfigData,
    private vendorNumber: VendorNumberService,
    private ticketRelease:TicketReleaseRateService,

  ) {
    this.config = new Configuration()
  }

  public getvendorData(){
    this.ticketService.getTicketCountObs().subscribe((count) => {
      this.tickets_Released = count

    });
  }

  ngOnInit(): void {
    this.latestConfig = this.configData.getConfig()
    this.getvendorData();

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
    this.vendorNumber.VendorTicketData().subscribe({
      next:(value=>{
        this.ticketData = value;
      })
    })
  }

  onSopClick() {
    this.http.post("http://localhost:8080/api/stop/run", {value: true}).subscribe({
      next: (response) => {
        alert("Stopped releasing and purchasing tickets !")
      }
    })
  }

  onFormSubmit(config: Configuration, form: NgForm) {
    this.configService.addConfiguration(config).subscribe(
      {
        next: (result: Configuration) => {
          this.configData.setConfig(result);
          this.latestConfig = this.configData.getConfig();
        }
      }
    )

    form.reset()
    console.log(this.latestConfig.customer_retrival_Rate)
    this.getvendorData();

    this.ticketService.getTicketCountObs().subscribe((count) => {
      this.configData.setTicketNumbers(count);
      this.tickets_Released = this.configData.getTicketNumbers();
      console.log("aaa" + this.tickets_Released);
    });


}
}
