package com.igor.bondezam.teste.controller;

import com.igor.bondezam.teste.config.serviceConfig.auth.TokenService;
import com.igor.bondezam.teste.domain.Usuario;
import com.igor.bondezam.teste.dto.req.LoginReq;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequestMapping("/login")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Lazy
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity makeLogin(@RequestBody @Valid LoginReq user) {
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
            Authentication authentication = manager.authenticate(token);
            String tokenAuth = tokenService.createToken((Usuario) authentication.getPrincipal());
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/login")
                    .buildAndExpand(tokenAuth)
                    .toUri();
            return ResponseEntity.created(location).body(tokenAuth);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
