/*
 * Author:  Fidodido
 * Created: 3/05/2023
 */

CREATE TABLE respuestas (
    respuesta_id BIGINT NOT NULL AUTO_INCREMENT,   
    mensaje VARCHAR(300) NOT NULL UNIQUE,
    fecha_creacion DATETIME NOT NULL,
    solucion BOOLEAN NOT NULL, 
    topico_id BIGINT NOT NULL,
    autor_id BIGINT NOT NULL, 
    PRIMARY KEY (respuesta_id),
    FOREIGN KEY(topico_id) REFERENCES topicos(topico_id) ON DELETE CASCADE,
    FOREIGN KEY(autor_id) REFERENCES usuarios(usuario_id) ON DELETE CASCADE
)ENGINE=InnoDB;