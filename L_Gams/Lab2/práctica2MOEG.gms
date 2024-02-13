* Codigo de apoyo para LAB 2
* MOEG
*
*
* El codigo esta muy incompleto
* El codigo debe completarse y corregirse.
*
*

Sets
         i tipos de ordenadores /A, B, C/
         j tipos de operaciones /CC1, CC2, MNT/
         t semana /S1*S4/

* �necesitamos otros indices?
;

Parameters
         p(i) precio por ordenador
                /A  350
                 B  470
                 C  610/
         pS(i) precio por ordenador en remate final
                /A  300
                 B  400
                 C  500/
         c(i) coste de almacenaje por ordenadores
                /A  19
                 B  15
                 C  15/
         ex(i) existencias de ordenadores
                /A  25
                 B  48
                 C  36/
         re(j) recursos disponibles
               /CC1   120
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

Table
         d(i,t) prevision de demanda para cuatro semanas
            S1              S2              S3              S4
  A         80              80              120             140
  B         60              40              60              40
  C         80              40              80              70

* �necesitamos otras matrices?
;

Free Variables
         z beneficio venta ordenadores
;

Positive Variables
         X(i,t) nº ordenadores del tipo i fabricados en la semana t
         S(i,t) nº ordenadores del tipo i en stock en el fin de semana t
         V(i,t) nº ordenadores del tipo i vendidos semana t
         Sf(i) nº ordenadores del tipo i en stock al final de las semanas   
;

Equations
         beneficio beneficio de venta de ordenadores
         lim_recursos(j,t) restricciones de recursos
         rest1(i,t) minimo de ventas
         rest2(i,t) maximo de ventas
         rest3(i,t) control de stock
         rest4(i,t) venta menor que disponibilidad
         rest5(i,t) venta stock menor que el stock
         rest6(i) restriccion de stock final
         restfinal(i) situacion al finalizar la ultima semana

* �m�s restricciones?
;

         beneficio..     z =e= sum(i, sum(t, p(i)*V(i,t) - c(i)*S(i,t)) + Sf(i)*pS(i)) ;
         lim_recursos(j,t)..  sum(i, mtecn(i,j)*V(i,t)) =l= re(j);
         rest1(i,t)..    V(i,t) =g= 20;
         rest2(i,t)..    V(i,t) =l= d(i,t);
         rest3(i,t)..    S(i,t) =e= X(i,t) - V(i,t) + S(i,t-1);
         rest4(i,t)..    V(i,t) =l= d(i,t);
         rest5(i,t)..    V(i,t) =l= S(i,t);
         rest6(i)..  Sf(i) =g= 20;
         restfinal(i).. Sf(i) =e= sum(t, sum(i, S(i,t) - V(i,t))

Model LAB2_MOEG /all/

Solve LAB2_MOEG using lp maximizing z;
* Solve LAB2_MOEG using mip maximizing z;