package com.example.CouserWork.model;

import jakarta.persistence.*;


@Entity
public class Configuration{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int total_Tickets;
    private int ticket_Release_Rate;
    private  int customer_retrival_Rate;

    private int maximum_capacity;

    public Configuration(){

    }

    public Configuration(int total_Tickets,int ticket_Release_Rate,int customer_retrival_Rate,int maximum_capacity){
        this.total_Tickets=total_Tickets;
        this.ticket_Release_Rate=ticket_Release_Rate;
        this.customer_retrival_Rate=customer_retrival_Rate;
        this.maximum_capacity=maximum_capacity;
    }

    public int getTotal_Tickets(){
        return total_Tickets;
    }

    public int getCustomer_retrival_Rate(){
        return customer_retrival_Rate;
    }

    public  int getTicket_Release_Rate(){
        return ticket_Release_Rate;
    }

    public int getMaximum_capacity(){
        return maximum_capacity;
    }

    public void setTotal_Tickets(int total_Tickets) {
        this.total_Tickets = total_Tickets;
    }

    public void setTicket_Release_Rate(int ticket_Release_Rate) {
        this.ticket_Release_Rate = ticket_Release_Rate;
    }

    public void setCustomer_retrival_Rate(int customer_retrival_Rate) {
        this.customer_retrival_Rate = customer_retrival_Rate;
    }

    public void setMaximum_capacity(int maximum_capacity) {
        this.maximum_capacity = maximum_capacity;
    }
}