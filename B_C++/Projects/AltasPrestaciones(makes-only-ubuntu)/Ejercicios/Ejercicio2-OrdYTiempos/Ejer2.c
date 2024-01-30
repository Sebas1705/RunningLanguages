#include "stdio.h"
#include "stdlib.h"
#include "time.h"
#include "omp.h"

int tam;
int* vA;

void quicksort(int* array,int size);

/**
 * @author sr.entrerrios.2020 / Sebas1705
 * @param argc have to be 2 arguments 
 * @param argv[0]: name of the program
 * @param argv[1]: tam of arrays
 * 
 * @return int 0:OK -1:ERROR
 */
int main(int argc, char* argv[]){

    if(argc!=2){
        fprintf(stderr,"\tError arguments -%d-\n",argc);
        return -1;
    }

    tam=(int)strtol(argv[1],NULL,10);
    vA=(int*)malloc(sizeof(int)*tam);
    srand(0);
    for(int i=0;i<tam;i++){
        vA[i]=rand()%10000;
    }

    double t0=omp_get_wtime();
    quicksort(vA,tam);
    double t1=omp_get_wtime();
    printf("%s\t\tTiempo: %.6lf\n",argv[0],(t1-t0));

    free(vA);
    return 0;
}

void quicksort(int* array,int size) {
    //Si el array es de tamaño 1 no se hace nada:
    if(size==1){
        return;
    }
    //Si es de tamaño 2 se hace un simple swap:
    else if(size==2){
        if(array[0]>array[1]){
            int temp=array[1];
            array[1]=array[0];
            array[0]=temp;
        }
    }
    //Si es de tamaño mayor a dos se procede recursivamente:
    else if (size>2){
        //El pivote sera siempre el primer elemento
        int piv=array[0];
        //Se usa un array temporal para la ordenacion alrededor del pivote:
        int* tempArray=(int*)malloc(size*sizeof(int));
        int iMenores=0,iMayores=0,iIguales=1;
        for(int i=1;i<size;i++){
            if(array[i]==piv)iIguales++;
            else if(array[i]<piv)tempArray[iMenores++]=array[i];
            else tempArray[size-1-iMayores++]=array[i];
        }
        //Se copian los datos en el array original:
        for(int i=0;i<iMenores;i++)array[i]=tempArray[i];
        for(int i=iMenores;i<iMenores+iIguales;i++)array[i]=piv;
        for(int i=size-iMayores;i<size;i++)array[i]=tempArray[i];
        free(tempArray);
        
        //Y se llama recursivamente en el caso de los laterales a los iguales del pivote:
        quicksort(array,iMenores);
        quicksort(array+(size-iMayores),iMayores);
  }
}
