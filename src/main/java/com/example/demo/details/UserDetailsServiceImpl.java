package com.example.demo.details;

import com.example.demo.model.Owner;
import com.example.demo.model.PetSitter;
import com.example.demo.repository.OwnerRepo;
import com.example.demo.repository.SitterRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private SitterRepo sitterRepo;
    private OwnerRepo ownerRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Owner> owner = this.ownerRepo.findByUsername(username);
        if(owner.isPresent()){
            return new OwnerPrincipal(owner.get());
        }

        Optional<PetSitter> petSitter = this.sitterRepo.findByUsername(username);
        if(petSitter.isPresent()){
            return new SitterPrincipal(petSitter.get());
        }

        throw new UsernameNotFoundException("user not found with given username: " +  username);

    }
}
