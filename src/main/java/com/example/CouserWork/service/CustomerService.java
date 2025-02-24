package com.example.CouserWork.service;

import com.example.CouserWork.Customer;
import com.example.CouserWork.TicketPool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private SharedConfigService config;
    private TicketPool pool;
    private StopButtonService stopButtonService;

    public CustomerService(SharedConfigService config, TicketPool pool,StopButtonService stopButtonService){
        this.stopButtonService=stopButtonService;
        this.pool=pool;
        this.config=config;
    }

    List<Thread> threads=new ArrayList<>();

    public void startPurchasing(){
        Customer customer=new Customer(pool,config.getConfig(),stopButtonService);
        for(int i=0;i<10;i++){
                Thread thread=new Thread(customer);
                threads.add(thread);
                thread.start();


        }
        for(Thread thread : threads) {
            try{
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }


}
