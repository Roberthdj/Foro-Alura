
package com.alura.foro.controller;

import com.alura.foro.config.errores.TratadorDeErrores;
import com.alura.foro.model.Curso;
import com.alura.foro.model.Topico;
import com.alura.foro.model.Usuario;
import com.alura.foro.record.topico.DatosActualizarTopico;
import com.alura.foro.record.topico.DatosListadoTopico;
import com.alura.foro.record.topico.DatosRegistroTopico;
import com.alura.foro.record.topico.DatosRespuestaTopico;
import com.alura.foro.repository.TopicoRepository;
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
@RequestMapping("/foro/topico")
public class TopicoController {

    private final TopicoRepository topicoRepository;

    public TopicoController(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
            UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getTopicoId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getEstado(),
                new Usuario(topico.getAutor().getUsuarioId()).getUsuarioId(),
                new Curso(topico.getCurso().getCursoId()).getCursoId()
        );
        URI url = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(topico.getTopicoId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopico(@PageableDefault(size = 10, sort = "topicoId") Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicoPorAutor(@PathVariable Long autor,
            @PageableDefault(size = 10, sort = "topicoId") Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository
                .buscarPorAutor(autor, paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("/curso/{curso}")
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicoPorCurso(@PathVariable Long curso,
            @PageableDefault(size = 10, sort = "topicoId") Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository
                .buscarPorCurso(curso, paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retornaDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        //<editor-fold defaultstate="collapsed" desc="aclaración">
        /*
            Usamos DatosListadoTopico en lugar de DatosRespuestaTopico
            por su estructura que cumple con los requerimientos
         */
        //</editor-fold>
        var datosTopico = new DatosListadoTopico(
                topico.getTopicoId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion().toString()
        );
        return ResponseEntity.ok(datosTopico);
    }

    @PutMapping()
    @Transactional
    public ResponseEntity ActualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(
                topico.getTopicoId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getEstado(),
                new Usuario(topico.getAutor().getUsuarioId()).getUsuarioId(),
                new Curso(topico.getCurso().getCursoId()).getCursoId())
        );
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        if (topicoRepository.existsById(id)) {
            Topico topico = topicoRepository.getReferenceById(id);
            topicoRepository.delete(topico);
            return ResponseEntity.noContent().build();
        }
        return new TratadorDeErrores().tratarError404();

    }

}
