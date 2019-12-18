package com.ibnshayed.www;

import com.ibnshayed.www.model.Product;
import com.ibnshayed.www.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WwwApplication {

    public static void main(String[] args) {
        SpringApplication.run(WwwApplication.class, args);
    }

    @Bean
    public CommandLineRunner insertAndView(ProductRepository repository, ApplicationContext context){
        return args -> {

            repository.save(new Product("1","name1",10)).subscribe();
            repository.save(new Product("2","name2",53)).subscribe();
            repository.save(new Product("3","name3",33)).subscribe();
            repository.save(new Product("4","name4", 11)).subscribe();

            repository.findAll().subscribe(System.out::println);
        };
    }
}
