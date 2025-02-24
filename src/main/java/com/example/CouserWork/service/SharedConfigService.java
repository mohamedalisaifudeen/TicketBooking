package com.example.CouserWork.service;

import com.example.CouserWork.model.Configuration;
import org.springframework.stereotype.Service;

@Service
public class SharedConfigService {
    private Configuration configuration;

    public synchronized  Configuration getConfig(){
        return  configuration;
    }

    public synchronized  void setConfig(Configuration configuration){
        this.configuration=configuration;
    }

}
