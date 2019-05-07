package com.ibnshayed.www.springdemo0.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomePageController {

    @RequestMapping(value = "/")
    public String homePage(){
        return "homePage";
    }

    @RequestMapping(value = "/formpage")
    public String formPage(){
        return "formPage";
    }

    @RequestMapping(value = "/processform")
    public String processFormV1(){
        return "processForm";
    }

    @RequestMapping(value = "/processformV2")
    public String processFormV2(HttpServletRequest request, Model model){
        String theName = request.getParameter("studentName");
        theName = theName.toUpperCase();

        String result = "Hi! " + theName;

        model.addAttribute("message",result);

        return "processForm";
    }

    @RequestMapping(value = "/processformV3")
    public String processFormV3(@RequestParam("studentName") String theName, Model model){
        theName = theName.toUpperCase();
        String result = "Hi! " + theName;
        model.addAttribute("message",result);

        return "processForm";
    }



}
