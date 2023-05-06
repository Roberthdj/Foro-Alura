
package com.alura.foro.record.topico;

import com.alura.foro.model.Curso;
import com.alura.foro.model.StatusTopico;
import com.alura.foro.model.Usuario;
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
        Usuario autor,
        @NotNull
        Curso curso) {

}
