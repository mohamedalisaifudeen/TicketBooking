package com.example.CouserWork;

public class Configuration123 {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;


    public Configuration123(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity){
        this.customerRetrievalRate=customerRetrievalRate;
        this.ticketReleaseRate=ticketReleaseRate;
        this.maxTicketCapacity=maxTicketCapacity;
        this.totalTickets=totalTickets;

    }

    public int getTotalTickets(){
        return totalTickets;
    }

    public int getMaxTicketCapacity(){
        return maxTicketCapacity;
    }

    public int getCustomerRetrievalRate(){
        return customerRetrievalRate;
    }

    public int getTicketReleaseRate(){
        return ticketReleaseRate;
    }

    public void setTotalTickets(int totalTickets){

        this.totalTickets=totalTickets;
    }
    public void setTicketReleaseRate(int ticketReleaseRate){
        this.ticketReleaseRate=ticketReleaseRate;
    }
    public  void setCustomerRetrievalRate(int customerRetrievalRate){
        this.customerRetrievalRate=customerRetrievalRate;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity){
        this.maxTicketCapacity=maxTicketCapacity;
    }
}
