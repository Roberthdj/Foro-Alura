
package com.alura.foro.repository;

import com.alura.foro.model.Respuesta;
import com.alura.foro.model.Topico;
import com.alura.foro.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    
    @Query("SELECT R FROM Respuesta R WHERE R.topico.topicoId=:topico")
    Page<Respuesta> buscarPorTopico(Long topico, Pageable paginacion);
    
    @Query("SELECT R FROM Respuesta R WHERE R.autor.usuarioId=:autor")
    Page<Respuesta> buscarPorAutor(Long autor, Pageable paginacion);

}
