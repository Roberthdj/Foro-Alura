
package com.alura.foro.record.respuesta;

import com.alura.foro.model.Topico;
import com.alura.foro.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(
        @NotBlank
        String mensaje,
        @NotNull
        Topico topico,
        @NotNull
        Usuario autor) {

}
