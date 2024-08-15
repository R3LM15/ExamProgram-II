-- database: ../DataBase/MMHormiga.sqlite
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
     Hormiga            INTEGER PRIMARY KEY autoincrement
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
    ,Gnero         VARCHAR(50) NOT NULL
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



