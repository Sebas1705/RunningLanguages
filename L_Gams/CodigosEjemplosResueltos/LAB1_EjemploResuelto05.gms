* LAB 1
* Ejemplo05
*
* MINIMIZAR        Z = 2 X1 - 1 X2
* SUEJETO A        -1 X1 + 1 X2 <= 2
*                  1 X1 + 1 X2 <= 4
*                  5 X1 + 3 X2 <= 15
*                  X1, X2 >=0


Free Variables
         z beneficio

Positive Variables
         x1, x2
;

Equations
         beneficio beneficios
         restricc1
         restricc2
         restricc3
;

         beneficio..      z =e= 2*x1 - 1*x2;
         restricc1..      -1*x1 + 1*x2 =l= 2;
         restricc2..      1*x1 + 1*x2 =l= 4;
         restricc3..      5*x1 + 3*x2 =l= 15;
;

Model LAB1_Ejemplo05 /all/;

Solve LAB1_Ejemplo05 using lp minizing z;

