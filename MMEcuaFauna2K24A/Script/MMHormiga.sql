-- database: ../database/MMHormiga.sqlite
/*
CopyRight
autor: Mateo Molina Moises Estrella
fecha: 2024-08-14
*/

DROP TABLE IF EXISTS Hormiga;
DROP TABLE IF EXISTS Sexo;
DROP TABLE IF EXISTS Pais;
DROP TABLE IF EXISTS Region;
DROP TABLE IF EXISTS Provincia;
DROP TABLE IF EXISTS GenoAlimento;
DROP TABLE IF EXISTS IngestaNativa;



CREATE TABLE Hormiga (
     IdHormiga            INTEGER PRIMARY KEY autoincrement
    ,IdSexo             INTEGER NOT NULL
    ,IdProvincia        INTEGER NOT NULL
    ,IdGenoAlimento     INTEGER NOT NULL
    ,IdIngestaNativa    INTEGER NOT NULL
    ,TipoHormiga        VARCHAR(50) NOT NULL
    ,Estado             VARCHAR(100) NOT NULL
    ,FechaCrea     DATETIME DEFAULT (datetime('now', '-5 hours'))
    ,FOREIGN KEY (IdSexo)          REFERENCES  Sexo(IdSexo)
    ,FOREIGN KEY (IdProvincia)     REFERENCES  Provincia(IdProvincia)
    ,FOREIGN KEY (IdGenoAlimento)  REFERENCES  GenoAlimento(IdGenoAlimento)
    ,FOREIGN KEY (IdIngestaNativa) REFERENCES  IngestaNativa(IdIngestaNativa)
);


CREATE TABLE Pais (
     IdPais        INTEGER PRIMARY KEY autoincrement
    ,Nombre        VARCHAR(50) NOT NULL
    ,FechaCrea     DATETIME DEFAULT (datetime('now', '-5 hours'))
);   

CREATE TABLE Region (
     IdRegion      INTEGER PRIMARY KEY autoincrement
    ,Nombre        VARCHAR(50) NOT NULL
    ,FechaCrea     DATETIME DEFAULT (datetime('now', '-5 hours'))
); 

CREATE TABLE Provincia (
     IdProvincia   INTEGER PRIMARY KEY autoincrement
    ,IdRegion      INTEGER NOT NULL
    ,IdPais        INTEGER NOT NULL
    ,Nombre        VARCHAR(50) NOT NULL
    ,FechaCrea     DATETIME DEFAULT (datetime('now', '-5 hours'))
    ,FOREIGN KEY (IdRegion) REFERENCES  Region(IdRegion)
    ,FOREIGN KEY (IdPais)   REFERENCES  Pais(IdPais)
); 

CREATE TABLE Sexo (
     IdSexo        INTEGER PRIMARY KEY autoincrement
    ,Genero         VARCHAR(50) NOT NULL
    ,FechaCrea     DATETIME DEFAULT (datetime('now', '-5 hours'))
);   

CREATE TABLE GenoAlimento (
     IdGenoAlimento     INTEGER PRIMARY KEY autoincrement
    ,NombreTipo         VARCHAR(50) NOT NULL
    ,FechaCrea          DATETIME DEFAULT (datetime('now', '-5 hours'))
);   

CREATE TABLE IngestaNativa (
     IdIngestaNativa    INTEGER PRIMARY KEY autoincrement
    ,Ingesta            VARCHAR(50) NOT NULL
    ,FechaCrea          DATETIME DEFAULT (datetime('now', '-5 hours'))
);   



INSERT INTO Sexo (Genero) VALUES 
("Macho"),
("Hembra"),
("Asexual");

INSERT INTO Pais (Nombre) VALUES 
("Ecuador");

INSERT INTO Region (Nombre) VALUES 
("Costa"),
("Sierra"),
("Oriente"),
("Galápagos");

INSERT INTO Provincia (IdRegion, IdPais, Nombre) VALUES 
(2, 1, "Azuay"),
(2, 1, "Bolívar"),
(2, 1, "Cañar"),
(2, 1, "Carchi"),
(2, 1, "Chimborazo"),
(2, 1, "Cotopaxi"),
(2, 1, "Guayas"),
(2, 1, "Imbabura"),
(2, 1, "Loja"),
(2, 1, "Los Ríos"),
(2, 1, "Manabí"),
(2, 1, "Morona Santiago"),
(2, 1, "Napo"),
(2, 1, "Pastaza"),
(2, 1, "Pichincha"),
(2, 1, "Santa Elena"),
(2, 1, "Santo Domingo de los Tsáchilas"),
(2, 1, "Tungurahua"),
(2, 1, "Zamora-Chinchipe"),
(1, 1, "Galápagos"),
(3, 1, "Esmeraldas"),
(3, 1, "Sucumbíos"),
(3, 1, "Orellana"),
(4, 1, "Isabela");

INSERT INTO GenoAlimento (NombreTipo) VALUES 
    ("X"),
    ("XX"),
    ("XY");

INSERT INTO IngestaNativa (Ingesta) VALUES 
("Carnívoro"),
("Herbívoro"),
("Omnívoro"),
("Insectívoros");