
package com.alura.foro.record.respuesta;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarRespuesta(
        @NotNull
        Long id,
        String mensaje,
        Boolean solucion,
        Long topico,
        Long autor) {

}
