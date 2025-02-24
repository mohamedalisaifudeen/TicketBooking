package com.example.CouserWork;

import com.example.CouserWork.model.Configuration;
import com.example.CouserWork.service.StopButtonService;

public class Customer implements Runnable {
    private TicketPool pool;
    private int customerRetrivalRate;
    private boolean priority;
    private int totalTickets;
    private int ticketsPurchased;
    private StopButtonService stopButtonService;

    public Customer(TicketPool pool, Configuration config,StopButtonService stopButtonService) {

        this.customerRetrivalRate=config.getCustomer_retrival_Rate();
        this.pool=pool;
        this.totalTickets=config.getTotal_Tickets();
        this.ticketsPurchased=0;
        this.stopButtonService=stopButtonService;
    }

//    @Override
//    public int compareTo(Customer cs1){
//        if(priority && !cs1.priority){
//            return -1;
//        }else if(!priority && cs1.priority){
//            return 1;
//        }else{
//            return 0;
//        }
//    }



    public void run(){
        while (ticketsPurchased<totalTickets){
            if(this.stopButtonService.getStopButtonVal()){
                break;
            }else{
                try{
                    pool.purchaseTickets();
                    ticketsPurchased++;
                    System.out.println(ticketsPurchased);
                    Thread.sleep(customerRetrivalRate);
                }catch (InterruptedException err){
                    System.out.println(err.getMessage());
                }
            }

        }

    }

    public boolean getPriority(){
        return priority;
    }


}
