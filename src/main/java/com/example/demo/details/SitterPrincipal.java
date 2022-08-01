package com.example.demo.details;

import com.example.demo.model.PetSitter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SitterPrincipal implements UserDetails {

    private PetSitter petSitter;

    public SitterPrincipal(PetSitter petSitter) {
        this.petSitter = petSitter;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        if(petSitter.getRole().compareTo("ADMIN") == 0)
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        else if(petSitter.getRole().compareTo("SITTER") == 0)
            authorities.add(new SimpleGrantedAuthority("ROLE_SITTER"));

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.petSitter.getPassword();
    }

    @Override
    public String getUsername() {
        return this.petSitter.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.petSitter.getActive() == 1;
    }
}
