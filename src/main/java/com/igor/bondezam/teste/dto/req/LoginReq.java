package com.igor.bondezam.teste.dto.req;

import jakarta.validation.Valid;
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
@Valid
public class LoginReq {

    @Email
    @NotBlank
    private String email;
    private String password;
}
