#include "stdio.h"

__global__ void hello(){
    printf("Blockdim.x:\t%d\n",blockDim.x);
    printf("Blockdim.x:\t%d\n",blockIdx.x);
    printf("Blockdim.x:\t%d\n",threadIdx.x);
    printf("Hello world from device\n");
}

int main(){
    hello<<<1,10>>>();
    printf("Hello world from host\n");
    return 0;
}