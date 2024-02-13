***** LAB 1
***** Ejemplo01
* Visto en clase

*-----------------------------------
Free Variables
z
;
*-----------------------------------


Positive Variables
x1,x2
;

Equations
beneficio
restriccion_
restriccion_2
;

beneficio..      z =e= 100 * x1 + 125*x2;
restriccion..  3*x1 + 5 * x2 =L= 15;
restriccion_2..  90* x1  + 85 * x2  =L= 350;
;

Model Lab1_Ejemplo01 /all/;

Solve Lab1_Ejemplo01 using lp maximizing z;

