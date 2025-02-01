package com.igor.bondezam.teste.converter;

import com.igor.bondezam.teste.domain.Usuario;
import com.igor.bondezam.teste.dto.req.UsuarioReq;
import com.igor.bondezam.teste.dto.res.UsuarioRes;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UsuarioConverter implements CrudConverter<Usuario, UsuarioReq, UsuarioRes> {

    @Override
    public Usuario reqToEntity(UsuarioReq usuarioReq) {
        Usuario usuario = new Usuario();
        usuario.setName(usuarioReq.getName());
        usuario.setBirthdayDate(usuarioReq.getBirthdayDate());
        usuario.setCpf(usuarioReq.getCpf());
        usuario.setEmail(usuarioReq.getEmail());
        usuario.setHeight(usuarioReq.getHeight());
        usuario.setWeight(usuarioReq.getWeight());
        usuario.setPassword(usuarioReq.getPassword());
        return usuario;
    }

    @Override
    public Usuario resToEntity(UsuarioRes usuarioRes) {
        Usuario usuario = new Usuario();
        usuario.setName(usuarioRes.getName());
        usuario.setAge(usuarioRes.getAge());
        usuario.setBirthdayDate(usuarioRes.getBirthdayDate());
        usuario.setCpf(usuarioRes.getCpf());
        usuario.setEmail(usuarioRes.getEmail());
        usuario.setHeight(usuarioRes.getHeight());
        usuario.setWeight(usuarioRes.getWeight());
        return usuario;
    }

    @Override
    public UsuarioReq entityToReq(Usuario entity) {
        UsuarioReq usuarioReq = new UsuarioReq();
        usuarioReq.setName(entity.getName());
        usuarioReq.setBirthdayDate(entity.getBirthdayDate());
        usuarioReq.setCpf(entity.getCpf());
        usuarioReq.setEmail(entity.getEmail());
        usuarioReq.setHeight(entity.getHeight());
        usuarioReq.setWeight(entity.getWeight());
        return usuarioReq;
    }

    @Override
    public UsuarioRes entityToRes(Usuario entity) {
        if(Objects.isNull(entity)){
            return null;
        }
        UsuarioRes usuarioRes = new UsuarioRes();
        usuarioRes.setName(entity.getName());
        usuarioRes.setAge(entity.getAge());
        usuarioRes.setBirthdayDate(entity.getBirthdayDate());
        usuarioRes.setCpf(entity.getCpf());
        usuarioRes.setEmail(entity.getEmail());
        usuarioRes.setHeight(entity.getHeight());
        usuarioRes.setWeight(entity.getWeight());
        return usuarioRes;
    }
}
