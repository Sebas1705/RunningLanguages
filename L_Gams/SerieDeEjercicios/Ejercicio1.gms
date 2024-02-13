Free Variables
    z
;

Positive Variable
    A, B
;

Equations
    beneficio
    res_maxA
    res_maxB
    res_min
    res_max
;

beneficio.. z =e= 1.12*A + 1.13*B;
res_maxA.. A =l= 8000000;
res_maxB.. B =l= 8000000;
res_min.. A + B =g= 2000000;
res_max.. A + B =l= 10000000;
;

Model Ejercicio1 /all/;

Solve Ejercicio1 using lp max z;