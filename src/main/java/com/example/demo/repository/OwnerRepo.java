package com.example.demo.repository;

import com.example.demo.model.Owner;
import com.example.demo.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface OwnerRepo extends JpaRepository<Owner, String> {
    Optional<Owner> findByUsername(String username);



    /*@Modifying
    @Transactional
    //@Query(value = "update Owner o SET o.pets = :pets where o.username = :username", nativeQuery = true)
    //@Query(value = "update Owner o SET o.pets = :pets FROM Owner o where o.id = :ownerId", nativeQuery = true)
    @Query(value = "update Owner o set o.pets = :pets WHERE o.id = :ownerId")
    public void updateOwnerByUsernamePet(String ownerId, List<Pet> pets);*/


    @Modifying
    @Transactional
    @Query(value = "update Owner o set o.pets = :pets where o.id = :id", nativeQuery = true)
    public void updateOwnerByIdPet(String id, List<Pet> pets);

    @Modifying
    @Transactional
    @Query("update Owner o set o.balance = :balance where o.username = :username")
    public void updateOwnerByUsernameBalance(String username, int balance);
}
