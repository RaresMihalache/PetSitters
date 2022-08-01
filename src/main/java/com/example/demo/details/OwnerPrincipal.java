package com.example.demo.details;

import com.example.demo.model.Owner;
import com.example.demo.model.PetSitter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OwnerPrincipal implements UserDetails {

    private Owner owner;

    public OwnerPrincipal(Owner owner) {
        this.owner = owner;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_OWNER"));

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.owner.getPassword();
    }

    @Override
    public String getUsername() {
        return this.owner.getUsername();
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
        return this.owner.getActive() == 1;
    }
}
