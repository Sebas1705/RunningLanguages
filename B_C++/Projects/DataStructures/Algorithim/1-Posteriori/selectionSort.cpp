#include "cassert"
#include "selectionSort.h"
#include "cstdlib"

int searchMin(int *vector,int n,int start,int end) {
	assert(start>=0&&start<=end&&end<n&&vector!=NULL);
	int min=vector[start];
	int indexMin=start;
	for (int i=start+1;i<=end;i++) {
		if (vector[i]<min) {
			min=vector[i];
			indexMin=i;
		}
	}
	return indexMin;
}

void selectionSort(int *vector,int n) {
	assert(vector != NULL);
	for (int i=0;i<n;i++) {
		int indexMin=searchMin(vector,n,i,n-1);
		int temp=vector[i];
		vector[i]=vector[indexMin];
		vector[indexMin]=temp;
	}
}