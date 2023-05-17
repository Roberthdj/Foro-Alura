-- >> Use la siguiente linea para intentar dar solucion a: 'Error Code: 1071. Specified key was too long; max key length is 3072 bytes' 
-- >> al intentar usar unique en el campo mensaje.
-- >> Linea a escribir para crear la base de datos : CREATE DATABASE foro_alura DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

CREATE DATABASE foro_alura;
USE foro_alura;

CREATE TABLE usuarios (
    usuario_id BIGINT NOT NULL AUTO_INCREMENT, 
    nombre VARCHAR(100) NOT NULL UNIQUE,
    email varchar(100) NOT NULL UNIQUE,
    contrasena VARCHAR(300) NOT NULL UNIQUE,   
    PRIMARY KEY (usuario_id)
)ENGINE=InnoDB;

CREATE TABLE cursos (
    curso_id BIGINT NOT NULL AUTO_INCREMENT, 
    nombre VARCHAR(100) NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    PRIMARY KEY (curso_id)
)ENGINE=InnoDB;

CREATE TABLE topicos (
    topico_id BIGINT NOT NULL AUTO_INCREMENT, 
    titulo VARCHAR(200) NOT NULL UNIQUE,
    mensaje VARCHAR(650) NOT NULL UNIQUE,
    fecha_creacion DATETIME NOT NULL,
    estado VARCHAR(50) NOT NULL,
	autor_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    PRIMARY KEY (topico_id),
    FOREIGN KEY(autor_id) REFERENCES usuarios(usuario_id) ON DELETE CASCADE,
    FOREIGN KEY(curso_id) REFERENCES cursos(curso_id) ON DELETE CASCADE
)ENGINE=InnoDB;

CREATE TABLE respuestas (
    respuesta_id BIGINT NOT NULL AUTO_INCREMENT, 
    mensaje VARCHAR(650) NOT NULL UNIQUE,
    fecha_creacion DATETIME NOT NULL,
    solucion BOOLEAN NOT NULL, 
	topico_id BIGINT NOT NULL,
    autor_id BIGINT NOT NULL,
    PRIMARY KEY (respuesta_id),
    FOREIGN KEY(topico_id) REFERENCES topicos(topico_id) ON DELETE CASCADE,
    FOREIGN KEY(autor_id) REFERENCES usuarios(usuario_id) ON DELETE CASCADE
)ENGINE=InnoDB;



