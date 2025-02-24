package com.example.CouserWork.service;

import com.example.CouserWork.TicketPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class CustomerPurchaseTotal {

    @Autowired
    TicketPool ticketPool;

    @GetMapping("/api/customer-purchase")
    public AtomicInteger getCustomerPuchaseTotal() {
        return ticketPool.getTicketPurchaseCOunt();
    }
}
