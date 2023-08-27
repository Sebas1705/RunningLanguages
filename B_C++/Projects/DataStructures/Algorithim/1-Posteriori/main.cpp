#include "printVectors.h"
#include "quickSort.h"
#include "selectionSort.h" 

#include "ctime" 
#include "cstdlib" 
#include "iostream"
#include "cassert"
#include "cstring"

#define MAX_RAND 100

using namespace std;

int main() {

	int n; 
	srand(time(NULL));

	cout << "Introduce the size of the vector (number greater than 1): ";
	cin >> n;

	int *vector=(int*)malloc(n*sizeof(int));
	for (int i=0;i<n;i++) vector[i]=rand()%MAX_RAND;

	int *vector_selection=(int*)malloc(n*sizeof(int));
	int *vector_quick=(int*)malloc(n*sizeof(int));
	memcpy(vector_selection,vector,sizeof(int)*n);
	memcpy(vector_quick,vector,sizeof(int)*n);

	cout << "\nVector: ";
	printV(vector,n);
	free(vector);
	cout << endl << endl;

	unsigned long int start_clocks=clock();
	cout << "Start_clock selection: " << start_clocks << endl;
	selectionSort(vector_selection,n);
	unsigned long int end_clocks=clock();
	cout << "End_clock selection:   " << end_clocks << "." << endl;
	cout << "CLOCK_PER_SEC:         " << CLOCKS_PER_SEC << "." << endl;
	printf ("Selection sort:        %.3f segs.\nVector_result: ",(end_clocks-start_clocks)/(float)CLOCKS_PER_SEC);
	printV  (vector_selection, n);
	cout << endl << endl;

	start_clocks=clock();
	cout << "Start_clock quick: " << start_clocks << endl;
	qsort(vector_quick,n,sizeof(int),compareIntegers);
	end_clocks=clock();
	cout << "End_clock quick:   " << end_clocks << "." << endl;
	cout << "CLOCK_PER_SEC:     " << CLOCKS_PER_SEC << "." << endl;
	printf ("Quick sort:        %.3f segs.\nVector_result: ",(end_clocks-start_clocks)/(float)CLOCKS_PER_SEC);
	printV  (vector_quick, n);
	cout << endl << endl;

	return 0;
}
