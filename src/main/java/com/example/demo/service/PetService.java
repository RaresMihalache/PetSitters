package com.example.demo.service;

import com.example.demo.model.Pet;
import com.example.demo.repository.PetRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PetService {

    private PetRepo petRepo;

    public void savePet(Pet pet){
        petRepo.save(pet);
    }

}
