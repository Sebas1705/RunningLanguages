#include <omp.h>

int i,j,k;

int main(){


    //paralelo con varibles privadas
    #pragma omp parallel private(i,j,k)
    {

    }   
    #pragma omp master
    {
        //Codigo que ejecuta el hilo 0
    }

    #pragma omp critical
    {
        //Codigo ejectuado como seccion critica por los hilos.
    }

    #pragma omp single
    {
        //Solo se ejecuta por un hilo, el primero que llegue.
    }

    #pragma omp ordered 
    {
        //En serie por orden de hilos.
    }

    #pragma omp barrier
    {
        //Se ejecuta cuando es necesario que al final del codigo los hilos se esperen
    }

    //Se usa cuando se accede a una variable que solo puede usar el mienstras opere con ella
    #pragma omp atomic
    int a = 12332+12;

    //Se usa para separar trozos de codigo por un hilo
    #pragma omp section
    {
        #pragma omp section
        {

        }
    }
        

    return 0;
}