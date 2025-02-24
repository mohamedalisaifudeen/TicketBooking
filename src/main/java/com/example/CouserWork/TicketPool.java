package com.example.CouserWork;
import com.example.CouserWork.service.StopButtonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class manages all the tickets removed and added by the vendor and customer
 */

@Component
public class TicketPool {
    private List<Ticket> tickets=Collections.synchronizedList(new ArrayList<>());
    private StopButtonService stopButtonService;
    private AtomicInteger addTicketCount=new AtomicInteger(0);
    private AtomicInteger purchaseTicketCount=new AtomicInteger(0);
    private Map<String, AtomicInteger> ticketCount=new HashMap<>();
    private Map<String,AtomicInteger> ticketPurchase=new HashMap<>();
    public TicketPool(StopButtonService stopButtonService){
        this.stopButtonService=stopButtonService;

    }

    /**
     * This method is used to add tickets to the ticket pool and it is synchronised
     * @param ticket
     * @param maximumTickets
     */
    public synchronized void addTickets(Ticket ticket,int maximumTickets){
            while(tickets.size()>=maximumTickets){
                try {
                    System.out.println("Waiting till the tickets are purchased");
                    wait();
                }catch (InterruptedException err){
                    System.out.println(err.getMessage());
                }
            }

            String threadName=Thread.currentThread().getName();
            ticketCount.putIfAbsent(threadName,new AtomicInteger(0));
            tickets.add(ticket);
            addTicketCount.incrementAndGet();
            ticketCount.get(threadName).incrementAndGet();
            System.out.println("Added-Ticket: "+addTicketCount+" By"+threadName);
            notifyAll();







    }

    /**
     * This method is used to purchase tickets and this also is synchronized
     */

    public synchronized  void purchaseTickets(){
        while(tickets.isEmpty()){
            try{
                System.out.println("Waiting till the producer adds ticket because no tickets are available ! ");
                wait();
            }catch(InterruptedException err){
                System.out.println(err.getMessage());
            }
        }

        String threadName=Thread.currentThread().getName();
        ticketPurchase.putIfAbsent(threadName,new AtomicInteger());
        tickets.remove(0);
        purchaseTicketCount.incrementAndGet();
        ticketPurchase.get(threadName).incrementAndGet();
        System.out.println("Removed-Ticket "+purchaseTicketCount+" By"+threadName);
        notifyAll();




    }

    /**
     * Get ticket methods returns the specific ticket upon passing the index
     * @param index
     * @return
     */
    public Ticket getTicket(int index){
        return tickets.get(index);
    }

    /**
     * This method returns the number of available tickets to purchase
     * @return
     */
    public int NumberOfAvalTicket(){
        return tickets.size();
    }

    /**
     * This particular method returns the vendor thread and count of tickets released.
     * @return
     */
    public Map<String,AtomicInteger> printTickets(){
        return ticketCount;
    }

    /**
     * This method returns the customer thread and count of tickets released.
     * @return
     */
    public Map<String,AtomicInteger> getTicketCount(){
        return ticketPurchase;
    }

    /**
     * This particular method is used to get the vendor ticket release count
     * @return
     */
    public AtomicInteger getTicketCOunt(){
        return this.addTicketCount;
    }

    /**
     * This method is used to get the customer ticket purchase count
     * @return
     */
    public AtomicInteger getTicketPurchaseCOunt(){
        return this.purchaseTicketCount;
    }



}





