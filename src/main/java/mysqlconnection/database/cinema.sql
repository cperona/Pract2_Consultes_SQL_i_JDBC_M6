CREATE DATABASE IF NOT EXISTS cinema;
USE cinema;
/*
   1. [1 punt] Quines instruccions heu utilitzat per
   crear la BBDD, cada entitat i els camps de cada
   entitat? Poseu tot seguit aquí les instruccions
   tal qual les heu codificat al fitxer .sql.
*/

CREATE TABLE IF NOT EXISTS Director (
    idDirector INT(11) AUTO_INCREMENT PRIMARY KEY,
    Nom VARCHAR(25) NOT NULL,
    Any_naixement INT(11) NOT NULL,
    Pais VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Film (
    idFilm INT(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    Titol VARCHAR(125) NOT NULL,
    DataEstrena DATE NOT NULL,
    Pais VARCHAR(50) NOT NULL,
    idDirector INT(11),
    FOREIGN KEY (idDirector) REFERENCES Director(idDirector)
);

/*
   2. [1 punt] Afegiu 3 registres a la taula
   Director, per exemple, Steven Spielberg,
   George Lucas, Gareth Edwards, etc. Cerq.
   Poseu tot seguit la instrucció que heu
   fet servir per insertar els registres.
*/

INSERT INTO Director (Nom, Any_naixement, Pais)
Values('Steven Spielverg',1955,'Estats Units');

INSERT INTO Director (Nom, Any_naixement, Pais)
Values('George Lucas',1954,'Estats Units');

INSERT INTO Director (Nom, Any_naixement, Pais)
Values('Gareth Edwards',1950,'Estats Units');

/*
   3. [1 punt] Afegiu 6 registres a la taula Film,
   per exemple, “Indiana Jones y el templo maldito”,
   “La amenaza fantasma”, etc. Poseu tot seguit la
   instrucció que heu fet servir per insertar els registres.
*/

INSERT INTO Film (Titol, DataEstrena, Pais, idDirector)
Values('Indiana Jones y el templo maldito','1999-01-01','Estats Units', 1);

INSERT INTO Film (Titol, DataEstrena, Pais, idDirector)
Values('La amenaza fantasma','1989-01-01','Estats Units', 2);

INSERT INTO Film (Titol, DataEstrena, Pais, idDirector)
Values('Jurassic Park','1998-01-01','Estats Units', 1);

INSERT INTO Film (Titol, DataEstrena, Pais, idDirector)
Values('Godzilla','2014-01-01','Estats Units', 3);

INSERT INTO Film (Titol, DataEstrena, Pais, idDirector)
Values('El último dia','2005-01-01','Estats Units', 3);

INSERT INTO Film (Titol, DataEstrena, Pais, idDirector)
Values('Hook','1991-01-01','Estats Units', 1);

/*
   4. [1 punt] Es pot millorar la clau primària de cadascuna de les taules? Com?

   La clau primària de Film no té sentit que sigui NOT NULL perquè és autoincremental, per lo tant s'assignarà
   un valor incremental automàticament i és impossible que se li assigni un valor null.
*/