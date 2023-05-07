
package com.alura.foro.record.respuesta;

import com.alura.foro.model.Topico;
import com.alura.foro.model.Usuario;
import java.time.LocalDateTime;

public record DatosRespuestaRespuesta(
        Long id,
        String mensaje,
        LocalDateTime fechaCreacion,
        Boolean solucion,
        Topico topico,
        Usuario autor) {

    public DatosRespuestaRespuesta(Long id, String mensaje, LocalDateTime fechaCreacion, Boolean solucion, Topico topico, Usuario autor) {
        this.id = id;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.solucion = solucion;
        this.topico = new Topico(topico.getTopicoId());
        this.autor = new Usuario(autor.getUsuarioId());
    }

}
