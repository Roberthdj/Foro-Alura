
package com.alura.foro.model;

import com.alura.foro.model.Curso;
import com.alura.foro.model.Respuesta;
import com.alura.foro.model.Usuario;
import com.alura.foro.record.topico.DatosActualizarTopico;
import com.alura.foro.record.topico.DatosRegistroTopico;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topico_id")
    private Long topicoId;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "mensaje")
    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private StatusTopico estado = StatusTopico.NO_RESPONDIDO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private Set<Respuesta> respuestas = new HashSet<>();

    public Topico(Long topicoId) {
        this.topicoId = topicoId;
    }

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.estado = datosRegistroTopico.estado();
        this.autor = new Usuario(datosRegistroTopico.autor());
        this.curso = new Curso(datosRegistroTopico.curso());
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.estado() != null) {
            this.estado = datosActualizarTopico.estado();
        }
        if (datosActualizarTopico.autor() != null) {
            this.autor = new Usuario(datosActualizarTopico.autor());
        }
        if (datosActualizarTopico.curso() != null) {
            this.curso = new Curso(datosActualizarTopico.curso());
        }
    }

}
