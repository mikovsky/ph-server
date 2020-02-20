package com.michaldudek.phserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PhServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhServerApplication.class, args);
    }

}
