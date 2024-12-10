package com.igor.bondezam.teste.config.serviceConfig.auth;

import com.desafio.profissional.magic.domain.User;
import com.desafio.profissional.magic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username);
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException("User not found, this user doesn't exist");
        }
        return user;
    }
}
