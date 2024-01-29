
CALL `INSERTAR`()

-- 2.1. Inserte los datos utilizando el script que tiene disponible en la página de la asignatura:
--INSERCIONES
CREATE PROCEDURE INSERTAR()
BEGIN
/* --DISCOGRAFICA */
INSERT INTO discografica_table (nombre, telefono, direccion, pais) VALUES ('RCA','123456789','C/RCA sn','Espanya');
INSERT INTO discografica_table (nombre, telefono, direccion, pais) VALUES ('Columbia Records','123456789','Street Columbia Records','EEUU');
INSERT INTO discografica_table (nombre, telefono, direccion, pais) VALUES ('Capitol Records','123456789','Street Capitol Records','EEUU');
INSERT INTO discografica_table (nombre, telefono, direccion, pais) VALUES ('Sony Music','123456789','Street Sony Music Records','EEUU');
INSERT INTO discografica_table (nombre, telefono, direccion, pais) VALUES ('Warner Bros. Records','123456789','C/Warner sn','Espanya');
INSERT INTO discografica_table (nombre, telefono, direccion, pais) VALUES ('Epic','123456789', 'C/Epic sn','Espanya');


/* --RADIO */
INSERT INTO radio_table (nombre, direccion, web, email, telefono) VALUES ('Radio Vaticano','Direccion Radio Vaticano','https://www.vaticannews.va/es.html','contacto@vaticannews.va','132132113');
INSERT INTO radio_table (nombre, direccion, web, email, telefono) VALUES ('Europa FM','Direccion de Onda Cero','https://www.ondacero.es','contacto@ondacero.es','132132113');
INSERT INTO radio_table (nombre, direccion, web, email, telefono) VALUES ('RNE1','Direccion de RTVE','https://www.rtve.es/rne1','contacto@rtve.es','132132113');
INSERT INTO radio_table (nombre, direccion, web, email, telefono) VALUES ('RNE3','Direccion de RTVE','https://www.rtve.es/rne3','contacto@rtve.es','132132113');
INSERT INTO radio_table (nombre, direccion, web, email, telefono) VALUES ('RNE5','Direccion de RTVE','https://www.rtve.es/rne5','contacto@rtve.es','132132113');
INSERT INTO radio_table (nombre, direccion, web, email, telefono) VALUES ('40 Principales','Direccion de la Cadena SER','https://cadenaser.com','contacto@cadenaser.com','132132113');


/* --GRUPO */
INSERT INTO grupo_table (nombre, anyoFundacion, pais) VALUES ('AC/DC','1973','Australia');
INSERT INTO grupo_table (nombre, anyoFundacion, pais) VALUES ('Radio Futura','1979','Espanya');
INSERT INTO grupo_table (nombre, anyoFundacion, pais) VALUES ('Sidonie','1997','Espanya');
INSERT INTO grupo_table (nombre, anyoFundacion, pais) VALUES ('Queen','1970','Reino Unido');

