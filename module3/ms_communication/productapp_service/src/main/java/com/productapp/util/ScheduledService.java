package com.productapp.util;

import com.productapp.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ScheduledService {

    @Autowired
    private ProductService productService;

    @Scheduled(initialDelay = 5000, fixedRate = 2000)
    public void demo(){
        System.out.println("run this after app started 5 sec and then run each after 2 sec");
    }

    @Scheduled(cron = "0/2 * * * * *")
    public void runAfterEach2Sec(){
        log.info("no of recrords : "+ productService.getAll());
        log.info("we are removing cache");

        productService.removeCache();

    }
}
