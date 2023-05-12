/*
 * Author:  Fidodido
 * Created: 3/05/2023
 */

CREATE TABLE usuarios (
    usuario_id BIGINT NOT NULL AUTO_INCREMENT, 
    nombre VARCHAR(100) NOT NULL UNIQUE,
    email varchar(100) NOT NULL UNIQUE,
    contrasena VARCHAR(300) NOT NULL UNIQUE,   
    PRIMARY KEY (usuario_id)
)ENGINE=InnoDB;