package com.ibnshayed.www.repository;

import com.ibnshayed.www.domain.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo,String> {

}
