import { Configuration } from "./vendor";
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root', 
})

export class ConfigData{
    private localStorageKey = 'latestConfig';
    private StorageKey_ticketNumber = 'TicketNumber1212';
    latestConfig:Configuration;

    constructor(){
        this.latestConfig=new Configuration()
    }

    public setConfig(result: Configuration): void {
        localStorage.setItem(this.localStorageKey, JSON.stringify(result));
      }
    
      public getConfig(): Configuration {
        const storedConfig = localStorage.getItem(this.localStorageKey);
        return storedConfig ? JSON.parse(storedConfig) : new Configuration();
      }

      public setTicketNumbers(number:number){
        localStorage.setItem(this.StorageKey_ticketNumber,number.toString())
      }


      public getTicketNumbers(){
        const ticketNumber=localStorage.getItem(this.StorageKey_ticketNumber)
        return ticketNumber
      }
}