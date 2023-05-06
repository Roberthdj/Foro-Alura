
package com.alura.foro.record.topico;

import com.alura.foro.model.Curso;
import com.alura.foro.model.StatusTopico;
import com.alura.foro.model.Usuario;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        StatusTopico estado,
        Usuario autor,
        Curso curso) {

    public DatosActualizarTopico(@NotNull Long id, String titulo, String mensaje, StatusTopico estado) {
        this(id, titulo, mensaje, estado, null, null);
    }

}
