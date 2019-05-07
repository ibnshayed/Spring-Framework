package com.ibnshayed.www.springdemo0;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springdemo0Application {

    public static void main(String[] args) {
        SpringApplication.run(Springdemo0Application.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {
            System.out.println("Successfully executed");
        };
    }

}
