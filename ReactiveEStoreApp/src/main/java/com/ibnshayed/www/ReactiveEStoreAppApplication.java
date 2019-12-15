package com.ibnshayed.www;

import com.ibnshayed.www.domain.Product;
import com.ibnshayed.www.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveEStoreAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveEStoreAppApplication.class, args);
    }


}
