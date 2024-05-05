package com.igor.bondezam.teste.dto.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UsuarioReq {

    private String name;
    private LocalDate birthdayDate;
    @CPF
    @NotBlank
    private String cpf;
    @Email
    @NotBlank
    private String email;
    private Double height;
    private Double weight;
}
