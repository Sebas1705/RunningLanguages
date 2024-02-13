* LAB 1
* EjemploResuelto02
*
* MAXIMIZAR        Z = 24 X1 + 18 X2
* SUEJETO A        3 X1 + 4 X2 <= 12
*                  3 X1 + 3 X2 <= 10
*                  4 X1 + 2 X2 <= 8
*                  X >=0


Free Variables
         z beneficio
;

Positive Variables
         x1, x2
;

Equations
         beneficio beneficios
         restricc1
         restricc2
         restricc3
;

         beneficio..      z =e= 24*x1 + 18*x2;
         restricc1..      3*x1 + 4*x2 =l= 12;
         restricc2..      3*x1 + 3*x2 =l= 10;
         restricc3..      4*x1 + 2*x2 =l= 8;
;

Model LAB1_EjemploResuelto02 /beneficio,restricc1,restricc2,restricc3/;

Solve LAB1_EjemploResuelto02 using lp maximizing z;
