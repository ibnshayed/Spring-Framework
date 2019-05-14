package com.ibnshayed.www.customerappdemo.repository;

import com.ibnshayed.www.customerappdemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    public List<Customer> findAllByOrderByLastNameAsc();

}
