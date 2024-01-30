/*
#pragma once
#ifdef
#ifndef
#if
#endif
*/

#define FORALL(i,size) for(int i=0;i<size;i++)
#define APPLYTOALL(lista,funcion)\
    for(int i=0;i<lista.size();i++)\
        funcion(getElement(&lista,i));

#define CREARLISTA(tipoElemento)\
    struct lista_##tipoElemento\
    {\
        tipoElemento almacen[100];\
    }

int main(int argc, char** argv){

    FORALL(i,100)
    {
        printf("Hola\n");
    }

    return 0;
}
