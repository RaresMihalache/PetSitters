package com.example.demo.service;


import com.example.demo.model.User;
import com.example.demo.repository.OwnerRepo;
import com.example.demo.repository.SitterRepo;
import com.example.demo.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {

    private UserRepo userRepo;
    private OwnerRepo ownerRepo;
    private SitterRepo sitterRepo;

    public List<User> viewUsers(){
       return userRepo.findAll();
    }

    /*
    public List<User> searchByName(String username){

    }*/

}
