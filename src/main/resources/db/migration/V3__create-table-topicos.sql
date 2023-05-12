/*
 * Author:  Fidodido
 * Created: 3/05/2023
 */

CREATE TABLE topicos (
    topico_id BIGINT NOT NULL AUTO_INCREMENT, 
    titulo VARCHAR(100) NOT NULL UNIQUE,
    mensaje VARCHAR(300) NOT NULL UNIQUE,
    fecha_creacion DATETIME NOT NULL,
    estado VARCHAR(50) NOT NULL,
    autor_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    PRIMARY KEY (topico_id),
    FOREIGN KEY(autor_id) REFERENCES usuarios(usuario_id) ON DELETE CASCADE,
    FOREIGN KEY(curso_id) REFERENCES cursos(curso_id) ON DELETE CASCADE
)ENGINE=InnoDB;