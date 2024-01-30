NUM=100

all: count max maxDIV

count: CountSort.c
	gcc CountSort.c -o execCountSort -O2 -fopenmp;
	./execCountSort $(NUM);

max: Max.c
	gcc Max.c -o execMax -O2 -fopenmp;
	./execMax $(NUM);

maxDIV: MaxDIV.c
	gcc MaxDIV.c -o execMaxDIV -fopenmp;
	./execMaxDIV $(NUM);
	
	
	
	