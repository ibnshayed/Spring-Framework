package com.ibnshayed.www.config;

import com.ibnshayed.www.repository.ToDoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToDoConfig {

    @Bean
    public ToDoRepository repository(){
        return new ToDoRepository();
    }

    @Bean
    CommandLineRunner showToDos(ToDoRepository repository){
        return args -> {
            repository.findAll().subscribe(System.out::println);
        };
    }
}