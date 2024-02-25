VARIABLES z;
POSITIVE VARIABLES x1, x2, x3;
EQUATIONS obj, equ1, equ2, equ3, equ4;
obj.. z =e= 0.15*x1 + 0.12*x2 + 0.20*x3;
equ1.. x1 + x2 + x3 =e= 1;
equ2.. 10*x1 + 15*x2 + 5*x3 =l= 10;
equ3.. 40*x1 + 90*x2 + 30*x3 =g= 50;
equ4.. x1 =g= 0.4;
model Ejercicio5 /all/;
solve Ejercicio5 using lp minimizing z;


