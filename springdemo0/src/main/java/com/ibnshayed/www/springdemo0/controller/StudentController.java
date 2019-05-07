package com.ibnshayed.www.springdemo0.controller;

import com.ibnshayed.www.springdemo0.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @RequestMapping(value = "/showform")
    public String studentForm(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "studentForm";
    }

    @RequestMapping(value = "/processform")
    public String studentProcessForm(@ModelAttribute("student") Student theStudent){
        return "studentProcessForm";
    }
}
