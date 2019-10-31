package com.ibnshayed.www.config;


import com.ibnshayed.www.domain.ToDo;
import com.ibnshayed.www.jms.ToDoProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToDoSender {

    @Bean
    public CommandLineRunner sendToDos(@Value("${todo.jms.destination}") String destination, ToDoProducer producer){
        return args -> {
            producer.sendTo(destination,new ToDo("workout tomorrow morning!"));
        };
    }

}