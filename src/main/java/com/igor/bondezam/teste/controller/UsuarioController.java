package com.igor.bondezam.teste.controller;

import com.igor.bondezam.teste.domain.Usuario;
import com.igor.bondezam.teste.dto.req.UsuarioReq;
import com.igor.bondezam.teste.dto.res.UsuarioRes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends CrudController<Usuario, Long, UsuarioReq, UsuarioRes> {
}
