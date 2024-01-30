#include "stdio.h"
#include "stdlib.h"
#include "time.h"

__global__ void suma(int* array1, int* array2, int* result, int size){
    int pos = threadIdx.x+blockIdx.x*blockDim.x;
    result[pos]=array1[pos]+array2[pos];
}

int main(){
    int tam = 10;
    int *a,*b,*c;
    a=(int*)malloc(sizeof(int)*tam);
    b=(int*)malloc(sizeof(int)*tam);
    c=(int*)malloc(sizeof(int)*tam);
    srand(time(NULL));
    for(int i=0;i<tam;i++){
        a[i]=rand()%10000;
        b[i]=rand()%10000;
    }

    //Device:
    int *d_a,*d_b,*d_c;
    cudaMalloc(&d_a,sizeof(int)*tam);
    cudaMalloc(&d_b,sizeof(int)*tam);
    cudaMalloc(&d_c,sizeof(int)*tam);

    cudaMemcpy(a,d_a,sizeof(int)*tam,cudaMemcpyHostToDevice);
    cudaMemcpy(b,d_a,sizeof(int)*tam,cudaMemcpyHostToDevice);
    suma<<<1,10>>>(d_a,d_b,d_c,tam);
    cudaMemcpy(d_c,c,sizeof(int)*tam,cudaMemcpyDeviceToHost);

    cudaFree(d_a);
    cudaFree(d_b);
    cudaFree(d_c);

    for(int i=0;i<10;i++)printf("%d--",a[i]);
    printf("\n");
    for(int i=0;i<10;i++)printf("%d--",b[i]);
    printf("\n");
    for(int i=0;i<10;i++)printf("%d--",c[i]);
    printf("\n");

    free(a);
    free(b);
    free(c);
    
    return 0;
}