package com.example.billing.controller;

import com.example.billing.model.User;
import com.example.billing.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AuthController {
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthService authService, PasswordEncoder passwordEncoder) {
        this.authService = authService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/login")
    public String login() {
        return "login";  // Login sayfasına yönlendir
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";  //
    }

    // Handle signup form submission
    @PostMapping("/signup")
    public String registerUser(@ModelAttribute User user, Model model) {
        try {

            user.setPassword(passwordEncoder.encode(user.getPassword()));

            authService.registerUser(user.getUsername(), user.getPassword(), user.getRole());
            return "redirect:/login";  // Redirect to login after successful signup
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "signup";  // If there's an error, stay on the signup page and show error message
        }
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";  // Redirect to login after logout
    }
}
