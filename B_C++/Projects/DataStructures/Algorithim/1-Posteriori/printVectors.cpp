#include "cassert"
#include "iostream"
#include "printVectors.h"
#include "cstdlib"
using namespace std;

void printV(int *vector,int n) {
	assert(vector!=NULL);
	if(n>100){
		cout << "Vector too long\n";
		return;
	}
	for (int i = 0; i<n; i++)
		cout << vector[i] << " ";
	cout << endl;
}