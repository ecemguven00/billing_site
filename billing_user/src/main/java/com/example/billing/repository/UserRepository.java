package com.example.billing.repository;

import com.example.billing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);


}