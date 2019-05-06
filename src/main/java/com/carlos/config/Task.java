package com.carlos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Task {

    @Autowired
    private Producer producer;

    @Scheduled(fixedRate = 3000)
    public void scheduled() {
        System.out.println("--------");
        producer.testSendMessage();
    }
}
