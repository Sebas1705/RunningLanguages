* Problema del LAB2
*
* Segunda modificacion: la posibilidad de pasar horas de CC2 a CC1
* pero no viceversa ya que la variable x(TO) >= 0
* cambios en:
* - conjunto i,
* - la matriz tecnologica
*


Sets
         i tipos de ordenadores y traspaso horas entre CC1 y CC2 / A, B, C, TO/
         j operaciones   /CC1, CC2, MNT/
;

Parameters
         precios(i) precios de venta de ordenadores
                 / A     350
                   B     470
                   C     610
                   TO      0/

         recursos(j) recursos disponibles
                 / CC1   120
                   CC2   48
                   MNT   2000 /
;

Table
         mtecn(i,j) matriz tecnologica
                 CC1     CC2     MNT
         A        1       0       10
         B        1       0       15
         C        0       1       20
         TO       -1      1       0
;

Free Variables
         z beneficio venta ordenadores
;

Positive Variables
         x(i) cantidades de ordenadores producidos y traspaso de horas entre CC1 y CC2
;

Equations
         beneficio beneficio de venta de ordenadores
         limites_recursos(j) restricciones de recursos
;

         beneficio..      z =e= sum(i, precios(i)*x(i));
         limites_recursos(j)..    sum(i, x(i)*mtecn(i,j)) =l= recursos(j);

Model LAB2modif2 /beneficio, limites_recursos/;

Solve LAB2modif2 using lp maximizing z;

* una manera de personalizar la impresion de los resultados
*Display 'beneficio = ', z.l, 'ordenadores = ', x.l, 'recursos = ', limites_recursos.l;
*
* otra manera de personalizar la impresion de los resultados
*file output /output.txt/;
*put output;
*put 'resultados modelo LAB2modif2'/;
*
*put 'f.o. beneficio = ', z.l/;
*
*put 'valores de variables de gestion:'/;
*loop(i,
*put x(i), '=', x.l(i) /;
*)
