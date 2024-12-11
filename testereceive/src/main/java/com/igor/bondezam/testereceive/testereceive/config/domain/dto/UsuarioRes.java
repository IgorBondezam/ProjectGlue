package com.igor.bondezam.testereceive.testereceive.config.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioRes {
    private String name;
    private Integer age;
    private LocalDate birthdayDate;
    private String cpf;
    private String email;
    private Double height;
    private Double weight;
}
