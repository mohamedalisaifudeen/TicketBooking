package com.example.CouserWork;

import com.example.CouserWork.model.Configuration;
import com.example.CouserWork.service.StopButtonService;

/**
 * This vendor class is responsible to release tickets to the ticket pool
 */
public class Vendor implements Runnable {
    private TicketPool pool;
    private int numberOfTickets;
    private String vendorId;
    private String ticName;
    private String eventType;
    private int ticketReleaseRate;
    private int ticketsAdded;
    private int maximumTickets;
    private StopButtonService stopButtonService;

    /**
     * This constructs a new vendor object with a ticket pool assigned along with the configuration details and the stop button service to stop releasing tickets
     * @param pool
     * @param config
     * @param stopButtonService
     */

    public Vendor(TicketPool pool, Configuration config,StopButtonService stopButtonService) {
        this.numberOfTickets=config.getTotal_Tickets();
        this.ticketReleaseRate=config.getTicket_Release_Rate();
        this.pool=pool;
        this.ticketsAdded=0;
        this.maximumTickets=config.getMaximum_capacity();
        this.stopButtonService=stopButtonService;
    }

    /**
     * This line of code will be called to run the thread when needed.
     */

    public void run(){
                this.vendorId=generateId();
                 Ticket ticket=new Ticket(ticName,eventType,10.5,vendorId);

                 while(ticketsAdded<numberOfTickets){
                     if(stopButtonService.getStopButtonVal()){
                         break;
                     }else{
                         try {
                             pool.addTickets(ticket,maximumTickets);
                             ticketsAdded++;
                             Thread.sleep(ticketReleaseRate);
                         }catch(InterruptedException err){
                             System.out.println(err.getMessage());
                         }
                     }
                 }



    }

    public String generateId(){
        return java.util.UUID.randomUUID().toString();
    }
}
