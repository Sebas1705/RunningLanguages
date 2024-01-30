#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

#define MAX 10000

void countSort(int* array, int size) {
    int* count=(int*)calloc(MAX,sizeof(int));
    
    //Contamos las repeticiones:
    #pragma omp parallel for
    for(int i = 0; i < size; i++) {
        #pragma omp atomic
        count[array[i]]++;
    }

    //Creamos un array de apoyo que guarde las posiciones temporales:    
    int* start=(int*)calloc(MAX,sizeof(int));
    int sum = 0;
    for(int i=0;i<MAX;i++) {
        int temp = count[i];
        start[i] = sum;
        sum += temp;
    }
    
    int output[size];
    
    //Guardamos en el array con tamaño size los elementos ya colocados en orden:
    #pragma omp parallel for
    for(int i=0;i<size;i++) {
        int index=array[i];
        output[start[index]]=array[i];
        start[index]++;
    }
    
    //Copiamos del array de apoyo al original:
    #pragma omp parallel for
    for(int i=0;i<size; i++) {
        array[i] = output[i];
    }
}

int main(int argc, char* argv[]) {
    int tam, *vA, i;
    if (argc != 2) {
        fprintf(stderr, "\tError arguments -%d-\n", argc);
        return -1;
    }

    tam = (int)strtol(argv[1], NULL, 10);
    vA = (int*)malloc(sizeof(int)*tam);
    srand(0);
    for (i = 0; i < tam; i++) vA[i] = rand() % MAX;

    double t0 = omp_get_wtime();
    countSort(vA, tam);
    double t1 = omp_get_wtime();

    for (i = 0; i < tam; i++) {
        printf("%d ", vA[i]);
    }
    printf("\n");

    free(vA);
    double elapse = t1 - t0;
    printf("%s\t\tTiempo transcurrido: %.6lf s\n", argv[0], elapse);
    return 0;
}
