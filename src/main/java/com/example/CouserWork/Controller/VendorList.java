package com.example.CouserWork.Controller;

import com.example.CouserWork.TicketPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


@RestController
public class VendorList {

    @Autowired
    private TicketPool pool;


    @GetMapping("/api/vendor-list")
    public Map<String, AtomicInteger> getPurchases(){
        return pool.printTickets();
    }
}
