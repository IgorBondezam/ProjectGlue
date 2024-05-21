package com.igor.bondezam.teste.domain;

import com.igor.bondezam.teste.interfaces.SaveEntity;
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
public class Usuario implements SaveEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqe_usuario")
    @SequenceGenerator(allocationSize = 1, name = "sqe_usuario")
    private Long id;

    private String name;
    private Integer age;
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
