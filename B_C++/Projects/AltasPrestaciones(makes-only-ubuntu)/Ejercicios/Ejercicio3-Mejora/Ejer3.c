#include "stdio.h"
#include "stdlib.h"
#include "time.h"
#include "omp.h"

typedef unsigned short uc_t;
typedef unsigned long ul_t;

int tam;
uc_t* vA;
uc_t* vB;
int tam2;
ul_t* lvA;
ul_t* lvB;


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
    vA=(uc_t*)malloc(sizeof(uc_t)*tam);
    vB=(uc_t*)malloc(sizeof(uc_t)*tam);
    srand(0);
    for(int i=0;i<tam;i++){
        vA[i]=(uc_t)(rand()%1000);
        vB[i]=(uc_t)(rand()%1000);
    }

    for(int i=0;i<tam;i++)printf("%d ",vA[i]);
    printf("\n");
    for(int i=0;i<tam;i++)printf("%d ",vB[i]);
    printf("\n");

    tam2=tam/4;
    lvA=(ul_t*)vA;
    lvB=(ul_t*)vB;	
    
    //time_t t0 = clock();
    double t0 = omp_get_wtime();
    //Parrallel for with OpenMP
    //No hay reducción de tiempo con el OpenMP
    //#pragma omp parallel for num_threads(8)
    for(int i=0;i<tam2;i++){
        lvA[i]+=lvB[i];
    }
    //time_t t1 = clock();
    double t1 = omp_get_wtime();

    double elapse=t1-t0;
    printf("%s\t\tTiempo transcurrido: %.6lf s\n",argv[0],elapse);
    
    for(int i=0;i<tam;i++)printf("%d ",vA[i]);
    printf("\n");

    free(vA);
    free(vB);
    return 0;
}