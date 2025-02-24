package com.example.CouserWork.Controller;

import com.example.CouserWork.TicketPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TicketNumberController {
    @Autowired
    private TicketPool pool;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/api/ticket-count")
    public int getCount(){
        return pool.NumberOfAvalTicket();
    }
}
