#include "stdio.h"
#include "stdlib.h"
#include "time.h"
#include "omp.h"

int tam,*vA,*maxs;
int np,tid,i,j;

/**
 * @author sr.entrerrios.2020 / Sebas1705ç
 * @return int 0:OK -1:ERROR
 */
int main(int argc, char* argv[]){

    if(argc!=2){
        fprintf(stderr,"\tError arguments -%d-\n",argc);
        return -1;
    }

    omp_set_num_threads(8);

    tam=(int)strtol(argv[1],NULL,10);
    vA=(int*)malloc(sizeof(int)*tam);
    maxs=(int*)malloc(sizeof(int)*(tam/2));
    srand(0);
    for(i=0;i<tam;i++)vA[i]=rand()%10000;
    int n=omp_get_max_threads();
    double t0=omp_get_wtime();
    
    while(tam!=1){
        #pragma omp parallel private(np,tid,i,j)
        {
            np=omp_get_num_threads();
            tid=omp_get_thread_num();
            for(i=tid*2;i<tam;i+=(np*2)){
                int index=i/2;
                if(vA[i]>=vA[i+1])maxs[index]=vA[i];
                else maxs[index]=vA[i+1];
            }
        }
        tam/=2;
        vA=maxs;
        maxs=(int*)malloc(sizeof(int)*(tam/2));
    }

    double t1=omp_get_wtime();
    printf("Max: %d\n",vA[0]);
    free(vA);
    free(maxs);
    double elapse=t1-t0;
    printf("%s\t\tTiempo transcurrido: %.6lf s\n",argv[0],elapse);
    return 0;
}