package com.ibnshayed.routinemakerapp.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api0")
public class CourseController {

    @GetMapping("/course")
    public String createACourse(){
        return "create-course";
    }

}
