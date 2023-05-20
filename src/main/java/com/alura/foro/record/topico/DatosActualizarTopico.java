
package com.alura.foro.record.topico;

import com.alura.foro.model.StatusTopico;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        StatusTopico estado,
        Long autor,
        Long curso) {

}
