Sets
         i fabricas /F1,F2,F3/
         j residuos /C1, C2/
;

Parameters
         costes(i) costes de tratamiento de resisduos
                 / F1     15
                   F2     12
                   F3     19/
         min(j) cantidad minima de resisduos procesados
                 /C1     34
                  C2     45/
;

Free Variables
         z beneficio venta ordenadores
;

Positive Variables
         x(i,j) cantidades de ordenadores producidos
;

Equations
         beneficio beneficio de venta de ordenadores
         limites_recursos(j) restricciones de recursos
;

         beneficio..      z =e= costes("F1")*(x("F1","C1")/0.12) + costes(F2)*(x(F2,C1)/0.36) + costes(F3)*(x(F3,C2)/0.25);
         limites_recursos(j)..    sum(i, x(i,j)) =g= min(j);

Model Ejercicio2 /all/;


Solve Ejercicio2 using lp min z;