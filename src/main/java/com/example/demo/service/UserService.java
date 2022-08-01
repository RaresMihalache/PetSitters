package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.Owner;
import com.example.demo.model.PetSitter;
import com.example.demo.model.User;
import com.example.demo.repository.OwnerRepo;
import com.example.demo.repository.SitterRepo;
import com.example.demo.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepo userRepo;
    private OwnerRepo ownerRepo;
    private SitterRepo sitterRepo;
    private PasswordEncoder passwordEncoder;


    // -1 -> already found user with given username
    // -2 -> passwords don't match; else, user created successfully!
    public String registerUser(UserDTO user){
        Optional<User> foundUserByName = userRepo.findByUsername(user.getUsername());
        if(foundUserByName.isPresent()){
            System.out.println("User with name " + foundUserByName.get().getUsername() + " already exists!");
            return "-1";
        }
        if(user.getPassword().compareTo(user.getConfirmPassword()) != 0){
            System.out.println("Password don't match!");
            return "-2"; // passwords do not match!
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        //user.setConfirmPassword(user.getPassword());
        if(user.getRole() == null)
            return "-3";
        if(user.getRole().compareTo("OWNER") == 0){
            Owner owner = new Owner();
            owner.setUsername(user.getUsername());
            owner.setPassword(user.getPassword());
            owner.setRole(user.getRole());
            return ownerRepo.save(owner).getId();
        }
        else{
            PetSitter sitter = new PetSitter();
            sitter.setUsername(user.getUsername());
            sitter.setPassword(user.getPassword());
            sitter.setRole(user.getRole());
            return sitterRepo.save(sitter).getId();
        }
    }


    public Optional<User> getUserById(String id){
        return userRepo.findById(id);
    }

    public Optional<User> getUserByUsername(String username){
        return userRepo.findByUsername(username);
    }

    public List<User> getUsersByRole(String role){
        return userRepo.findAllByRole(role);
    }

    public Optional<User> getUserByIdAndUsernameAndRole(String id, String username, String role){
        return userRepo.findByIdAndUsernameAndRole(id, username, role);
    }
}
