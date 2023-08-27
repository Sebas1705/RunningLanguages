#include <stdio.h>
#include <stdlib.h>

#ifdef __linux__
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(){
    pid_t pid = fork();
    if(pid<0){
        fprintf(stderr, "Error: pid generated have an error code\n");
        exit(-1);
    }else if(pid>0){
        fprintf(stdin,"I'm the child with pid: %d\n", pid);
    }else{
        fprintf(stdin,"I'm the father with pid: %d\n", pid);
        wait(NULL);
        fprintf(stdin,"Child finished\n");
    }
    return 0;
}
#endif

#ifdef _WIN32
#include <windows.h>

int main(){
    
    STARTUPINFO si;
    PROCESS_INFORMATION pi;

    ZeroMemory(&si, sizeof(si));
    si.cb = sizeof(si);
    ZeroMemory(&pi, sizeof(pi));

    //Create new process
    if (CreateProcess(NULL,   //Executable name (NULL if it is the same)
                      "notepad", //Executable to run
                      NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi)) {
        printf("Exit on create new process\n");
        //Wait for child:
        WaitForSingleObject(pi.hProcess, INFINITE);
        //Close handles:
        CloseHandle(pi.hProcess);
        CloseHandle(pi.hThread);
    } else {
        fprintf(stderr,"Error creating process. Error code: %d\n",(int)GetLastError());
    }
    return 0;
}
#endif
