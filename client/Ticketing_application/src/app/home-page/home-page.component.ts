import { Component, ViewEncapsulation } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css',
  encapsulation:ViewEncapsulation.None,
})
export class HomePageComponent {
  currentYear:number

  constructor(){
    const date=new Date();
    this.currentYear=date.getFullYear();
  }
  
}
