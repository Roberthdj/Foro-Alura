
package com.alura.foro.repository;

import com.alura.foro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public UserDetails findByNombre(String username);

}
