package com.example.billing.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
public class User {

    @Getter
    @Setter
    @Id

    private String username;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String role;  // Role for authorization, example: "USER", "ADMIN"




}

