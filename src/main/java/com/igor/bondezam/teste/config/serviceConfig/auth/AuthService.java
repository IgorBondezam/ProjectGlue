package com.igor.bondezam.teste.config.serviceConfig.auth;

import com.igor.bondezam.teste.domain.Usuario;
import com.igor.bondezam.teste.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = repository.findUsuarioByEmail(email);
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException("User not found, this user doesn't exist");
        }
        return user;
    }
}
