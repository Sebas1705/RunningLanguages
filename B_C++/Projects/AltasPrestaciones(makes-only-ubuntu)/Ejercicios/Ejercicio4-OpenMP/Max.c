#include "stdio.h"
#include "stdlib.h"
#include "time.h"
#include "omp.h"

#define MAX 10000

int *vA;
int np,tid,i,tam;

int casoMax1(int argc, char *argv[]);
int casoCount(int argc, char *argv[]);
void printArr(int* arr, int tam);

/**
 * @author sr.entrerrios.2020 / Sebas1705
 * @return int 0:OK -1:ERROR
 */
int main(int argc, char *argv[]){
    if(argc!=2){
        fprintf(stderr,"\tError arguments -%d-\n",argc);
        return -1;
    }
    return casoCount(argc,argv);
}

int casoMax1(int argc, char* argv[]){

    tam=(int)strtol(argv[1],NULL,10);
    vA=(int*)malloc(sizeof(int)*tam);
    int* arr=(int*)malloc(sizeof(int)*omp_get_num_threads());
    srand(0);
    for(i=0;i<tam;i++)vA[i]=rand()%MAX;
    printArr(vA,tam);

    double t0=omp_get_wtime();
    #pragma omp parralel private(np,tid,i)
    {
        int max=0;
        np=omp_get_num_threads();
        tid=omp_get_thread_num();
        for(i=tid;i<tam;i+=np){
            if(max<vA[i])max=vA[i];
        }
        arr[tid]=max;
    }
    int maxt=0;
    for(i=0;i<omp_get_num_threads();i++)if(maxt<arr[i])maxt=arr[i];
    printf("%d\n",maxt);
    double t1=omp_get_wtime();
    
    free(vA);
    free(arr);
    double elapse=t1-t0;
    printf("%s\t\tTiempo transcurrido: %.6lf s\n",argv[0],elapse);
    return 0;
}

int casoCount(int argc, char *argv[]){

    tam=(int)strtol(argv[1],NULL,10);
    vA=(int*)malloc(sizeof(int)*tam);
    int* count=(int*)calloc(MAX,sizeof(int));
    srand(0);
    for(i=0;i<tam;i++)vA[i]=rand()%MAX;
    printArr(vA,tam);

    double t0=omp_get_wtime();
    for (int i=0;i<tam;i++) {
        count[vA[i]]++;// Sumamos uno en cada posición del array secundario en la posición que corresponda al valor leído
    }

    #pragma omp parallel private(np,tid,i)
    {
        
    }

    int index=0;
    for(int i=0;i<omp_get_num_threads();i++){
        for(int j=0;j<tam;j++){
            if(temp[i][j]!=0) vA[index++]=temp[i][j];
            else break;
        }
    }
    // int index=0;
    // for (int i=0;i<10000;i++) {
    //     for (int j=0;j<count[i];j++) {// Escribimos en el array inicial los valores ordenados
    //         vA[index++] = i;
    //     }
    // }
    double t1=omp_get_wtime();


    for(int i=0;i<omp_get_num_threads();i++)free(temp[i]);
    free(temp);
    printArr(vA,tam);
    free(count);
    free(vA);
    double elapse=t1-t0;
    printf("%s\t\tTiempo transcurrido: %.6lf s\n",argv[0],elapse);
    return 0;
}

void printArr(int* array, int size){
    for(int i=0;i<size;i++)printf("%d ",array[i]);
    printf("\n\n");
}