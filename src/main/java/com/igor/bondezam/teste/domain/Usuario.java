package com.igor.bondezam.teste.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Usuario {

    @Id
    private Long id;

    private String name;
    private Integer age;
    @Pattern(regexp = "dd/MM/yyyy")
    @Column(name = "birthdaydate")
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
