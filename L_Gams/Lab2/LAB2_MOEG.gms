
Sets
         i tipos de ordenadores /A, B, C/
         j tipos de operaciones /CC1, CC2, MNT/
         t semana /S1*S4/
;

Parameters
         p(i) precio por ordenador
                /A  350
                 B  470
                 C  610/
         pS(i) precio por ordenador en remate final
                /A  332
                 B  450
                 C  574/
         c(i) coste de almacenaje por ordenadores
                /A  19
                 B  15
                 C  15/
         r(j) recursos disponibles
                /CC1  120
                 CC2  48
                 MNT  2000/
         sI(i) stock inicial
                /A  25
                 B  48
                 C  36/
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
;

Free Variables
         z beneficio venta ordenadores
;

Integer Variables
         X(i,t) nº ordenadores del tipo i fabricados en la semana t
         S(i,t) nº ordenadores del tipo i en stock en el fin de semana t
         V(i,t) nº ordenadores del tipo i vendidos semana t
;

Equations
         beneficio beneficio de venta de ordenadores
*         beneficioL
         rest_recursos(j,t) recursos disponibles por semana
         rest_minV(i,t) minimo de ventas
         rest_maxV(i,t) maximo de ventas
         rest_menorDisponibilidad(i,t) venta menor que disponibilidad
         rest_menorDisponibilidad1(i)  venta menor que disponibilidad en semana 1
         rest_menorStock(i,t) venta stock menor que el stock
         restfinal(i) situacion al finalizar la ultima semana
         res_semana1(i) situacion de la semana 1 stock
         res_semana2(i) situacion de la semana 2 stock
         res_semana3(i) situacion de la semana 3 stock
         res_semana4(i) situacion de la semana 4 stock
;

         beneficio..                        z =e= sum(t, sum(i, p(i)*V(i,t) - c(i)*S(i,t))) + sum(i, pS(i)*S(i,"S4")) ;

*         beneficioL..                       z =e= sum(t, V("A",t)*p("A")) + sum(t, V("B",t)*p("B")) + sum(t, V("C",t)*p("C"))
*                                            - sum(t, c("A")*S("A",t)) - sum(t, c("B")*S("B",t)) - sum(t, c("C")*S("C",t))
*                                            + S("A","S4")*pS("A") + S("B","S4")*pS("B") + S("C","S4")*pS("C");

         rest_recursos(j,t)..               sum(i, mtecn(i,j)*X(i,t)) =l= r(j);
         rest_minV(i,t)..                   V(i,t) =g= 20;
         rest_maxV(i,t)..                   V(i,t) =l= d(i,t);
         rest_menorDisponibilidad(i,t)..    V(i,t) =l= X(i,t) + S(i,t);
         rest_menorDisponibilidad1(i)..     V(i,"S1") =l= X(i,"S1") + sI(i);
         rest_menorStock(i,t)..             V(i,t) - X(i,t) =l= S(i,t);
         restfinal(i)..                     S(i,"S4") =g= 20;
         res_semana1(i)..                   S(i,"S1") =e= X(i,"S1") - V(i,"S1") + sI(i);
         res_semana2(i)..                   S(i,"S2") =e= X(i,"S2") - V(i,"S2") + S(i,"S1");
         res_semana3(i)..                   S(i,"S3") =e= X(i,"S3") - V(i,"S3") + S(i,"S2");
         res_semana4(i)..                   S(i,"S4") =e= X(i,"S4") - V(i,"S4") + S(i,"S3");
;


Model LAB2_MOEG /all/;

Solve LAB2_MOEG using MIP maximizing z;
*Solve LAB2_MOEG using mip maximizing z;