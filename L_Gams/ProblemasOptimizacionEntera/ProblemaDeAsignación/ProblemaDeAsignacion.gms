Sets
         i tipos de ordenadores /A, B, C, D/
         j operaciones /Divorcio, FusionEmpresarial, Desfalco, Herencia/
;

Parameters
         precios(i) precios de venta de ordenadores
                 / A     350
                   B     470
                   C     610/
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

Model ProblemaDeAsignacion /all/;

Solve ProblemaDeAsignacion using MIP max z;