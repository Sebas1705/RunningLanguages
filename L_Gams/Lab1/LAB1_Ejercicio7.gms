VARIABLES z;

POSITIVE VARIABLES x1, x2, x3;

EQUATIONS obj, equ1, equ2;

obj.. z =e= 6*x1 + 14*x2 + 3*x3;

equ1.. -x1 -7*x2 + x3 =e= -2;
equ2.. 2*x1 + 2*x2 + x3 =g= 1;

model Ejercicio7 /ALL/;
solve Ejercicio7 using lp maximizing z;