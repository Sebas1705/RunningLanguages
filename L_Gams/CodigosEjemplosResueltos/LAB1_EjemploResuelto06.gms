* Ejemplo06
*
* MAX        Z = 8 X1 + 3 X2 - 2 X3
* S.a        X1 + 6 X2 - X3 >=8
*            5 X1 + 7 X2 - 2 X3 =-4
*             X1 <=0
*             X2 >=0
*             x3 no restringido

Free Variables
         X3,
         z beneficio

Positive Variables
         x2

Negative Variable
         x1
;

Equations
         beneficio beneficios
         rest1
         rest2

;

         beneficio..      z =e= 8*x1 + 3*x2 - 2*x3;
         rest1..          x1 + 6*x2 - x3 =g= 8;
         rest2..          5*x1 + 7*x2 - 2*x3 =e= -4;
;

Model Lab1_Ejemplo06 /all/;

Solve Lab1_Ejemplo06 using lp maximizing z;
