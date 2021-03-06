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

/*   //When we write index.html ..
     //tomcat server automatically shows it at localhost:(port) as default
     // so we don't need to right like that
    @RequestMapping(value = "/home")
    public String homePage(){
        return "index";
    }*/

    @RequestMapping(value = "/test")
    public String demopage(){
        return "Hi this a test web page";
    }
}
