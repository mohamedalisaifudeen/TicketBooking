import { Component,Input,Output,EventEmitter } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Configuration } from '../vendor';
@Component({
  selector: 'app-ticket-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './ticket-form.component.html',
  styleUrl: './ticket-form.component.css'
})
export class TicketFormComponent {
  @Output() submittedForm=new EventEmitter<{config:Configuration;form:NgForm}>();
  config:Configuration;



  constructor(){
    this.config=new Configuration()
  }

  onSubmit(form:NgForm){

    const errors=[];
    const possibleErrors=['total_Tickets',"ticket_Release_Rate","customer_retrival_Rate","maximum_capacity"]


    if(this.config.maximum_capacity<this.config.total_Tickets){
      errors.push("The number of total tickets should be larger than the maximum tickets")
    }


    if(form.invalid){
      for (var i=0;i<possibleErrors.length;i++){
        if(form.controls[possibleErrors[i]]?.errors?.['required']){
          errors.push(`The number of ${possibleErrors[i]} field is required`)
        }else if(form.controls[possibleErrors[i]]?.errors?.['min']){
          errors.push(` The total number of ${possibleErrors[i]}  should be larger than 1`)
        }
      }
  }

    if(errors.length>0){
      alert(errors.join("\n"))
      return;
    }else{
      this.submittedForm.emit({config:this.config,form})
    }


  }

}
