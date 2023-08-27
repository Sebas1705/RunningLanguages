#include "cassert"
#include "quickSort.h"
#include "cstdlib"

int compareIntegers(const void *pointer1,const void *pointer2) {
	assert(pointer1!=NULL&&pointer2!=NULL);
	return *(int*)pointer1 - *(int*)pointer2;
}