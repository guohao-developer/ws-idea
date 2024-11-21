package org.example.wsidea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WsIdeaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsIdeaApplication.class, args);
    }

}
