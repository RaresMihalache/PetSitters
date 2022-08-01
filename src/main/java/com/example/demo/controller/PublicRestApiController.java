package com.example.demo.controller;

import com.example.demo.model.Owner;
import com.example.demo.model.PetSitter;
import com.example.demo.repository.OwnerRepo;
import com.example.demo.repository.SitterRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/public/rest")
public class PublicRestApiController {
    private OwnerRepo ownerRepo;
    private SitterRepo sitterRepo;

    public PublicRestApiController(OwnerRepo ownerRepo, SitterRepo sitterRepo) {
        this.ownerRepo = ownerRepo;
        this.sitterRepo = sitterRepo;
    }

    @GetMapping("test1")
    public String test1(){
        return "API test 1";
    }

    @GetMapping("test2")
    public String test2(){
        return "API test 2";
    }

    @GetMapping("owners")
    public List<Owner> owners(){
        return ownerRepo.findAll();
    }

    @GetMapping("sitters")
    public List<PetSitter> sitters(){
        return sitterRepo.findAll();
    }

}
