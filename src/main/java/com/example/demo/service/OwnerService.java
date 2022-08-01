package com.example.demo.service;

import com.example.demo.model.Owner;
import com.example.demo.model.Pet;
import com.example.demo.repository.OwnerRepo;
import com.example.demo.repository.PetRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OwnerService {

    private OwnerRepo ownerRepo;
    private PetRepo petRepo;

    public Optional<Owner> getOwnerByUsername(String username){
        return ownerRepo.findByUsername(username);
    }

    public void updateOwner(String username, int balance, Pet pet){
        System.out.println("se va updata ownerul");
        Optional<Owner> owner = ownerRepo.findByUsername(username);
        if(owner.isPresent()){
            List<Pet> pets = owner.get().getPets();
            petRepo.save(pet);
            pets.add(pet);
            ownerRepo.updateOwnerByUsernameBalance(username, balance);
            System.out.println(pets.toString());
            List<Pet> ownerPets = petRepo.getAllByOwnerId(owner.get().getId());
            System.out.println(ownerPets.toString());
            //ownerRepo.updateOwnerByIdPet(owner.get().getId(), pets);
        }
        //petRepo.save(pet);
/*        ownerRepo.updateOwnerByUsernameBalance(username, balance);
        ownerRepo.updateOwnerByUsernamePet(username, pet);*/
    }

}
