package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.Owner;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {


    @Autowired
    private UserService userService;

    @GetMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("register")
    public String showForm(Model model){
        UserDTO user = new UserDTO();
        model.addAttribute("userDTO", user);
        return "register_form";
    }

    @PostMapping("register")
    public String submitForm(Model model, @ModelAttribute("userDTO") UserDTO userDTO){
        String message = userService.registerUser(userDTO);
        if(message == "-1")
            return "register_found_user";
        else if(message == "-2")
            return "register_passwords_dont_match";
        else if(message == "-3")
            return "no_role_selected";
        model.addAttribute("username", userDTO.getUsername());
        return "register_success";
    }
}
