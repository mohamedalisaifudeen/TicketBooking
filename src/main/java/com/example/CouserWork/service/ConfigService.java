package com.example.CouserWork.service;
import com.example.CouserWork.model.Configuration;
import com.example.CouserWork.repo.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ConfigService {
    private Config config;

    @Autowired
    public ConfigService(Config config){
        this.config=config;
    }

    public List<Configuration> findAllConfigs(){
        return config.findAll();
    }
    public Configuration addConfig(Configuration configuration){
        return config.save(configuration);
    }
}
