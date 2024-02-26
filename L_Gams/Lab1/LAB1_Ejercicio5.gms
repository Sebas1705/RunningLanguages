***** LAB 1
***** Ejercicio 5
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
restriccion_3
restriccion_4
;

beneficio..      z =e= 0.15 * x1 + 0.12 * x2 + 0.20 * x3;
restriccion_1..  x1 + x2 + x3 =e= 1;
restriccion_2..  10 * x1 + 15 * x2 + 5 * x3 =l= 10;
restriccion_3..  40 * x1 + 90 * x2 + 30 * x3 =g= 50;
restriccion_4..  x1 =g= 0.4;
;

Model Lab1_Ejercicio5 /all/;

Solve Lab1_Ejercicio5 using lp minimizing z;

