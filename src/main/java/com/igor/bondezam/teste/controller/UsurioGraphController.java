package com.igor.bondezam.teste.controller;

import com.igor.bondezam.teste.domain.Usuario;
import com.igor.bondezam.teste.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UsurioGraphController {

    @Autowired
    private UsuarioService service;

    @SchemaMapping(typeName = "Query", value = "findAllUsuario")
    public List<Usuario> findAll() {
        return service.findAll();
    }

}
