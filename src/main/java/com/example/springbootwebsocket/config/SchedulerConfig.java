package com.example.springbootwebsocket.config;

import com.example.springbootwebsocket.model.UserResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class SchedulerConfig {
    @Autowired
    SimpMessagingTemplate template;
    //@Scheduled(fixedDelay = 5000)
//    public void sendAdhocMessages(){
//        template.convertAndSend("/topic/user", new UserResponce("Scheduler"));
//    }
}
