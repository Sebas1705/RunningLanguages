#include "Matrix.h"
#include <stdlib.h>
#include <assert.h>
#include <math.h>
#include <time.h>

int main(){
    double matrix[]={1,2,3,3,2,1,1,0,1};
    MATRIX* m=createFillMatrix(matrix,3,3);
    printMatrix(m,stdout);
    MATRIX* m2=multiplyMatrix(m,-2);
    printMatrix(m2,stdout);
    printf("%lf\n",-2.0*(1.0/-8.0));
    MATRIX* m3=inverseMatrix(m);
    printMatrix(m3,stdout);
    free(m3);
    free(m2);
    free(m);
    return 0;
}

MATRIX* createVoidMatrix(ui_t rows,ui_t columns){
    MATRIX* m=(MATRIX*)malloc(sizeof(MATRIX));
    m->columns=columns;
    m->rows=rows;
    m->values=(double*)malloc(sizeof(double)*columns*rows);    
    return m;
}

MATRIX* createFillMatrix(double* values,ui_t rows,ui_t cols){
    MATRIX* m=createVoidMatrix(rows,cols);
    for(ui_t i=0;i<m->rows*m->columns;i++)m->values[i]=values[i];
    return m;
}

int setValueMatrix(MATRIX* matrix,ui_t posRow,ui_t posCol,double value){
    assert(posRow<matrix->rows||posCol<matrix->columns);
    int pos=posRow*matrix->columns+posCol;
    matrix->values[pos]=value;
    return 0;
}

double getValueMatrix(MATRIX* matrix,ui_t posRow,ui_t posCol){
    assert(matrix!=NULL);
    ui_t pos=posRow*matrix->columns+posCol;
    return matrix->values[pos];
}

int fillMatrix(MATRIX* matrix,double value){
    assert(matrix!=NULL);
    for(ui_t i=0;i<matrix->rows;i++)
        for(ui_t j=0;j<matrix->columns;j++)
            if(setValueMatrix(matrix,i,j,value)) return 1;
    return 0;
}

int aleatoryFillMatrix(MATRIX* matrix,ui_t top){
    assert(matrix!=NULL);
    srand(time(NULL));
    for(ui_t i=0;i<matrix->rows;i++)
        for(ui_t j=0;j<matrix->columns;j++)
            if(setValueMatrix(matrix,i,j,((rand()%top)*pow(-1.0,((double)(rand()%2)))))) return 1;
    return 0;
}

void printMatrix(MATRIX* matrix,FILE* f){
    assert(matrix!=NULL&&f!=NULL);
    fprintf(f,"\n");
    for(ui_t k=0;k<matrix->columns;k++)fprintf(f,"--------");
    fprintf(f,"\n");
    for(ui_t i=0;i<matrix->rows;i++){
        for(ui_t j=0;j<matrix->columns;j++){
            fprintf(f,"| %.2lf ",getValueMatrix(matrix,i,j));
        }
        fprintf(f,"|\n");
        for(ui_t k=0;k<matrix->columns;k++)fprintf(f,"--------");
        fprintf(f,"\n");
    }
}

MATRIX* addMatrixes(MATRIX* matrix1, MATRIX* matrix2){
    assert(matrix1!=NULL&&matrix2!=NULL);
    assert(matrix1->columns==matrix2->columns&&matrix1->rows==matrix2->rows);
    MATRIX* m=createVoidMatrix(matrix1->rows,matrix1->columns);
    for(ui_t i=0;i<(m->columns*m->rows);i++)
        m->values[i]=matrix1->values[i]+matrix2->values[i];
    return m;
}

MATRIX* subMatrixes(MATRIX* matrix1, MATRIX* matrix2){
    assert(matrix1!=NULL&&matrix2!=NULL);
    assert(matrix1->columns==matrix2->columns&&matrix1->rows==matrix2->rows);
    MATRIX* m=createVoidMatrix(matrix1->rows,matrix1->columns);
    for(ui_t i=0;i<(m->columns*m->rows);i++)
        m->values[i]=matrix1->values[i]-matrix2->values[i];
    return m;
}

MATRIX* multiplyMatrixes(MATRIX* matrix1, MATRIX* matrix2){
    assert(matrix1!=NULL&&matrix2!=NULL);
    assert(matrix1->columns==matrix2->rows);
    MATRIX* m=createVoidMatrix(matrix1->rows,matrix2->columns);
    for(ui_t i=0;i<m->rows;i++){
        for(ui_t j=0;j<m->columns;j++){
            double val=0.0;
            for(ui_t k=0;k<m->columns;k++)
                val+=(getValueMatrix(matrix1,i,k)*getValueMatrix(matrix2,k,j));
            setValueMatrix(m,i,j,val);
        }
    }
    return m;
}

MATRIX* multiplyMatrix(MATRIX* matrix,double k){
    assert(matrix!=NULL);
    MATRIX* m=createVoidMatrix(matrix->rows,matrix->columns);
    for(ui_t i=0;i<m->columns*m->rows;i++)m->values[i]=k*matrix->values[i];
    return m;
}

MATRIX* miniMatrix(MATRIX* matrix,ui_t row,ui_t col){
    assert(matrix!=NULL);
    assert(matrix->rows==matrix->columns);
    MATRIX* m=createVoidMatrix(matrix->rows-1,matrix->columns-1);
    ui_t count=0;
    for(ui_t i=0;i<matrix->rows;i++){
        for(ui_t j=0;j<matrix->columns;j++){
            if(i==row||j==col)continue;
            else m->values[count++]=getValueMatrix(matrix,i,j);    
        }
    }
    return m;
}

double determinantMatrix(MATRIX* matrix){
    assert(matrix!=NULL&&matrix->rows==matrix->columns);
    if(matrix->rows==2){
        return (matrix->values[0]*matrix->values[3])-(matrix->values[1]*matrix->values[2]);
    }else{
        double det=0;
        ui_t j=0;
        for(ui_t i=0;i<matrix->rows;i++){
            MATRIX* mini=miniMatrix(matrix,i,j);
            det+=getValueMatrix(matrix,i,j)*(((i+1)+(j+1))%2==0?1.0:-1.0)*determinantMatrix(mini);
            free(mini);
        }
        return det;
    }   
}

MATRIX* transposeMatrix(MATRIX* matrix){
    assert(matrix!=NULL);
    MATRIX* m=createVoidMatrix(matrix->columns,matrix->rows);
    for(ui_t i=0;i<m->rows;i++){
        for(ui_t j=0;j<m->columns;j++){
            setValueMatrix(m,i,j,getValueMatrix(matrix,j,i));
        }
    }
    return m;
}

MATRIX* adjunctMatrix(MATRIX* matrix){
    assert(matrix!=NULL);
    MATRIX* m=createVoidMatrix(matrix->rows,matrix->columns);
    for(ui_t i=0;i<m->rows;i++){
        for(ui_t j=0;j<m->columns;j++){
            setValueMatrix(m,i,j,(((i+1)*(j+1))%2!=0?1.0:-1.0)*determinantMatrix(miniMatrix(matrix,i,j)));
        }
    }
    return m;
}

MATRIX* inverseMatrix(MATRIX* matrix){
    assert(matrix!=NULL);
    MATRIX* m=multiplyMatrix(transposeMatrix(adjunctMatrix(matrix)),(1/determinantMatrix(matrix)));
    return m;
}

