Integer Variable 
    x1, x2, x3, x4, x5
;

Free Variable
    z
;

Equation
beneficio
restriccion_peso
restriccion_volumen
;

beneficio.. z =e= 4*x1 + 7*x2 + 6*x3 + 5*x4 + 4*x5;
restriccion_peso.. 5*x1 + 8*x2 + 3*x3 + 2*x4 + 7*x5 =l= 112;
restriccion_volumen.. 1*x1 + 8*x2 + 6*x3 + 5*x4 + 4*x5 =l= 109;

Model ProblemaDeLaMochila /all/;

Solve ProblemaDeLaMochila using MIP max z;