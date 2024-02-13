***** LAB 1
***** Ejercicio 7
***** Para entrega

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

beneficio..      z =e= 6 * x1 + 14 * x2 + 3 * x3;
restriccion_1..  - x1 - 7 * x2 + x3 =e= -2;
restriccion_2..  2 * x1 + 2 * x2 + x3 =g= 1;
;

Model Lab1_Ejercicio7 /all/;

Solve Lab1_Ejercicio7 using lp maximizing z;

