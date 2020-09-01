package com.axiom.mobileshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MobileshopApplication {

    public static void main(String[] args) {
        System.out.println("Starting application");
        SpringApplication.run(MobileshopApplication.class, args);
        System.out.println("Application Stopped");
    }

}
