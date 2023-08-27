// Las l�neas que empiezan por "//" son comentarios. 
// EjemploRacional: programa que hace algunas operaciones con fracciones

// Es necesario incluir esta biblioteca para usar cout y cin. Es un archivo de cabecera, pero no termina en .h
// (en C++ no es obligatorio que los archivos de cabecera terminen en .h)
#include "iostream" 

#include "Racional.h" // Incluyo la clase "Racional" que me he creado

// Es necesario incluir esta directiva para especificar que todas las funciones
// y objetos predefinidos que usemos en el programa ser�n del paquete est�ndar
using namespace std;

// Todo programa C++ debe tener una funci�n "main", igual que en C. En C++, si una funci�n
// no tiene par�metros, se ponen los par�ntesis vac�os
int main()
{
	// Variables para guardar numerador y denominador que capturamos por teclado
	// Toda la sintaxis de variables b�sicas es igual que en C
	int numerador, denominador;

	// Pedimos y creamos el primer racional
	// Todas la sintaxis de bucles es igual que en C
	do {
		// El objeto "cout" (console out) representa a la pantalla. Enviamos un texto hacia la pantalla
		cout << "Introduzca numerador y denominador (separado por espacios) del racional a.\nEl denominador debe ser distinto de cero: ";
		cin >> numerador; // El objeto "cin" (console in) representa al teclado. Se env�a algo desde el teclado a esa variable
		cin >> denominador;
	} while (denominador == 0);
	
	// Creamos una variable de tipo "Racional". Cuando ya tenemos declarada la clase "Racional", podemos crear tantas
	// variables racionales como queramos. La sintaxis es la misma que si cre�ramos un "int" o un "float"
	// Como la clase "Racional" tiene un constructor que necesita dos par�metros, hay que ponerlos (entre par�ntesis) a la vez que se crea
	// la variable de tipo "Racional"
	// Una variable de una clase tambi�n se llama "objeto de esa clase". Las clases y los objetos es el n�cleo de cualquier
	// lenguaje orientado a objetos, como es C++
	// Por lo tanto, hemos creado un objeto de la clase Racional, y dicho objeto estar� contenido en la variable "a"
	Racional a(numerador, denominador);

	// Sobre el objeto "a", vamos a ejecutar uno de los algoritmos del TAD, en este caso el m�todo "escribir()"
	cout << "Racional a: ";
	a.escribir();
	cout << endl; // "endl" es equivalente a poner "\n"

	// Pedimos y creamos el segundo racional
	do {
		cout << "Introduzca numerador y denominador (separado por espacios) del racional b.\nEl denominador debe ser distinto de cero: ";
		cin >> numerador;
		cin >> denominador;
	} while (denominador == 0);

	// Creamos otro objeto de tipo "Racional" y lo guardamos en la variable "b". Es un objeto distinto a "a", que evoluciona
	// por s� mismo independientemente de "a", y que tiene sus propios valores de atributos (su propio numerador y su propio denominador)
	Racional b(numerador, denominador);

	// Llamamos al m�todo "escribir" de la fracci�n "b"
	cout << "Racional b: ";
	b.escribir();
	cout << endl;
	
	// Realizamos la suma y lo imprimimos
	// Llamamos al m�todo "sumar" sobre el objeto "a". Necesita para funcionar un par�metro, que es a su vez
	// otro objeto de tipo Racional (en este caso, le pasamos "b"). Lo que hace es crear un nuevo Racional 
	// (al cual le llamamos "resultado") cuyo numerador y denominador sean el resultado de la suma de 
	// fracciones a+b
	Racional resultado = a.sumar(b); // Resultado de las operaciones
	cout << "Racional a+b: ";
	resultado.escribir();
	cout << "\n";

	// Simplificamos y lo escribimos
	resultado.simplificar();
	cout << "Racional a+b simplificado: ";
	resultado.escribir();
	cout << endl;

	// Realizamos la multiplicaci�n y lo escribimos
	resultado = a.multiplicar(b);
	cout << "Racional a*b: ";
	resultado.escribir();
	cout << "\n";

	// Simplificamos y lo escribimos
	resultado.simplificar();
	cout << "Racional a*b simplificado: ";
	resultado.escribir();
	cout << endl;

	return 0;
}
