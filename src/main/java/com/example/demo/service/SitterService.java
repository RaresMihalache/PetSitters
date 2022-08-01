package com.example.demo.service;

import com.example.demo.model.PetSitter;
import com.example.demo.repository.SitterRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SitterService {

    private SitterRepo sitterRepo;

    public List<PetSitter> viewSubscribedSitters(){
        return sitterRepo.findAllBySubscribed(1);
    }
}
