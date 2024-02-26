#include "stdio.h"
#include "stdlib.h"
#include "time.h"
#include "omp.h"

int tam,*vA,*sumaFinal;
int np,tid,i,sumaTotal=0;

/**
 * @author sr.entrerrios.2020 / Sebas1705ç
 * @return int 0:OK -1:ERROR
 */
int main(int argc, char* argv[]){

    if(argc!=2){
        fprintf(stderr,"\tError arguments -%d-\n",argc);
        return -1;
    }

    tam=(int)strtol(argv[1],NULL,10);
    vA=(int*)malloc(sizeof(int)*tam);
    sumaFinal=(int*)malloc(sizeof(int)*omp_get_num_threads());
    srand(0);
    for(i=0;i<tam;i++)vA[i]=rand()%10000;

    double t0=omp_get_wtime();
    // #pragma omp parralel private(np,tid,i)
    // {
    //     np=omp_get_num_threads();
    //     tid=omp_get_thread_num();
    //     for(i=tid;i<tam;i+=np){
    //         sumaFinal[tid]+=vA[i];
    //     }
    // }
    // for(i=0;i<omp_get_num_threads();i++) sumaTotal+=sumaFinal[i];
    #pragma omp parallel for reduction(+:sumaTotal)
    for(i=0;i<tam;i++)sumaTotal+=vA[i];
    printf("%d\n",sumaTotal);
    double t1=omp_get_wtime();
    
    free(vA);
    free(sumaFinal);
    double elapse=t1-t0;
    printf("%s\t\tTiempo transcurrido: %.6lf s\n",argv[0],elapse);
    return 0;
}