/* --VINILO */
INSERT INTO vinilo_table (ISVN, fechaLanzamiento, copiasVendidas, grupo, discografica) VALUES (1000000001,STR_TO_DATE('25-07-1980','%d-%m-%Y'),200000,'AC/DC','Warner Bros. Records'); -- Back in Black
INSERT INTO vinilo_table (ISVN, fechaLanzamiento, copiasVendidas, grupo, discografica) VALUES (1000000011,STR_TO_DATE('25-07-1980','%d-%m-%Y'),500000,'AC/DC','Warner Bros. Records'); -- sencillo Back in Black
INSERT INTO vinilo_table (ISVN, fechaLanzamiento, copiasVendidas, grupo, discografica) VALUES (2000000001,STR_TO_DATE('01-01-1987','%d-%m-%Y'),110000, 'Radio Futura','RCA'); -- La Cancion de Juan Perro 
INSERT INTO vinilo_table (ISVN, fechaLanzamiento, copiasVendidas, grupo, discografica) VALUES (2000000011,STR_TO_DATE('01-01-1987','%d-%m-%Y'),50000, 'Radio Futura','RCA'); -- Sencillo La Cancion de Juan Perro 
INSERT INTO vinilo_table (ISVN, fechaLanzamiento, copiasVendidas, grupo, discografica) VALUES (2000000111,STR_TO_DATE('01-01-1987','%d-%m-%Y'),15000,'Radio Futura','RCA'); -- Maxi 37 Grados
INSERT INTO vinilo_table (ISVN, fechaLanzamiento, copiasVendidas, grupo, discografica) VALUES (3000000001,STR_TO_DATE('18-10-2011','%d-%m-%Y'),310000,'Sidonie','Columbia Records'); -- El Fluido Garcia
INSERT INTO vinilo_table (ISVN, fechaLanzamiento, copiasVendidas, grupo, discografica) VALUES (3000000011,STR_TO_DATE('18-10-2011','%d-%m-%Y'),500000,'Sidonie','Columbia Records'); -- Sencillo El Fluido Garcia
INSERT INTO vinilo_table (ISVN, fechaLanzamiento, copiasVendidas, grupo, discografica) VALUES (3000000002,STR_TO_DATE('01-01-2003','%d-%m-%Y'),410000,'Sidonie','Columbia Records'); -- Shell Kids
INSERT INTO vinilo_table (ISVN, fechaLanzamiento, copiasVendidas, grupo, discografica) VALUES (3000000012,STR_TO_DATE('01-01-2003','%d-%m-%Y'),350000,'Sidonie','Columbia Records'); -- Sencillo Shell Kids
INSERT INTO vinilo_table (ISVN, fechaLanzamiento, copiasVendidas, grupo, discografica) VALUES (5000000001,STR_TO_DATE('21-11-1975','%d-%m-%Y'),610000,'Queen','Capitol Records'); -- A Night at the Opera
INSERT INTO vinilo_table (ISVN, fechaLanzamiento, copiasVendidas, grupo, discografica) VALUES (5000000011,STR_TO_DATE('21-11-1975','%d-%m-%Y'),500000,'Queen','Capitol Records'); -- Sencillo A Night at the Opera
INSERT INTO vinilo_table (ISVN, fechaLanzamiento, copiasVendidas, grupo, discografica) VALUES (5000000002,STR_TO_DATE('30-06-1980','%d-%m-%Y'),710000,'Queen','Capitol Records'); -- The Game
INSERT INTO vinilo_table (ISVN, fechaLanzamiento, copiasVendidas, grupo, discografica) VALUES (5000000012,STR_TO_DATE('30-06-1980','%d-%m-%Y'),810000,'Queen','Capitol Records'); -- Sencillo The Game
INSERT INTO vinilo_table (ISVN, fechaLanzamiento, copiasVendidas, grupo, discografica) VALUES (5000000003,STR_TO_DATE('02-06-1986','%d-%m-%Y'),500000,'Queen','Capitol Records'); -- A Kind of Magic

/* --LP */
INSERT INTO lp_table (ISVN, titulo, copiasLanzamiento) VALUES (1000000001,'Back in Black',100000);
INSERT INTO lp_table (ISVN, titulo, copiasLanzamiento) VALUES (2000000001,'La Cancion de Juan Perro',110000);
INSERT INTO lp_table (ISVN, titulo, copiasLanzamiento) VALUES (3000000001,'El Fluido Garcia',310000);
INSERT INTO lp_table (ISVN, titulo, copiasLanzamiento) VALUES (3000000002,'Shell Kids',410000);
INSERT INTO lp_table (ISVN, titulo, copiasLanzamiento) VALUES (5000000001,'A Night at the Opera',610000);
INSERT INTO lp_table (ISVN, titulo, copiasLanzamiento) VALUES (5000000002,'The Game',710000);
INSERT INTO lp_table (ISVN, titulo, copiasLanzamiento) VALUES (5000000003,'A Kind of Magic',810000);


/* --SENCILLO  */
INSERT INTO sencillo_table (ISVN, ISVNLP) VALUES (1000000011,1000000001);
INSERT INTO sencillo_table (ISVN, ISVNLP) VALUES (2000000011,2000000001);
INSERT INTO sencillo_table (ISVN, ISVNLP) VALUES (2000000111,2000000001);
INSERT INTO sencillo_table (ISVN, ISVNLP) VALUES (3000000011,3000000001);
INSERT INTO sencillo_table (ISVN, ISVNLP) VALUES (3000000012,3000000002);
INSERT INTO sencillo_table (ISVN, ISVNLP) VALUES (5000000011,5000000001);
INSERT INTO sencillo_table (ISVN, ISVNLP) VALUES (5000000012,5000000002);

