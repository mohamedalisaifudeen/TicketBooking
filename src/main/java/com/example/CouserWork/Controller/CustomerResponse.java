package com.example.CouserWork.Controller;


import com.example.CouserWork.model.Configuration;
import com.example.CouserWork.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/customer")
public class CustomerResponse {

    @Autowired
    CustomerService customerService;

@PostMapping("/start")
    public ResponseEntity<String> ButtonClick(@RequestBody Map<String,Object> request){
    int customerId=(int) request.get("num");
    if(customerId==1){
        customerService.startPurchasing();
    }

    return  ResponseEntity.ok("Customer Thread started ");
    }
}
