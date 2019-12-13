package com.ibnshayed.www.repository;

import com.ibnshayed.www.domain.ToDo;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.Arrays;

public class ToDoRepository {
    private Flux<ToDo> toDoFlux = Flux.fromIterable(Arrays.asList(
       new ToDo("Do homeWork"),
       new ToDo("Workout in the morning",true),
       new ToDo("Make dinner tonight"),
       new ToDo("Clean the studio",true)));

    public Mono<ToDo> findById(String id){
        return Mono.from(toDoFlux.filter(toDo -> toDo.getId().equals(id)));
    }

    public Flux<ToDo> findAll(){
        return toDoFlux;
    }
}
