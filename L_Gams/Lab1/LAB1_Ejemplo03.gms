***** LAB 1
***** Ejemplo03
***** Visto en clase

Free Variables
z
;

Positive Variables
x1,x2
;

Equations
beneficio
restriccion_1
restriccion_2
restriccion_3
;

beneficio..      z =e= 24*x1 + 18*x2;
restriccion_1..  3 * x1 + 4 * x2 =L= 12;
restriccion_2..  3 * x1 + 3 * x2 =L= 10;
restriccion_3..  4 * x1 + 2 * x2 =L= 8;
;

Model Lab1_Ejemplo03 /all/;

Solve Lab1_Ejemplo03 using mip maximizing z;
