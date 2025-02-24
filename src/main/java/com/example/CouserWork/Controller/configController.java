package com.example.CouserWork.Controller;

import com.example.CouserWork.TicketPool;
import com.example.CouserWork.Vendor;
import com.example.CouserWork.model.Configuration;
import com.example.CouserWork.service.ConfigService;
import com.example.CouserWork.service.StopButtonService;
import com.example.CouserWork.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class configController {

    @Autowired
    ConfigService configSer;

    @Autowired
    private VendorService vendorService;



    @GetMapping("/findall")
    public List<Configuration> getAllConfig(){
        return configSer.findAllConfigs();
    }
    @CrossOrigin(origins = "http://localhost:4200")

    @PostMapping("/add")
    public ResponseEntity<Configuration> addConfiguration(@RequestBody Configuration configuration){
        configuration.setMaximum_capacity(configuration.getMaximum_capacity());
        Configuration configurationNew=configSer.addConfig(configuration);


        vendorService.startProducer(configuration);

        return new ResponseEntity<>(configuration, HttpStatus.CREATED);
    }
}
