package com.example.CouserWork.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class StopButtonService {

    AtomicBoolean isStopped=new AtomicBoolean(false);

    public StopButtonService(){

    }

    public boolean getStopButtonVal(){
        return isStopped.get();
    }

    public void setBoolean(boolean isStopped){
        this.isStopped.set(isStopped);
    }
}
