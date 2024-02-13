* Laboratorio 1
* Ejemplo notaci'on matricial
*

Sets
         i tipos de ordenadores /A, B, C/
         j operaciones /CC1, CC2, MNT/
;

Parameters
         precios(i) precios de venta de ordenadores
                 / A     350
                   B     470
                   C     610/

         recursos(j) recursos disponibles
                 / CC1   120
                   CC2   48
                   MNT   2000/
;

Table
         mtecn(i,j) matriz tecnologica
                 CC1     CC2     MNT
         A        1       0       10
         B        1       0       15
         C        0       1       20
;

Free Variables
         z beneficio venta ordenadores
;

Positive Variables
         x(i) cantidades de ordenadores producidos
;

Equations
         beneficio beneficio de venta de ordenadores
         limites_recursos(j) restricciones de recursos
;

         beneficio..      z =e= sum(i, precios(i)*x(i));
         limites_recursos(j)..    sum(i, mtecn(i,j)*x(i)) =l= recursos(j);

Model Lab1_Ej_Matricial /beneficio, limites_recursos/;


Solve Lab1_Ej_Matricial using lp maximizing z;

* Display 'beneficio = ', z.l, 'ordenadores = ', x.l, 'recursos = ', limites_recursos.l;

*file output /output.txt/;
*put output;
*put 'resultados modelo pece'/;
*
*put 'f.o. beneficio = ', z.l/;
*
*put 'valores de variables de gestion:'/;
*loop(i,
*put x(i), '=', x.l(i) /;
*)
