***** LAB 1
***** Ejercicio 6
***** Para entrega

Free Variables
z
;

Positive Variables
x1,x2,x3,x4,s0,s1,s2,s3,s4
;

Equations
beneficio
restriccion_1
restriccion_2
restriccion_3
restriccion_4
restriccion_5
;

beneficio..      z =e= 13 * x1 + 12 * x2 + 11 * x3 + 10 * x4;
restriccion_1..  s0 + x1 =e= 11 + s1;
restriccion_2..  s1 + x2 =e= 48 + s2;
restriccion_3..  s2 + x3 =e= 64 + s3;
restriccion_4..  s3 + x4 =e= 15 + s4;
restriccion_5..  s0 =e= 0;
;

Model Lab1_Ejercicio6 /all/;

Solve Lab1_Ejercicio6 using lp minimizing z;

