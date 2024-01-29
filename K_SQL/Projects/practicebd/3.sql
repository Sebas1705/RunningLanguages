-- Active: 1694812751035@@127.0.0.1@3306@practicebd


-- 3.1 Nombre de los grupos españoles
SELECT nombre 
FROM grupo_table 
WHERE (pais = 'Espanya');

-- 3.2 Nombre y web de las emisoras de radio cuya 
-- web tenga dominio de España (por ejemplo, que 
-- contenga la cadena “.es/” o bien termine en “.es”):
SELECT nombre,web 
FROM radio_table 
WHERE web LIKE '%.es' OR web LIKE '%.es/%';

-- 3.3 Nombre de los grupos y número copias totales 
-- vendidas, ordenados de mayor a menor por el número 
-- de copias vendidas:
SELECT g.nombre, SUM(v.copiasvendidas) as copias
FROM grupo_table as g,vinilo_table as v 
WHERE g.nombre = v.grupo
GROUP BY g.nombre
ORDER BY copias DESC;


-- 3.4 Nombre de los autores (sin repetir) de los temas que se encuentran en sencillos.
SELECT DISTINCT t.autor
FROM sencillo_table as s,tema_table as t
WHERE s.isvn = t.sencillo

-- 3.5 Para los LPs con sencillos editados, ISVN del LP y número de sencillos editados.
SELECT l.isvn, COUNT(*) as n_sencillos_edit
FROM lp_table as l, sencillo_table as s
WHERE l.isvn = s.isvnlp
GROUP BY l.isvn

-- 3.6 Título de los LPs junto con el título, autor y duración de sus temas.
SELECT t.titulo,t.autor,t.duracion
FROM lp_table as l, tema_table as t
WHERE l.isvn = t.lp 

-- 3.7 Titulo y grupo de los LPs que superan en ventas las copias de lanzamiento.
SELECT t.titulo,v.grupo
FROM tema_table as t, lp_table as l, vinilo_table as v
WHERE t.lp = l.isvn AND l.isvn = v.isvn AND l.copiaslanzamiento < v.copiasvendidas

-- 3.8 Título de temas que no se han pinchado nunca en la radio.
SELECT t.titulo
FROM tema_table as t
WHERE (t.codigo NOT IN (SELECT DISTINCT e.tema FROM emision_table as e))

-- 3.9 ISVN y título de LPs de grupos españoles.
SELECT v.isvn,l.titulo
FROM vinilo_table as v, lp_table as l, grupo_table as g
WHERE v.isvn = l.isvn AND g.nombre = v.grupo AND g.pais = 'Espanya'

-- 3.10 ISVN y duración total de los sencillos cuya duración total sea superior a los 500 segundos.
SELECT s.isvn,SUM(t.duracion) as total
FROM sencillo_table as s, tema_table as t
WHERE s.isvn = t.sencillo
GROUP BY s.isvn 
HAVING total > 500

-- 3.11 ISVN del sencillo, título del LP al que pertenece, número de semanas en primer lugar del ranking durante el año 1989.
SELECT s.isvn, l.titulo, COUNT(s.isvn) as nSemanas
FROM sencillo_table as s,ranking_table as r,lp_table as l
WHERE s.isvn = r.primero AND r.anyo = 1989 AND l.isvn = s.isvnlp
GROUP BY s.isvn

-- 3.12 Nombre y nacionalidad de grupos alguno de cuyos vinilos están producidos por discográficas de su misma nacionalidad.
SELECT g.nombre,g.pais
FROM grupo_table as g,discografica_table as d, vinilo_table as v 
WHERE g.nombre = v.grupo AND d.nombre = v.discografica AND d.pais = g.pais

-- 3.13 Grupo que más veces se ha emitido en las radios y número total de emisiones.
SELECT MAX(total_emisiones)
FROM(
    SELECT grupo, COUNT(*) AS total_emisiones
    FROM (SELECT g.nombre as grupo
            FROM emision_table e 
            JOIN tema_table as t ON e.tema = t.codigo
            JOIN lp_table as l ON t.lp = l.isvn 
            JOIN sencillo_table as s ON s.isvnlp = l.isvn OR t.sencillo = s.isvn
            JOIN vinilo_table as v ON v.isvn = s.isvn 
            JOIN grupo_table as g ON v.grupo = g.nombre
        ) AS all_emisiones
    GROUP BY grupo
) AS emisiones_por_grupo

