
package com.alura.foro.record.respuesta;

import com.alura.foro.model.Topico;
import com.alura.foro.model.Usuario;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarRespuesta(
        @NotNull
        Long id,
        String mensaje,
        Boolean solucion,
        Topico topico,
        Usuario autor) {

    public DatosActualizarRespuesta(@NotNull Long id, String mensaje, Boolean solucion) {
        this(id, mensaje, solucion, null, null);
    }

}
