
package com.alura.foro.repository;

import com.alura.foro.model.Curso;
import com.alura.foro.model.Topico;
import com.alura.foro.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Page<Topico> findByAutorEquals(Usuario usuario, Pageable paginacion);

    Page<Topico> findByCursoEquals(Curso curso, Pageable paginacion);

}
