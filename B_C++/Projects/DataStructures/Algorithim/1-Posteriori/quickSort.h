#ifndef __QUICK_SORT
#define __QUICK_SORT

/**
 * @brief Compare two integers using qsort() function
 * 
 * @param pointer1 pointer to first integer
 * @param pointer2 pointer to second integer
 * @return integer tha represent compare: <0 if 1 > 2, 0 if equal and >0 if 2 > 1
 * 
 * @pre pointer1!=NULL&&pointer2!=NULL
 */
int compareIntegers(const void *pointer1,const void *pointer2);

#endif