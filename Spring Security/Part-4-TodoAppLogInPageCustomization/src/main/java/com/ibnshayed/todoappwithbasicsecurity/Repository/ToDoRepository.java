package com.ibnshayed.todoappwithbasicsecurity.Repository;

import com.ibnshayed.todoappwithbasicsecurity.Model.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo,String> {
}
