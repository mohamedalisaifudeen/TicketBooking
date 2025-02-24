package com.example.CouserWork.Controller;

import com.example.CouserWork.service.StopButtonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/stop")
public class StartButtonController {

    private StopButtonService stopButtonService;

    public StartButtonController(StopButtonService stopButtonService){
        this.stopButtonService=stopButtonService;
    }

    @PostMapping("/run")
    public ResponseEntity<String>StopButton(@RequestBody Map<String,Object> request){
        stopButtonService.setBoolean(true);
        return ResponseEntity.ok("Got the value");

    }
}
