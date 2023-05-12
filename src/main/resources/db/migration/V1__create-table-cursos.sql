/*
 * Author:  Fidodido
 * Created: 3/05/2023
 */

CREATE TABLE cursos (
    curso_id BIGINT NOT NULL AUTO_INCREMENT, 
    nombre VARCHAR(100) NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    PRIMARY KEY (curso_id)
)ENGINE=InnoDB;