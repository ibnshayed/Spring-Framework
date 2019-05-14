package com.ibnshayed.www.customerappdemo.controller;

import com.ibnshayed.www.customerappdemo.model.Customer;
import com.ibnshayed.www.customerappdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/v1")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public String getCustomerList(Model model){
        model.addAttribute("customers",customerRepository.findAllByOrderByLastNameAsc());
        return "customer-list";
    }

    @GetMapping(value = "/customer/{id}")
    public String getACustomer(@PathVariable int id, Model model){
        model.addAttribute("customer",customerRepository.getOne(id));
        return "customer-profile";
    }

    @GetMapping(value = "/showform")
    public String getCustomerForm(Model model){
        Customer newCustomer = new Customer();
        model.addAttribute("customer",newCustomer);
        return "customer-form";
    }
    @PostMapping(value = "/savecustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer ){
            customerRepository.save(theCustomer);
            return "redirect:/v1/customers";
    }

    @GetMapping(value = "/showformforupdate")
    public String getUpdateACustomer(@RequestParam("customerId") int id,Model model){
        Customer theCustomer = customerRepository.getOne(id);
        model.addAttribute("customer",theCustomer);
        return "customer-form";
    }

    @GetMapping(value = "/deletecustomer/{id}")
    public String deleteACustomer(@PathVariable int id){
        customerRepository.deleteById(id);
        return "redirect:/v1/customers";
    }
}
