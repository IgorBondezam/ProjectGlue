package com.igor.bondezam.teste.fixture;

import com.igor.bondezam.teste.domain.Usuario;
import com.igor.bondezam.teste.dto.req.UsuarioReq;
import com.igor.bondezam.teste.dto.res.UsuarioRes;

import java.time.LocalDate;

public class UsuarioFixture {

    public static Usuario createUsuario(Long id){
        return Usuario.builder()
                .id(id)
                .age(20)
                .name("Igor Test")
                .weight(100D)
                .height(190D)
                .cpf("22569844195")
                .birthdayDate(LocalDate.of(2000,01,01))
                .email("teste@email.com")
                .build();
    }

    public static UsuarioReq createUsuarioReq(){
        return UsuarioReq.builder()
                .name("Igor Test")
                .weight(100D)
                .height(190D)
                .cpf("22569844195")
                .birthdayDate(LocalDate.of(2000,01,01))
                .email("teste@email.com")
                .build();
    }

    public static UsuarioRes createUsuarioRes(){
        return UsuarioRes.builder()
                .age(20)
                .name("Igor Test")
                .weight(100D)
                .height(190D)
                .cpf("22569844195")
                .birthdayDate(LocalDate.of(2000,01,01))
                .email("teste@email.com")
                .build();
    }
}
