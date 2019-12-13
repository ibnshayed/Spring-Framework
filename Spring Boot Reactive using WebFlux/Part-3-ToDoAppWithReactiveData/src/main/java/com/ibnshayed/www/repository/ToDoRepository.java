package com.ibnshayed.www.repository;

import com.ibnshayed.www.domain.ToDo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends ReactiveMongoRepository<ToDo, String> {


}
