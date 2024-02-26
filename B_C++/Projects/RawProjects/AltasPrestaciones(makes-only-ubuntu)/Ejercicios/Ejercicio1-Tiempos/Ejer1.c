#include "stdio.h"
#include "stdlib.h"
#include "time.h"
#include "omp.h"

int tam;
int* vA;
int* vB;
int i;

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
    vB=(int*)malloc(sizeof(int)*tam);
    srand(0);
    for(i=0;i<tam;i++){
        vA[i]=rand()%1000;
        vB[i]=rand()%1000;
    }
    
    //time_t t0 = clock();
    double t0 = omp_get_wtime();
    //Parrallel for with OpenMP
    //No hay reducción de tiempo con el OpenMP
    #pragma omp parallel for num_threads(8)
    for(i=0;i<tam;i++){
        // #ifdef _OPENMP
        //     int np=omp_get_num_threads();
        //     printf("%d", np);
        // #endif
        vA[i]+=vB[i];
    }
    //time_t t1 = clock();
    double t1 = omp_get_wtime();

    free(vA);
    free(vB);

    double elapse=t1-t0;
    printf("%s\t\tTiempo transcurrido: %.6lf s\n",argv[0],elapse);
    return 0;
}