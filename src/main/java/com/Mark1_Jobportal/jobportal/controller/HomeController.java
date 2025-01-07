package com.Mark1_Jobportal.jobportal.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "portfolio";
    }

    @GetMapping("/portfolio2")
    public String portfolio(){
        return "portfolio2";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }


}
