package com.example.demo.repository;

import com.example.demo.model.PetSitter;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface SitterRepo extends JpaRepository<PetSitter, String> {

    @Query("select p from PetSitter p where p.username = ?1")
    Optional<PetSitter> findByUsername(String username);

    @Query("select p from PetSitter p where p.subscribed = ?1")
    List<PetSitter> findAllBySubscribed(int subscribed);
}
