***** LAB 1
***** Ejemplo01
* Visto en clase

*-----------------------------------
**Declaracion de variables libres:
Free Variables
z
;
*-----------------------------------

*-----------------------------------
**Declaracion de variables no negativas(tipo entero):
Integer Variables
x1,x2
;
*-----------------------------------

*-----------------------------------
**Declaracion de la ecuacion objetivo y las restricciones:
Equations
beneficio
restriccion_1
restriccion_2
;
*-----------------------------------

*-----------------------------------
**Inizializacion de la ecuacion objetivo y las restricciones:
beneficio..      z =e= 100 * x1 + 125 * x2;
restriccion_1..  3 * x1 + 5 * x2 =L= 15;
restriccion_2..  90 * x1  + 85 * x2  =L= 350;
;
*-----------------------------------

*-----------------------------------
Model Lab1_Ejemplo01 /all/;
*-----------------------------------

*-----------------------------------
Solve Lab1_Ejemplo01 using MIP max z ;
*-----------------------------------
