package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("sitter")
public class SitterController {

    @GetMapping("index")
    public String index(){
        return "sitter/index";
    }

    @GetMapping("viewProfile")
    public String viewProfile(){
        return "sitter/viewProfile";
    }

    @GetMapping("viewAppointments")
    public String viewAppointments(){
        return "sitter/viewAppointments";
    }
}
