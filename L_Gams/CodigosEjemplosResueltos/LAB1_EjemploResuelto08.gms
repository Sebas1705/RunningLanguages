* LAB 1
* Ejemeplo 08
*
* MAXIMIZAR        Z = 24 X1 + 18 X2
* SUEJETO A        3 X1 + 4 X2 <= 12
*                  3 X1 + 3 X2 <= 10
*                  4 X1 + 2 X2 <= 8
*                  X >=0
*
* Lo resolveremos en notación matricial.
* Se trata de 2 variables y 3 restrcciones.


Sets
         i  variables /1, 2/
         j  restricciones /Rest1, Rest2, Rest3/
;

Parameters
         precios(i)  coeficientes funcion objetivo
          / 1   24
            2   18/

         recursos(j)
          / Rest1  12
            Rest2  10
            Rest3  8 /
;

Table
         matriz_tecnol(i,j) matriz tecnologica
                 Rest1         Rest2         Rest3
         1        3             3             4
         2        4             3             2
;

Free Variables
         z beneficio

Positive Variable
         x(i)  productos fabricados
;

Equations
         beneficio beneficio total a maximizar
         lim_recursos(j) limites recursos
;

         beneficio..        z =e= sum(i, precios(i)*x(i));
         lim_recursos(j)..  sum(i, matriz_tecnol(i,j)*x(i)) =l= recursos(j);;
;

Model LAB1_Ejemplo08 /all/;
Solve LAB1_Ejemplo08 using lp maximizing z;
