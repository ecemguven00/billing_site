package com.example.billing.payment.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/register", "/payments/**").permitAll() // Public access to payment endpoints
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login") //Giriş sayfasına herkes erişebilir
                        .permitAll()
                )
                .logout(logout -> logout //çıkış yapabilmek için herkes erişebilir
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() { // Şifreleri güvenli bir şekilde şifrelemek için
        return new BCryptPasswordEncoder();
    }
}