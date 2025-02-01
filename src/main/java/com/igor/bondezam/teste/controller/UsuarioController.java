package com.igor.bondezam.teste.controller;

import com.igor.bondezam.teste.converter.UsuarioConverter;
import com.igor.bondezam.teste.domain.Usuario;
import com.igor.bondezam.teste.dto.req.UsuarioReq;
import com.igor.bondezam.teste.dto.res.UsuarioRes;
import com.igor.bondezam.teste.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController extends CrudController<Usuario, Long, UsuarioReq, UsuarioRes> {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioConverter converter;

    @Override
    public ResponseEntity<UsuarioRes> createUsuario(UsuarioReq userReq) {
        Usuario user = converter.reqToEntity(userReq);
        if(Objects.nonNull(repository.findUsuarioByEmail(user.getEmail()))) {
            throw new RuntimeException("This email user is alrealy used");
        }
        user.setPassword(passwordEncoder(user.getPassword()));
        return ResponseEntity.status(201).body(converter.entityToRes(repository.save(user)));
    }

    private String passwordEncoder(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
