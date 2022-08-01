package com.example.demo.repository;

import com.example.demo.model.Owner;
import com.example.demo.model.PetSitter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class DbInitTest {

    @Autowired
    private SitterRepo sitterRepo;

    @Autowired
    private OwnerRepo ownerRepo;

    private PasswordEncoder passwordEncoder;

    DbInitTest(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Test
    public void run(){
        /*Owner dan = new Owner();
        dan.setUsername("dan");
        dan.setPassword("dan123");
        dan.setPets(new ArrayList<Pet>());

        PetSitter sitter = new PetSitter();
        sitter.setUsername("sitter");
        sitter.setPassword("sitter123");
        sitter.setAppointments(new ArrayList<Appointment>());
        sitter.setRole("ROLE_SITTER");

        PetSitter admin = new PetSitter();
        admin.setUsername("admin");
        admin.setPassword("admin123");
        admin.setAppointments(new ArrayList<Appointment>());
        admin.setRole("ROLE_ADMIN");*/

       /* Owner dan = new Owner("dan",passwordEncoder.encode("dan123"),"USER");
        PetSitter admin = new PetSitter("admin",passwordEncoder.encode("admin123"),"ADMIN");
        PetSitter sitter = new PetSitter("sitter",passwordEncoder.encode("sitter123"),"SITTER");*/

/*        List<Owner> owners = Arrays.asList(dan);
        List<PetSitter> sitters = Arrays.asList(sitter, admin);

        ownerRepo.saveAll(owners);
        sitterRepo.saveAll(sitters);*/
    }
}