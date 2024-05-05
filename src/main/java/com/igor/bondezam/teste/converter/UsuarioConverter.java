package com.igor.bondezam.teste.converter;

import com.igor.bondezam.teste.domain.Usuario;
import com.igor.bondezam.teste.dto.req.UsuarioReq;
import com.igor.bondezam.teste.dto.res.UsuarioRes;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter extends CrudConverter<Usuario, UsuarioReq, UsuarioRes>{

}
