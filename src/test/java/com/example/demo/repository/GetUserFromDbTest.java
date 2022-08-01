package com.example.demo.repository;

import com.example.demo.model.Owner;
import com.example.demo.model.PetSitter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class GetUserFromDbTest {

    @Autowired
    private OwnerRepo ownerRepo;

    @Autowired
    private SitterRepo sitterRepo;

    @ParameterizedTest
    @ValueSource(strings = "admin")
    public void getUserByUsername(String s){
        Optional<Owner> foundOwner = ownerRepo.findByUsername(s);
        Optional<PetSitter> foundSitter = sitterRepo.findByUsername(s);
        if(foundOwner.isPresent())
            System.out.println(foundOwner.get().getRole() + " found!");
        else if(foundSitter.isPresent())
            System.out.println(foundSitter.get().getRole() + " found!");
        else
            System.out.println("Not found!");
    }
}
