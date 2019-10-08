package com.ibnshayed.www.repository;

import com.ibnshayed.www.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends CrudRepository<Person,String> {

    public Person findByEmailIgnoreCase(@Param("email") String email);
}
