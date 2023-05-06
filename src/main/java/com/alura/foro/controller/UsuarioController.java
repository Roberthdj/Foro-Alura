
package com.alura.foro.controller;

import com.alura.foro.record.usuario.DatosRegistroUsuario;
import com.alura.foro.model.Usuario;
import com.alura.foro.record.usuario.DatosActualizarUsuario;
import com.alura.foro.record.usuario.DatosListadoUsuario;
import com.alura.foro.record.usuario.DatosRespuestaUsuario;
import com.alura.foro.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<DatosRespuestaUsuario> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario,
            UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuario = usuarioRepository.save(new Usuario(datosRegistroUsuario));
        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(
                usuario.getUsuarioId(),
                usuario.getNombre(),
                usuario.getEmail()
        );
        URI url = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(usuario.getUsuarioId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaUsuario);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoUsuario>> listadoUsuario(@PageableDefault(size = 10, sort = "usuarioId") Pageable paginacion) {
        return ResponseEntity.ok(usuarioRepository.findAll(paginacion).map(DatosListadoUsuario::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaUsuario> RetornarDatosUsuario(@PathVariable Long id) {
        if (usuarioRepository.existsById(id)) {
            Usuario usuario = usuarioRepository.getReferenceById(id);
            var datosUsuario = new DatosRespuestaUsuario(
                    usuario.getUsuarioId(),
                    usuario.getNombre(),
                    usuario.getEmail()
            );
            return ResponseEntity.ok(datosUsuario);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarUsuario(@RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario) {
        Usuario usuario = usuarioRepository.getReferenceById(datosActualizarUsuario.id());
        usuario.actualizarDatos(datosActualizarUsuario);
        return ResponseEntity.ok(new DatosRespuestaUsuario(
                usuario.getUsuarioId(),
                usuario.getNombre(),
                usuario.getEmail())
        );
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarUsuario(@PathVariable Long id) {
        if (usuarioRepository.existsById(id)) {
            Usuario usuario = usuarioRepository.getReferenceById(id);
            usuarioRepository.delete(usuario);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
