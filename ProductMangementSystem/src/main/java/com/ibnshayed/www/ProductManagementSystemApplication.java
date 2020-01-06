package com.ibnshayed.www;

import com.ibnshayed.www.model.Product;
import com.ibnshayed.www.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@SpringBootApplication
//@EnableSwagger2WebFlux
public class ProductManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductManagementSystemApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(ProductRepository productRepo, ApplicationContext applicationContext){
        return args -> {
            productRepo.save(new Product("1","name1",12)).subscribe();
            productRepo.save(new Product("2","name2",22)).subscribe();
            productRepo.save(new Product("3","name3",32)).subscribe();
            productRepo.save(new Product("4","name4",42)).subscribe();
            productRepo.save(new Product("5","name5",52)).subscribe();

            productRepo.findAll().subscribe(System.out::println);
        };
    }
}
