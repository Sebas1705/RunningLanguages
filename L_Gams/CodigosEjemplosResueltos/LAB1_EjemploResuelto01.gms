***** LAB 1
***** EjemploResuelto01

Free Variables
z,x1
;

Positive Variables
x2,x3
;

Equations
beneficio
restriccion_1
restriccion_2
;

beneficio..      z =e= x1 + 3*x2 + 4*x3;
restriccion_1..  x1 + 2*x2 + x3 =e= 5;
restriccion_2..  2*x1 + 3*x2 + x3 =e= 6;
;

Model Lab1_Ejemplo01 /all/;

Solve Lab1_Ejemplo01 using lp minimizing z;
