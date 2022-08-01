package com.example.demo.db;

import com.example.demo.model.Owner;
import com.example.demo.model.PetSitter;
import com.example.demo.model.User;
import com.example.demo.repository.OwnerRepo;
import com.example.demo.repository.SitterRepo;
import com.example.demo.repository.UserRepo;
import lombok.Builder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Builder
public class DbInit implements CommandLineRunner {

    private UserRepo userRepo;
    private OwnerRepo ownerRepo;
    private SitterRepo sitterRepo;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepo userRepo, OwnerRepo ownerRepo, SitterRepo sitterRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.ownerRepo = ownerRepo;
        this.sitterRepo = sitterRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Delete all
        this.ownerRepo.deleteAll();
        this.sitterRepo.deleteAll();

        // Crete users
        Owner dan = Owner.builder()
                .username("dan")
                .password(passwordEncoder.encode("dan1234"))
                .active(1)
                .role("OWNER")
                .build();
                //new Owner("dan",passwordEncoder.encode("dan1234"),"OWNER");
        PetSitter admin = PetSitter.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin123"))
                .active(1)
                .role("ADMIN")
                .build();
        PetSitter sitter = PetSitter.builder()
                .username("sitter")
                .password(passwordEncoder.encode("sitter123"))
                .active(1)
                .role("SITTER")
                .build();



/*
        List<Owner> owners = Arrays.asList(dan);
        List<PetSitter> sitters = Arrays.asList(admin, sitter);
*/

        User user1 = User.builder()
                .id(dan.getId())
                .username(dan.getUsername())
                .password(dan.getPassword())
                .role(dan.getRole())
                .build();
        /*User user2 = User.builder()
                .id(sitter.getId())
                .username(sitter.getUsername())
                .password(sitter.getPassword())
                .confirmPassword(sitter.getPassword())
                .role(sitter.getRole())
                .build();*/

        List<User> users = Arrays.asList(user1);

        // Save to db
        this.ownerRepo.saveAll(List.of(dan));
        this.sitterRepo.saveAll(List.of(sitter, admin));
/*        this.ownerRepo.saveAll(owners);
        this.sitterRepo.saveAll(sitters);*/
    }
}
