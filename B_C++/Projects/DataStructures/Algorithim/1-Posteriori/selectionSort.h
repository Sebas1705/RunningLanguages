#ifndef __SELECTION_SORT
#define __SELECTION_SORT

/**
 * @brief Search min value of a vector delimited by a start and a end:
 * 
 * @param vector vector of elements 
 * @param n number of elements that have the vector
 * @param start first index of delimited vector
 * @param end last index of delimited vector
 * @return integer that represents the index of the min value
 * 
 * @pre end>=start>=0 && end<n && vector!=NULL
*/
int searchMin(int *vector, int n, int start, int end);

/**
 * @brief Sort from min to max values using the selection method. 
 * @see https://es.wikipedia.org/wiki/Ordenamiento_por_selecci%C3%B3n
 * 
 * @param vector vector of elements 
 * @param n number of elements that have the vector
 * 
 * @pre vector!=NULL
 */
void selectionSort(int *vector,int n);

#endif