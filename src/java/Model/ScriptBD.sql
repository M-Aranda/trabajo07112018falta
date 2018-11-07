CREATE DATABASE alumnosYDocentesEjercicio07112018;

USE alumnosYDocentesEjercicio07112018;

CREATE TABLE docente(
id INT AUTO_INCREMENT,
nombre VARCHAR(30),
PRIMARY KEY(id)
);

CREATE TABLE alumno(
id INT AUTO_INCREMENT,
nombre VARCHAR(30),
PRIMARY KEY(id)
);



CREATE TABLE curso(
id INT AUTO_INCREMENT,
nombre VARCHAR (30),
PRIMARY KEY(id)
);


CREATE TABLE alumno_curso(
id INT AUTO_INCREMENT,
fk_alumno INT,
fk_curso INT,
FOREIGN KEY(fk_alumno) REFERENCES alumno (id),
FOREIGN KEY(fk_curso) REFERENCES curso (id),
PRIMARY KEY(id)
);


INSERT INTO  alumno VALUES (NULL,'Marcelo');
INSERT INTO  alumno VALUES (NULL,'Carmen');
INSERT INTO  alumno VALUES (NULL,'Fabella');
INSERT INTO  alumno VALUES (NULL,'Marco');
INSERT INTO  alumno VALUES (NULL,'Lena');


INSERT INTO  docente VALUES (NULL,'Luis');
INSERT INTO  docente VALUES (NULL,'Zafira');
INSERT INTO  docente VALUES (NULL,'Celeste');

INSERT INTO  curso VALUES (NULL,'Ciencias');
INSERT INTO  curso VALUES (NULL,'Matematica');
INSERT INTO  curso VALUES (NULL,'Lenguaje');
INSERT INTO  curso VALUES (NULL,'Historia');


