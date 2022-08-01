package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/public")
public class PublicApiController {

    @GetMapping("a")
    public String test1(){
        return "a";
    }

    @GetMapping("b")
    public String test2(){
        return "b";
    }

    @GetMapping("c")
    public String test3(){
        return "c";
    }
}