/* --TEMA */
INSERT INTO tema_table (codigo, titulo, duracion,autor, LP, caraLP, pistaLP, sencillo, caraSencillo,pistaSencillo) VALUES ('1','Back in Black',300,'AC/DC',1000000001,'A',5,1000000011,'A',1); -- Back in Black,
INSERT INTO tema_table (codigo, titulo, duracion,autor, LP, caraLP, pistaLP, sencillo, caraSencillo,pistaSencillo) VALUES ('2','La Cancion de Juan Perro',301,'Radio Futura',2000000001,'A',1,2000000011,'A',1); -- La Cancion de Juan Perro 
INSERT INTO tema_table (codigo, titulo, duracion,autor, LP, caraLP, pistaLP, sencillo, caraSencillo,pistaSencillo) VALUES ('4','Carnaval',303,'Sidonie', 3000000001,'A',4,3000000011,'A',1); -- El Fluido Garcia
INSERT INTO tema_table (codigo, titulo, duracion,autor, LP, caraLP, pistaLP, sencillo, caraSencillo,pistaSencillo) VALUES ('5','On the Sofa',304,'Sidonie',3000000002,'A',2,3000000012,'A',1); -- Shell Kids
INSERT INTO tema_table (codigo, titulo, duracion,autor, LP, caraLP, pistaLP, sencillo, caraSencillo,pistaSencillo) VALUES ('7','Bohemian Rhapsody',306,'Queen',5000000001,'A',1,5000000011,'A',1); -- A Night at the Opera
INSERT INTO tema_table (codigo, titulo, duracion,autor, LP, caraLP, pistaLP, sencillo, caraSencillo,pistaSencillo) VALUES ('8','Another One Bites the Dust',307,'Queen',5000000002,'A',1,5000000012,'A',1); -- The Game   
INSERT INTO tema_table (codigo, titulo, duracion,autor, LP, caraLP, pistaLP, sencillo, caraSencillo,pistaSencillo) VALUES ('9','Dragon Attack',260,'Queen',5000000002,'A',2,5000000012,'B',1); -- Otra canción en el sencillo de The Game   

/* --EMISION */
INSERT INTO emision_table (radio, fechaHora, tema) VALUES ('Europa FM',STR_TO_DATE('01-01-1981 08:03:01','%d-%m-%Y %H:%i:%s'),'2'); -- Europa FM emite solo musica espanyola
INSERT INTO emision_table (radio, fechaHora, tema) VALUES ('Europa FM',STR_TO_DATE('01-03-1981 08:03:01','%d-%m-%Y %H:%i:%s'),'4');
INSERT INTO emision_table (radio, fechaHora, tema) VALUES ('Europa FM',STR_TO_DATE('01-04-1981 08:03:01','%d-%m-%Y %H:%i:%s'),'5');
INSERT INTO emision_table (radio, fechaHora, tema) VALUES ('Europa FM',STR_TO_DATE('01-11-1981 08:03:01','%d-%m-%Y %H:%i:%s'),'7');
INSERT INTO emision_table (radio, fechaHora, tema) VALUES ('RNE3',STR_TO_DATE('02-01-1981 08:03:01','%d-%m-%Y %H:%i:%s'),'1'); -- RNE3 emite solo a Sabina
INSERT INTO emision_table (radio, fechaHora, tema) VALUES ('40 Principales',STR_TO_DATE('03-01-1987 08:03:01','%d-%m-%Y %H:%i:%s'),'2'); -- 40 Principales lo emite todo, menos AC/DC
INSERT INTO emision_table (radio, fechaHora, tema) VALUES ('40 Principales',STR_TO_DATE('27-10-1987 09:03:01','%d-%m-%Y %H:%i:%s'),'4');
INSERT INTO emision_table (radio, fechaHora, tema) VALUES ('40 Principales',STR_TO_DATE('03-04-1987 10:03:01','%d-%m-%Y %H:%i:%s'),'8');
INSERT INTO emision_table (radio, fechaHora, tema) VALUES ('40 Principales',STR_TO_DATE('08-01-1987 11:03:01','%d-%m-%Y %H:%i:%s'),1);
INSERT INTO emision_table (radio, fechaHora, tema) VALUES ('40 Principales',STR_TO_DATE('03-02-1987 12:03:01','%d-%m-%Y %H:%i:%s'),'5');
INSERT INTO emision_table (radio, fechaHora, tema) VALUES ('40 Principales',STR_TO_DATE('03-03-1987 13:03:01','%d-%m-%Y %H:%i:%s'),'1');
INSERT INTO emision_table (radio, fechaHora, tema) VALUES ('40 Principales',STR_TO_DATE('28-10-1987 14:03:01','%d-%m-%Y %H:%i:%s'),'4');

