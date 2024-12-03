package com.igor.bondezam.teste.service;

import com.igor.bondezam.teste.domain.Usuario;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService extends CrudService<Usuario, Long> {

//    @Override
//    @RabbitListener(queues = {"usuario-fila"}) //Para criar as filas precisa ter um ouvinte
//    @Cacheable(value = "usuario")
//    public List<Usuario> findAll() {
//        return super.findAll();
//    }
}
