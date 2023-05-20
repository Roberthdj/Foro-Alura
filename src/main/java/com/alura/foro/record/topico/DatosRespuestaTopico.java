
package com.alura.foro.record.topico;

import com.alura.foro.model.StatusTopico;
import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico estado,
        Long autor,
        Long curso) {

}
