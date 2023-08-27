#ifndef __RATIONAL
#define __RATIONAL

class Racional // "Racional" ser� el nombre de la clase
{

// Primero declaramos los atributos. Es decir: los datos interno que forman esta estructura de datos

// Los datos de un TAD son internos (privados), lo cual significa que s�lo se pueden ver/modificar ejecutando uno de los
// m�todos (algoritmos) del TAD, pero no se pueden modificar directamente desde el main o desde otros TADs
private: // A partir de ahora todo lo que escribamos es privado (s�lo se pueden ver/modificar desde los m�todos)

	int numerador; // Numerador
	int denominador; // Denominador. Precondici�n: denominador > 0

	// Ahora vamos a definir un m�todo, que es tambi�n privado (s�lo lo podemos ejecutar desde otros m�todos)

	// Calcula el m�ximo com�n divisor de dos operandos naturales, usando el algoritmo de Euclides
	// Par�metros:
	// - operando1: primer operando
	// - operando2: segundo operando
	// Retorno: m�ximo com�n divisor de los dos operandos pasados como argumento
	// Precondiciones: operando1 >= 0 && operando2 >= 0
	int calcularMaximoComunDivisor(int operando1, int operando2);

public: // Todo lo que escribamos a partir de ahora ser� p�blico, es decir, podemos ejecutarlo y acceder desde el main

	/* Constructor que construye un numero racional a partir de su numerador y denominador
	Par�metros:
	- Numerador: el numerador de la fracci�n
	- Denominador: el denominador de la fracci�n 
	Precondici�n: denominador != 0 */
	Racional(int nuevoNumerador, int nuevoDenominador); // El nombre de los constructores tienen que ser el mismo que la clase y no devuelven nada

	/* Suma "sumando" y el objeto actual. Crea un nuevo racional con el resultado y devuelve su copia
	Par�metro: el racional que es el segundo sumando
	Retorno: un nuevo racional, fruto de sumar "sumando" con el objeto actual */
	Racional sumar(Racional sumando);

	/* Multiplica "multiplicador" y el objeto actual. Crea un nuevo racional con el resultado y devuelve su copia
	Par�metro: el racional que es el multiplicador
	Retorno: un nuevo racional, fruto de multiplicar "multiplicador" con el objeto actual */
	Racional multiplicar(Racional multiplicador);

	/* Obtiene el numerador del objeto racional actual
	Retorno: numerador de la fracci�n del objeto actual */
	int getNumerador();

	/* Obtiene el denominador del objeto racional actual
	Retorno: numerador de la fracci�n del objeto actual */
	int getDenominador();

	/* Simplifica al maximo la fracci�n que representa al numero racional actual */
	void simplificar();

	/* Imprime por pantalla la fracci�n que representa al numero racional actual. Formato n/d.
	Si el numerador es 0 � el denominador es 1 s�lo se escribe el numerador.
	OJO: esto es un m�todo de interfaz, puramente inform�tico, que no estaba en la definici�n abstracta del TAD */
	void escribir();



};

#endif
