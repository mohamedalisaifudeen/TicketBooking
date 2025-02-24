package com.example.CouserWork.service;

import com.example.CouserWork.Customer;
import com.example.CouserWork.TicketPool;
import com.example.CouserWork.Vendor;
import com.example.CouserWork.model.Configuration;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorService {
    private final TicketPool ticketPool;
    private SharedConfigService configService;
    private StopButtonService stopButtonService;

    public VendorService(TicketPool ticketPool, SharedConfigService configService, StopButtonService stopButtonService){
        this.stopButtonService=stopButtonService;
        this.ticketPool=ticketPool;
        this.configService=configService;
        this.stopButtonService=stopButtonService;
    }


    public void startProducer(Configuration config){

        configService.setConfig(config);
        Vendor vendor=new Vendor(ticketPool,config,stopButtonService);

        List<Thread> threads=new ArrayList<>();

        for(int i=0;i<10;i++){
            if(stopButtonService.getStopButtonVal()){
                break;
            }else{
                Thread vendorThread=new Thread(vendor);
                threads.add(vendorThread);
                vendorThread.start();
            }

//            Thread customerThread=new Thread(customer);


//            customerThread.start();
        }

//        for (Thread thread : threads) {
//            try{
//                thread.join();
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }



    }
}
