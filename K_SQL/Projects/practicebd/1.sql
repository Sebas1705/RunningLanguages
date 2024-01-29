-- Active: 1694812751035@@127.0.0.1@3306@practicebd

CALL `CLEAN_AND_INIT_TABLES`()

CREATE PROCEDURE CLEAN_AND_INIT_TABLES()
BEGIN
DROP TABLE IF EXISTS tema_table;
DROP TABLE IF EXISTS emision_table;
DROP TABLE IF EXISTS ranking_table;
DROP TABLE IF EXISTS sencillo_table;
DROP TABLE IF EXISTS lp_table;
DROP TABLE IF EXISTS vinilo_table;
DROP TABLE IF EXISTS radio_table;
DROP TABLE IF EXISTS grupo_table;
DROP TABLE IF EXISTS discografica_table;



/* #Tables creation: */

CREATE TABLE IF NOT EXISTS `grupo_table` (
    nombre VARCHAR(120) NOT NULL,
    anyofundacion INT(4) NOT NULL,
    pais VARCHAR(120),
    PRIMARY KEY (nombre));
CREATE TABLE IF NOT EXISTS `discografica_table` (
    nombre VARCHAR(120) NOT NULL,
    telefono VARCHAR(9) NOT NULL,
    direccion VARCHAR(120) NOT NULL,
    pais VARCHAR(120) NOT NULL,
    PRIMARY KEY (nombre));
CREATE TABLE IF NOT EXISTS `vinilo_table` (
    isvn BIGINT(10) NOT NULL,
    fechalanzamiento DATE NOT NULL,
    copiasvendidas INT(8) NOT NULL,
    grupo VARCHAR(120) NOT NULL,
    discografica VARCHAR(120),
    PRIMARY KEY (isvn),
    FOREIGN KEY (grupo) REFERENCES grupo_table(nombre),
    FOREIGN KEY (discografica) REFERENCES discografica_table(nombre) ON DELETE SET NULL);
CREATE TABLE IF NOT EXISTS `lp_table` (
    isvn BIGINT(10) NOT NULL,
    titulo VARCHAR(120) NOT NULL,
    copiaslanzamiento INT(12) NOT NULL,
    PRIMARY KEY (isvn),
    FOREIGN KEY (isvn) REFERENCES vinilo_table(isvn) ON DELETE CASCADE);
CREATE TABLE IF NOT EXISTS `sencillo_table` (
    isvn BIGINT(10) NOT NULL,
    isvnlp BIGINT(10) NOT NULL,
    PRIMARY KEY (isvn),
    FOREIGN KEY (isvn) REFERENCES vinilo_table(isvn),
    FOREIGN KEY (isvnlp) REFERENCES lp_table(isvn),
    CHECK (isvn != isvnlp));
CREATE TABLE IF NOT EXISTS `ranking_table` (
    anyo INT(4) NOT NULL,
    semana INT(2) NOT NULL,
    primero BIGINT(10) NOT NULL,
    segundo BIGINT(10) NOT NULL,
    tercero BIGINT(10) NOT NULL,
    PRIMARY KEY (anyo,semana),
    FOREIGN KEY (primero) REFERENCES sencillo_table(isvn) ON DELETE CASCADE,
    FOREIGN KEY (segundo) REFERENCES sencillo_table(isvn) ON DELETE CASCADE,
    FOREIGN KEY (tercero) REFERENCES sencillo_table(isvn) ON DELETE CASCADE);
CREATE TABLE IF NOT EXISTS `tema_table` (
    codigo VARCHAR(20) NOT NULL,
    titulo VARCHAR(120) NOT NULL,
    duracion INT(4) NOT NULL CHECK (duracion > 0),
    autor VARCHAR(120) NOT NULL,
    lp BIGINT(10) NOT NULL,
    caralp CHAR(1) NOT NULL,
    pistalp INT(2) NOT NULL,
    sencillo BIGINT(10),
    carasencillo CHAR(1),
    pistasencillo INT(2),
    PRIMARY KEY (codigo),
    FOREIGN KEY (lp) REFERENCES lp_table(isvn),
    FOREIGN KEY (sencillo) REFERENCES sencillo_table(isvn),
    CHECK (
        (sencillo IS NOT NULL AND carasencillo IS NOT NULL AND pistasencillo IS NOT NULL)
        OR 
        (sencillo IS NULL AND carasencillo IS NULL AND pistasencillo IS NULL)
    ),
    CONSTRAINT un_titulo_por_autor UNIQUE (titulo, autor));
