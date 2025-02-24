package com.example.CouserWork.Controller;

import com.example.CouserWork.TicketPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class CustomerClass {

    @Autowired
    TicketPool ticketPool;

    @GetMapping("/api/customer-list")
    public Map<String, AtomicInteger> customerList(){
        return ticketPool.getTicketCount();
    }


}
