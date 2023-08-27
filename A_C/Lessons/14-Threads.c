#include <stdio.h>
#include <stdlib.h>

#ifdef __linux__
#include <pthread.h>

void *thread_func(void *arg) {
    int value = *((int*)arg);
    printf("Hi from thread, value: %d\n", value);
    return NULL;
}

int main() {
    pthread_t thread;
    int value = 42;

    //Create a new thread:
    if (pthread_create(&thread, NULL, thread_func, &valor) != 0) {
        printf("Failed to create a thread.\n");
        return 1;
    }

    //Join the thread:
    if (pthread_join(thread, NULL) != 0) {
        printf("Failed to wait a thread.\n");
        return 1;
    }

    printf("Thread finished.\n");

    return 0;
}
#endif

#ifdef _WIN32
#include <windows.h>

DWORD WINAPI thread_func(LPVOID lpParam){
    int value=*((int *)lpParam);
    printf("Hi from thread, value: %d\n", value);
    return 0;
}

int main(){
    HANDLE thread;
    int valor = 42;

    //create a thread:
    thread=CreateThread(NULL,0,thread_func,&valor,0,NULL);

    if (thread == NULL) {
        printf("Created thread failed. Error code: %d\n", GetLastError());
        return 1;
    }

    //Wait thread:
    WaitForSingleObject(thread,INFINITE);
    //Close handle:
    CloseHandle(thread);
    printf("Thread finished.\n");
    return 0;
}


#endif