* Problema del LAB2
*
* Primera modificacion la posibilidad de outsourcing
* 
*  - se anade un nuevo parametro referente a los precios de outsourcing
*  - se modifica la función objetivo (beneficios)
*  - se modifica las desigualdades referentes a los recursos (limites_recursos(j))
*
* El precio de contratar el recurso CC2 se ha establecido en 0,
* pero puede ser cualquier numero ya que explicitamente se fija en 0 las horas contratadas
* para este recurso

Sets
         i tipos de ordenadores / A, B, C/
         j operaciones   /CC1, CC2, MNT/
;

Parameters
         precios(i) precios de venta de ordenadores
                 / A     350
                   B     470
                   C     610 /

         recursos(j) recursos disponibles
                 / CC1   120
                   CC2   48
                   MNT   2000 /

         p_recs_adds(j) precio de recursos adicionales
                 / CC1  40
                   CC2   0
                   MNT  30 /
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
         y(j) horas contratadas de outsourcing
;

Equations
         beneficio beneficio de venta de ordenadores
         limites_recursos(j) restricciones de recursos
;

         beneficio..      z =e= sum(i, precios(i)*x(i)) - sum(j, p_recs_adds(j)*y(j));
         limites_recursos(j)..    sum(i, mtecn(i,j)*x(i)) =l= recursos(j)+y(j);

Model LAB2modif /beneficio, limites_recursos/;

* condicion para que no se pudiera contratar el segundo control de calidad
y.fx('CC2') = 0;

Pece.OptFile=1;

Solve LAB2modif using lp maximizing z;

*Display 'beneficio = ', z.l, 'ordenadores = ', x.l, 'outsourcing = ', y.l, 'recursos = ', limites_recursos.l;
*
*file output /output.txt/;
*put output;
*put 'resultados modelo LAB2modif'/;
*
*put 'f.o. beneficio = ', z.l/;
*
*put 'valores de variables de gestion:'/;
*loop(i,
*put x(i), '=', x.l(i) /;
*)
*loop(j,
*put y(j), '=', y.l(j) /;
*)
