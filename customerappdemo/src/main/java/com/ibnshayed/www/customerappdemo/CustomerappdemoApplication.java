package com.ibnshayed.www.customerappdemo;

import com.ibnshayed.www.customerappdemo.model.Customer;
import com.ibnshayed.www.customerappdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;

@SpringBootApplication
public class CustomerappdemoApplication {

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(CustomerappdemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {
            System.out.println("Wow !!! SuccessFully Executed.");
            customerRepository.findAll().forEach(System.out::println);
        };
    }

}