CREATE TABLE IF NOT EXISTS `radio_table` (
    nombre VARCHAR(120),
    direccion VARCHAR(120),
    web VARCHAR(120),
    email VARCHAR(120),
    telefono VARCHAR(9),
    PRIMARY KEY(nombre),
    CHECK (email LIKE '%@%.%'));
CREATE TABLE IF NOT EXISTS `emision_table` (
    radio VARCHAR(120), 
    fechaHora DATE NOT NULL,
    tema VARCHAR(120),
    PRIMARY KEY (radio, fechaHora),
    FOREIGN KEY (radio) REFERENCES radio_table(nombre) 
        ON DELETE CASCADE);
END

/*Nota: tenga en cuenta que, con el objetivo de simplificar los requisitos, algunos aspectos de la
realidad se han simplificado o, incluso, modificado en el enunciado. Además, aunque Oracle
admite sin problemas tildes y “ñ” tanto en valores como en nombres de atributos, para evitar
posibles problemas de fuentes entre distintos sistemas, se han eliminado.
La empresa VinylCorp se dedica a la catalogación y venta de trabajos musicales registrados en
discos de vinilo (si no sabe lo que es un disco de vinilo, pinche aquí). Se desea diseñar una base
de datos que pueda recoger los requisitos que se indican a continuación.
Todo disco de vinilo (al que, en adelante, llamaremos vinilo) se identifica por lo que llamaremos
ISVN (International Standard Vinyl Number), un código propio de nuestra aplicación que consta
de hasta 10 dígitos. Almacenaremos, de forma opcional, la discográfica que lo editó, su fecha de
lanzamiento y la cantidad de copias vendidas. De las discográficas, guardaremos el nombre, que
la identificará, el teléfono, la dirección y el país.
Cada vinilo se corresponde con un único grupo musical (no consideramos de momento vinilos
en los que participen varios grupos). Cada grupo se identificará por un nombre y guardaremos el
año de su fundación y el país de origen del grupo (que podrá ser desconocido).
Cada vinilo contendrá un conjunto de temas o canciones. Cada tema se identificará por un código
propio, su título, su duración (en segundos) y el autor (supondremos un único autor por tema).
Un tema puede aparecer en varios vinilos, con ciertas restricciones: en esta primera versión de
la base de datos, asumiremos que cada tema aparece en un LP y, opcionalmente, en uno de sus
sencillos (posteriormente se aclararán estos dos tipos de vinilos). Para cada vinilo en el que
aparece, tenemos que indicar la cara (los vinilos vienen grabados por las dos caras) y el número
de pista correspondiente. Aunque podían existir otras codificaciones, asumiremos que las caras
del disco siempre se identifican como “A” y “B”.
Aunque existen muchos otros, en nuestra base de datos consideraremos únicamente dos tipos
de vinilos: LPs y sencillos. Los LPs (Long Play) son discos que constan habitualmente de 10 o
12 temas. Los sencillos (o singles) son vinilos más pequeños que, habitualmente, contienen uno
o dos temas por cada cara. En nuestro caso, consideraremos únicamente los sencillos cuyas
canciones pertenecen a un mismo LP (normalmente, la cara A contiene la canción que se quiere
promocionar). Cada tema aparecerá, como mucho, en un LP y en un sencillo.
De los LPs, además de recogerse la cantidad de copias vendidas (como ocurre con todos los
vinilos), también se recogen las copias que se hicieron el día de su lanzamiento (no así para los
sencillos), y el título del LP. De los sencillos se registra la posición que puede haber alcanzado
en las listas de ventas. Esta información se almacena para cada semana del año, y se guardará
el single que estuvo en primera, segunda y tercera posición*/