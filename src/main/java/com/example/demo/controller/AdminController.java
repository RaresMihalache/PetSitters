package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.PetSitter;
import com.example.demo.model.User;
import com.example.demo.service.AdminService;
import com.example.demo.service.SitterService;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private SitterService sitterService;
    @Autowired
    private UserService userService;

    @GetMapping("index")
    public String index() {
        return "admin/index";
    }

    @GetMapping("viewUsers")
    public String showUsers(Model model) {
        List<User> listUsers = adminService.viewUsers();
        model.addAttribute("listUsers", listUsers);
        return "admin/viewUsers";
    }

    @GetMapping("searchBy")
    public String searchBy(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "admin/searchBy";
    }

    @PostMapping("searchByGiven")
    public String searchByy(Model model, @ModelAttribute("user") User user) {
        List<User> foundUsers;
        foundUsers = userService.getUsersByRole(user.getRole());
        model.addAttribute("foundUsers", foundUsers);
        return "admin/searchByGiven";
    }

    @GetMapping("viewSubs")
    public String viewSubscribers(Model model) {
        List<PetSitter> listSitters = sitterService.viewSubscribedSitters();
        model.addAttribute("listSitters", listSitters);
        return "admin/viewSubs";
    }

    @PostMapping("register")
    public String submitForm(Model model, @ModelAttribute("userDTO") UserDTO userDTO) {
        String message = userService.registerUser(userDTO);
        if (message == "-1")
            return "register_found_user";
        else if (message == "-2")
            return "register_passwords_dont_match";
        else if (message == "-3")
            return "no_role_selected";
        model.addAttribute("username", userDTO.getUsername());
        return "register_success";
    }

}
