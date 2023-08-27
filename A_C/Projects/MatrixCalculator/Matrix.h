#ifndef __MATRIX_H__
#define __MATRIX_H__

#include <stdio.h>

#define MAX_TAM 20
typedef unsigned int  ui_t;

typedef struct{
    ui_t rows,columns;
    double *values;
}MATRIX;

//Create a void matrix and return its pointer:
MATRIX* createVoidMatrix(ui_t rows,ui_t columns);

//Create a matrix and return its pointer:
MATRIX* createFillMatrix(double* values,ui_t rows,ui_t cols);

//Set a especial position a value:
int setValueMatrix(MATRIX* matrix,ui_t posRow,ui_t posCol,double value);

//Get a value from an especial position:
double getValueMatrix(MATRIX* matrix,ui_t posRow,ui_t posCol);

//Fill a matrix with same value:
int fillMatrix(MATRIX* matrix,double value);

//Fill a matrix with aleatory values:
int aleatoryFillMatrix(MATRIX* matrix,ui_t top);

//Ask for the number of rows:
ui_t getRows(MATRIX* matrix);

//Ask for the number of columns:
ui_t getColumns(MATRIX* matrix);

//Print the matrix in the respective output:
void printMatrix(MATRIX* matrix,FILE* f);

//Add two matrix and return the pointer result:
MATRIX* addMatrixes(MATRIX* matrix1, MATRIX* matrix2);

//Sub two matrix and return the pointer result:
MATRIX* subMatrixes(MATRIX* matrix1, MATRIX* matrix2);

//Multiply two matrix and return the pointer result:
MATRIX* multiplyMatrixes(MATRIX* matrix1, MATRIX* matrix2);

//Multiply by a integer and return the pointer result:
MATRIX* multiplyMatrix(MATRIX* matrix,double k);

//Gives the mini matrix of a row and a column:
MATRIX* miniMatrix(MATRIX* matrix,ui_t row,ui_t col);

//Determinant matrix and return the pointer result:
double determinantMatrix(MATRIX *matrix);

//Transpose a matrix and return the pointer result:
MATRIX* transposeMatrix(MATRIX* matrix);

//Adjunct of a matrix and return the pointer result:
MATRIX* adjunctMatrix(MATRIX* matrix);

//Inverse of a matrix and return the pointer result:
MATRIX* inverseMatrix(MATRIX* matrix);


#endif