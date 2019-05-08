package com.ibnshayed.www.springvalidationdemo.controller;

import com.ibnshayed.www.springvalidationdemo.model.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class CustomerController {
    //if field has only blank space it trim the spaces and say it is null
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @RequestMapping(value = "/")
    public String showForm(Model model){
        model.addAttribute("customer",new Customer()); // here customer will be the th:object="${customer}" of html page
        return "customer-form";
    }

    @RequestMapping(value = "/processform")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer,
                              BindingResult bindingResult) {
        System.out.println("Last Name : |"+ customer.getLastName() + "|");
        if(bindingResult.hasErrors()){
            return "customer-form";
        }
        else return "process-form";
    }
}
