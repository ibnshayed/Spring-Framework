package com.ibnshayed.www.springboot2x.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class HomePageController {

    @GetMapping(value = "/fpage")
    public String firstpage(){
        return "firstpage";
    }

   @RequestMapping(value = "/home")
    public String homePage(){
        return "index";
    }

    @RequestMapping(value = "/test")
    public String demopage(){
        return "Hi this a test web page";
    }
}
