package com.ibnshayed.www.repository;

import com.ibnshayed.www.model.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo,String> {


}