/* --RANKING */
INSERT INTO ranking_table VALUES(1989,1,5000000011,1000000011,2000000011);
INSERT INTO ranking_table VALUES(1989,2,5000000011,1000000011,2000000011);
INSERT INTO ranking_table VALUES(1989,3,5000000011,1000000011,2000000011);
INSERT INTO ranking_table VALUES(1989,4,5000000011,1000000011,2000000011);
INSERT INTO ranking_table VALUES(1989,5,5000000011,1000000011,2000000011);
INSERT INTO ranking_table VALUES(1989,6,1000000011,5000000011,2000000011);
INSERT INTO ranking_table VALUES(1989,7,1000000011,5000000011,2000000011);
INSERT INTO ranking_table VALUES(1989,8,1000000011,5000000011,2000000011);
INSERT INTO ranking_table VALUES(1989,9,1000000011,5000000011,2000000011);
INSERT INTO ranking_table VALUES(1989,10,1000000011,5000000011,2000000011);
INSERT INTO ranking_table VALUES(1990,1,2000000111,1000000011,5000000011);
INSERT INTO ranking_table VALUES(1990,2,5000000011,1000000011,2000000111);
INSERT INTO ranking_table VALUES(1990,3,3000000011,1000000011,2000000011);
INSERT INTO ranking_table VALUES(1990,4,5000000011,1000000011,3000000011);
INSERT INTO ranking_table VALUES(1990,5,5000000011,1000000011,3000000011);


/* -- 2.2: */
INSERT INTO grupo_table VALUES('Rosalía',2013,'Espanya');

INSERT INTO vinilo_table VALUES(6000000001,STR_TO_DATE('18-03-2022','%d-%m-%Y'),100000,'Rosalía','Columbia Records');
INSERT INTO vinilo_table VALUES(6000000011,STR_TO_DATE('04-02-2022','%d-%m-%Y'),25000,'Rosalía','Columbia Records');

INSERT INTO lp_table VALUES(6000000001,'Motomai',100000);

INSERT INTO sencillo_table VALUES(6000000011,6000000001);

INSERT INTO tema_table VALUES(10,'Saoko',137,'Rosalía',6000000001,'A',1,6000000011,'A',1);
INSERT INTO tema_table VALUES(11,'Candy',193,'Rosalía',6000000001,'A',1,NULL,NULL,NULL);
INSERT INTO tema_table VALUES(12,'Bizcochito',109,'Rosalía',6000000001,'B',1,NULL,NULL,NULL);

INSERT INTO emision_table VALUES('40 Principales',STR_TO_DATE('03-04-2022 08:00:00','%d-%m-%Y %H:%i:%s'),10);
INSERT INTO emision_table VALUES('40 Principales',STR_TO_DATE('27-04-2022 09:00:00','%d-%m-%Y %H:%i:%s'),10);
INSERT INTO emision_table VALUES('40 Principales',STR_TO_DATE('05-05-2022 10:00:00','%d-%m-%Y %H:%i:%s'),10);
INSERT INTO emision_table VALUES('40 Principales',STR_TO_DATE('06-05-2022 11:00:00','%d-%m-%Y %H:%i:%s'),10);



/* -- 2.3: */
ALTER TABLE discografica_table ADD CONSTRAINT CK_DISC_PaisValido CHECK (pais IN ('Espanya','EEUU'));


/* -- 2.4: */
ALTER TABLE radio_table ADD CONSTRAINT Not_Same_URL UNIQUE (web);

END
