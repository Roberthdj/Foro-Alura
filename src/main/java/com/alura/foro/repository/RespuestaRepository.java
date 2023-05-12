
package com.alura.foro.repository;

import com.alura.foro.model.Respuesta;
import com.alura.foro.model.Topico;
import com.alura.foro.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    Page<Respuesta> findByTopicoEquals(Topico topico, Pageable paginacion);

    Page<Respuesta> findByAutorEquals(Usuario autor, Pageable paginacion);

}
