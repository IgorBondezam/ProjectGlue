package com.igor.bondezam.teste.service;

import com.igor.bondezam.teste.domain.Usuario;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService extends CrudService<Usuario, Long> {

//    @Override
//    @Cacheable(value = "usuario")
//    public List<Usuario> findAll() {
//        return super.findAll();
//    }
}
