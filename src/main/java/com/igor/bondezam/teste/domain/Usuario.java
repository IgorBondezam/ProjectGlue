package com.igor.bondezam.teste.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.igor.bondezam.teste.domain.enums.UserRole;
import com.igor.bondezam.teste.interfaces.SaveEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Cacheable(value = "usuario")
@Builder
@JsonIgnoreProperties(ignoreUnknown = true, value = {"authorities"})
public class Usuario implements SaveEntity<Long>, UserDetails, Serializable {

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
    private String password;
    private Double height;
    private Double weight;

    private UserRole role = UserRole.USER;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.role == UserRole.ADMIN ? List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER")) :
                List.of(new SimpleGrantedAuthority("ROLE_USER"));    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
