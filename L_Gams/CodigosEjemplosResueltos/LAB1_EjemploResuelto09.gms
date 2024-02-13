* Ejemplo09
* MAX        Z = 4 X1 + 7 X2 + 6 X3 + 5 X4 + 4 X5
* S.a            5 X1 + 8 X2 + 3 X3 + 2 X4 + 7 X5 <=112
*                  X1 + 8 X2 + 6 X3 + 5 X4 + 4 X5 <=109
*                  X1, X2, X3, X4, X5 E Z


Free Variables
         z beneficio


Integer Variables
         x1, x2, x3, X4, X5
;

Equations
         beneficio beneficios
         rest1
         rest2

;
         beneficio..      z =e= 4*X1 + 7*X2 + 6*X3 + 5*X4 + 4*X5;
         rest1..          5*X1 + 8*X2 + 3*X3 + 2*X4 + 7*X5 =l= 112;
         rest2..         X1 + 8*X2 + 6*X3 + 5*X4 + 4*X5 =l= 109;
;

Model Lab1_Ejemplo09 /all/;

Solve Lab1_Ejemplo09 using mip maximizing z;
