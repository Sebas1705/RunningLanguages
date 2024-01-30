#include "stdio.h"
#include "stdlib.h"
#include "time.h"
#include "omp.h"

int tam,*vA,*vB;
int np=-1,tid=5,i=999;

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
    vB=(int*)malloc(sizeof(int)*tam);
    srand(0);
    for(i=0;i<tam;i++){
        vA[i]=rand()%1000;
        vB[i]=rand()%1000;
    }

    double t0=omp_get_wtime();
    #pragma omp parallel private(np,tid,i)
    {
        // printf("+---------+\n");
        // printf("|%3d | %3d|\n",np,tid);
        np=omp_get_num_threads();
        tid=omp_get_thread_num();
        for(i=tid;i<tam;i+=np){
            vA[i]+=vB[i];
        }
        // printf("|%3d | %3d|\n",np,tid);
        // printf("+---------+\n");
    }
    // printf("|%3d | %3d|\n",np,tid);
    double t1=omp_get_wtime();
    
    free(vA);
    free(vB);
    double elapse=t1-t0;
    printf("%s\t\tTiempo transcurrido: %.6lf s\n",argv[0],elapse);
    return 0;
}