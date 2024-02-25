NUM=1000000

all: O0 O1 O2 O2mavx run

O0: 
	gcc Ejer2.c -o execO0 -fopenmp

O1: 
	gcc Ejer2.c -o execO1 -O1 -fopenmp

O2: 
	gcc Ejer2.c -o execO2 -O2 -fopenmp

O2mavx: 
	gcc Ejer2.c -o execO2mavx -O2 -mavx -fopenmp

run:
	./execO0 $(NUM);
	./execO1 $(NUM);
	./execO2 $(NUM);
	./execO2mavx $(NUM);