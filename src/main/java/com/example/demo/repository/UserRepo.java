package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {

    Optional<User> findByUsername(String s);

    List<User> findAllByRole(String s);

    List<User> findAllByIdAndUsernameAndRole(String id, String username, String role);

    Optional<User> findByIdAndUsernameAndRole(String id, String username, String role);
}
