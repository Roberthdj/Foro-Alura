
package com.alura.foro.controller;

import com.alura.foro.config.errores.TratadorDeErrores;
import com.alura.foro.model.Respuesta;
import com.alura.foro.model.Topico;
import com.alura.foro.model.Usuario;
import com.alura.foro.record.respuesta.DatosActualizarRespuesta;
import com.alura.foro.record.respuesta.DatosListadoRespuesta;
import com.alura.foro.record.respuesta.DatosRegistroRespuesta;
import com.alura.foro.record.respuesta.DatosRespuestaRespuesta;
import com.alura.foro.repository.RespuestaRepository;
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
@RequestMapping("/foro/respuesta")
public class RespuestaController {

    private final RespuestaRepository respuestaRepository;

    public RespuestaController(RespuestaRepository respuestaRepository) {
        this.respuestaRepository = respuestaRepository;
    }

    @PostMapping
    public ResponseEntity<DatosRespuestaRespuesta> registrarRespuesta(@RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta,
            UriComponentsBuilder uriComponentsBuilder) {
        Respuesta respuesta = respuestaRepository.save(new Respuesta(datosRegistroRespuesta));
        DatosRespuestaRespuesta datosRespuestaRespuesta = new DatosRespuestaRespuesta(
                respuesta.getRespuestaId(),
                respuesta.getMensaje(),
                respuesta.getFechaCreacion(),
                respuesta.getSolucion(),
                new Topico(respuesta.getTopico().getTopicoId()).getTopicoId(),
                new Usuario(respuesta.getAutor().getUsuarioId()).getUsuarioId()
        );
        URI url = uriComponentsBuilder.path("/respuesta/{id}").buildAndExpand(respuesta.getRespuestaId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaRespuesta);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoRespuesta>> listadoRespuesta(@PageableDefault(size = 10, sort = "respuestaId") Pageable paginacion) {
        return ResponseEntity.ok(respuestaRepository.findAll(paginacion).map(DatosListadoRespuesta::new));
    }

    @GetMapping("/topico/{topico}")
    public ResponseEntity<Page<DatosListadoRespuesta>> listadoRespuestaPorTopico(@PathVariable Long topico,
            @PageableDefault(size = 10, sort = "respuestaId") Pageable paginacion) {
        return ResponseEntity.ok(respuestaRepository
                .buscarPorTopico(topico, paginacion).map(DatosListadoRespuesta::new));
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<Page<DatosListadoRespuesta>> listadoRespuestaPorAutor(@PathVariable Long autor,
            @PageableDefault(size = 10, sort = "respuestaId") Pageable paginacion) {
        return ResponseEntity.ok(respuestaRepository
                .buscarPorAutor(autor, paginacion).map(DatosListadoRespuesta::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> RetornarDatosRespuesta(@PathVariable Long id) {
        Respuesta respuesta = respuestaRepository.getReferenceById(id);
        var datosRespuesta = new DatosListadoRespuesta(
                respuesta.getRespuestaId(),
                respuesta.getMensaje(),
                respuesta.getFechaCreacion().toString(),
                respuesta.getSolucion()
        );
        return ResponseEntity.ok(datosRespuesta);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarDatos(@RequestBody @Valid DatosActualizarRespuesta datosActualizarRespuesta) {
        Respuesta respuesta = respuestaRepository.getReferenceById(datosActualizarRespuesta.id());
        respuesta.actualizarDatos(datosActualizarRespuesta);
        return ResponseEntity.ok(new DatosRespuestaRespuesta(
                respuesta.getRespuestaId(),
                respuesta.getMensaje(),
                respuesta.getFechaCreacion(),
                respuesta.getSolucion(),
                new Topico(respuesta.getTopico().getTopicoId()).getTopicoId(),
                new Usuario(respuesta.getAutor().getUsuarioId()).getUsuarioId())
        );
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarRespuesta(@PathVariable Long id) {
        if (respuestaRepository.existsById(id)) {
            Respuesta respuesta = respuestaRepository.getReferenceById(id);
            respuestaRepository.delete(respuesta);
            return ResponseEntity.noContent().build();
        }
        return new TratadorDeErrores().tratarError404();
    }

}
