package com.ewcode.ewallet;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class EwalletApplication {

    public static void main(String[] args) {
        SpringApplication.run(EwalletApplication.class, args);
    }

}
