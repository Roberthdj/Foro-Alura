
package com.alura.foro.record.usuario;

import com.alura.foro.model.Usuario;

public record DatosListadoUsuario(Long id, String nombre, String email) {

    public DatosListadoUsuario(Usuario usuario) {
        this(usuario.getUsuarioId(), usuario.getNombre(), usuario.getEmail());
    }

}
