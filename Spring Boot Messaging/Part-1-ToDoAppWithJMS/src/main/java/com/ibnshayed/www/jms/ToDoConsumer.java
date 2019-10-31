package com.ibnshayed.www.jms;


import com.ibnshayed.www.domain.ToDo;
import com.ibnshayed.www.repository.ToDoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class ToDoConsumer {

    private Logger log = LoggerFactory.getLogger(ToDoConsumer.class);
    private ToDoRepository repository;

    public ToDoConsumer(ToDoRepository repository){
        this.repository = repository;
    }

    @JmsListener(destination = "${todo.jms.destination}",containerFactory = "jmsFactory")
    public void processToDo(@Valid ToDo todo){
        log.info("Consumer> " + todo);
        log.info("ToDo created> " + this.repository.save(todo));
    }
}