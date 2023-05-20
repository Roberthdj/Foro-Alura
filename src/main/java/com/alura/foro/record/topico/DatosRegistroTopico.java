
package com.alura.foro.record.topico;

import com.alura.foro.model.StatusTopico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        StatusTopico estado,
        @NotNull
        Long autor,
        @NotNull
        Long curso) {

}
