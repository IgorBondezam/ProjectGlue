package com.igor.bondezam.teste.repository;

import com.igor.bondezam.teste.domain.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
