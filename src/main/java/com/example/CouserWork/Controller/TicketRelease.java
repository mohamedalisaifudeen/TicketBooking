package com.example.CouserWork.Controller;

import com.example.CouserWork.TicketPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TicketRelease {
    @Autowired
    TicketPool ticketPool;

    @GetMapping("/api/ticket-release")
    public AtomicInteger getTicketRelease(){
        return ticketPool.getTicketCOunt();
    }
}
