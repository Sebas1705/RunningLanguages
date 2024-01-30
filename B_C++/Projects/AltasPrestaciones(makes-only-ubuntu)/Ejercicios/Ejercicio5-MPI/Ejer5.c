#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <mpi.h>

#define N_TASKS 100
#define RAND_MAX_M 100
#define TAG_TASKS 1
#define TAG_STOP 2

int foo(int task,double** result);

double* result;

int main(int argc, char ** argv){

	int pid, np; //PID , number of processes
	MPI_Init(&argc,&argv);
	MPI_Comm_rank(MPI_COMM_WORLD, &pid);
	MPI_Comm_size(MPI_COMM_WORLD, &np);
	MPI_Status status;

	//Ejecución maestro:
	if(pid==0)
	{
        printf("Maestro: iniciando...\n");
        int tareasEnviadas=0,tareasRecividas=0,task=-1;
        srand(time(NULL));

        //Enviamos las primeras np tasks:
        for(int i=1;i<np;i++){
            if(tareasEnviadas<N_TASKS){
                task=rand()%RAND_MAX_M;
                printf("Maestro: tarea generada -> %d\n",task);
                MPI_Send(&task,1,MPI_INT,i,TAG_TASKS,MPI_COMM_WORLD);
                tareasEnviadas++;
            }
        }

        //Seguimos recibiendo y enviando en caso de que haya tareas pendientes:
        while(tareasRecividas<N_TASKS){
			MPI_Recv(&task,1,MPI_INT,MPI_ANY_SOURCE,TAG_TASKS,MPI_COMM_WORLD,&status);
            result=(double*)malloc(sizeof(double)*task);
            MPI_Recv(result,task,MPI_DOUBLE,status.MPI_SOURCE,TAG_TASKS,MPI_COMM_WORLD,NULL);
            printf("Maestro: tarea recivida -> %d\n",task);
            tareasRecividas++;

            //Proceso el resultado:
            double total=0;
            for(int i=0;i<task;i++){
                total+=result[i];
                printf("%.2lf",result[i]);
                if(i!=task-1) printf("-");
            }
            printf(" | Media: %.2lf\n",(task==0)?0.00:(total/task));
            free(result);
            //...

			if(tareasEnviadas<N_TASKS){
                task=rand()%RAND_MAX_M;
                printf("Maestro: tarea generada -> %d\n",task);
				MPI_Send(&task,1,MPI_INT,status.MPI_SOURCE,TAG_TASKS,MPI_COMM_WORLD);
				tareasEnviadas++;
			}
		}

        //Por ultimo mandamos una señal para que los esclavos terminen:
        //Mandamos una señal para que los esclavos terminen de trabajar:
		for(int i=1;i<np;i++) {
            task=0;
            printf("(%d) Enviado stop a %d\n",pid,i);
            MPI_Send(&task,0,MPI_INT,i,TAG_STOP,MPI_COMM_WORLD);
        }
	}

    //Ejecución esclavos:
    else{
        printf("\tEsclavo %d: iniciando...\n",pid);
        //Bucle que controla la recepción
        int task;
        while(1){
			//Recibimos la tarea:
			MPI_Recv(&task,1,MPI_INT,0,MPI_ANY_TAG,MPI_COMM_WORLD,&status);
			if(status.MPI_TAG==TAG_STOP) {
                printf("(%d) Recivido mensaje de stop\n",pid);
                break;
            }
            printf("\tEsclavo %d: recivida tarea -> %d\n",pid,task);

			//Realizamos tarea:
			task=foo(task,&result);
			//....

			//Enviamos la tarea:
			MPI_Send(&task,1,MPI_INT,0,TAG_TASKS,MPI_COMM_WORLD);
            MPI_Send(result,task,MPI_DOUBLE,0,TAG_TASKS,MPI_COMM_WORLD);
            printf("\tEsclavo %d: procesada y enviada tarea -> %d\n",pid,task);
		}
    }
	
    printf("Finaliza %d\n",pid);
	MPI_Finalize();
}

int foo(int task,double** result){
    int size = (task==0)?0:(rand()%task); //tamaño de los resultados
    *result=(double*)malloc(size*sizeof(double)); //resultados por parámetro
    for(int  i = 0; i < size; i++){
        (*result)[i]=(double)rand()/RAND_MAX;
    }
    return size; //la función devuelve el tamaño de los resultados
}
