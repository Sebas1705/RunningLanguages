* LAB 1
* Ejemplo 07
*
* MAXIMIZAR        Z = 6 X1 + 5 X2 + 9 X3 + 40 X4
* SUEJETO A         X1 + X3 + 4 X4 <= 3
*                   X2 + X3 + 5 X4 <= 4
*                   X1, X2, X3 <=0
*                   X4 >=0


Free Variables
         z beneficio

Negative Variables
         x1, x2, x3
;

Positive Variables
         x4
;

Equations
         beneficio beneficios
         restricc1
         restricc2
;

         beneficio..      z =e= 6*x1 + 5*x2 + 9*x3 + 40*x4;
         restricc1..      x1 + x3 + 4*x4 =l= 3;
         restricc2..      x1 + x3 + 5*x4 =l= 4;
;

Model LAB1_Ejemplo07 /all/;

Solve LAB1_Ejemplo07 using lp maximizing z;
