NUM=8000000

all: O0 O2  

O0: 
	gcc Ejer1.c -o execO0 -fopenmp;
	gcc SinOpenMp.c -o execO0s -fopenmp;
	./execO0 $(NUM);
	./execO0s $(NUM);
O1: 
	gcc Ejer1.c -o execO1 -O1 -fopenmp;
	gcc SinOpenMp.c -o execO1s -O1 -fopenmp;
	./execO1 $(NUM);
	./execO1s $(NUM);
O2: 
	gcc Ejer1.c -o execO2 -O2 -fopenmp;
	gcc SinOpenMp.c -o execO2s -O2 -fopenmp;
	./execO2 $(NUM);
	./execO2s $(NUM);
O2mavx: 
	gcc Ejer1.c -o execO2mavx -O2 -mavx -fopenmp;
	gcc SinOpenMp.c -o execO2mavxs -O2 -mavx -fopenmp;
	./execO2mavx $(NUM);
	./execO2mavxs $(NUM);
	
	
	
	