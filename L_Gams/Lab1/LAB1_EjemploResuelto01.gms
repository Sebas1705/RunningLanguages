***** LAB 1
***** EjemploResuelto01

Free Variables
z
;

Positive Variables
x1,x2,x3
;

Equations
beneficio
restriccion_1
restriccion_2
;

beneficio..      z =e= 3*x1-5*x2+x3;
restriccion_1..  x1 - x3 =e=1;
restriccion_2..  3*x1+2*x2-7*x3=e=5;
;

Model Lab1_Ejemplo01 /all/;

Solve Lab1_Ejemplo01 using lp minimizing z;
