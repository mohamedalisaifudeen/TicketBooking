import { Routes } from '@angular/router';
import { VenderPageComponent } from './vender-page/vender-page.component';
import { HomePageComponent } from './home-page/home-page.component';
import { CustomerComponent } from './customer/customer.component';

export const routes: Routes = [
    {path:"",redirectTo:'/home',pathMatch:"full"},
    {path:'home',component:HomePageComponent},
    {path:"vendor",component:VenderPageComponent},
    {path:"customer",component:CustomerComponent},
];
