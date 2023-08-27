// En este archivo pondremos el c�digo de los m�todos de nuestra clase Racional

#include "Racional.h" // Para saber de qu� clase estamos hablando y cual es su definicion
#include "iostream" // Para poder usar cout y cin
#include "cmath" // Para usar "abs()"
#include "cassert" // Para utilizar la macro "assert()"
using namespace std;

// Es necesario poner "Racional::" delante del nombre del m�todo para especificar que este m�todo est�
// declarado dentro de la clase "Racional". 
int Racional::calcularMaximoComunDivisor(int operando1, int operando2) {
	// assert sirve para comprobar que la precondici�n se cumple. Se pone como �nico par�metro
	// una expresi�n booleana. Si se eval�a como verdadero, no ocurre nada. Si se eval�a como falso,
	// se interrumpe el programa y se indica la precondici�n violada
	assert(operando1 >= 0 && operando2 >= 0);

	// Calculamos el m�ximo com�n divisor de dos naturales usando el algoritmo de Euclides
	while (operando2 != 0) {
		int resto = operando1 % operando2; // Resto de la divisi�n entera entre los dos operandos
		operando1 = operando2;
		operando2 = resto;
	}
	return(operando1);
}

Racional::Racional(int nuevoNumerador, int nuevoDenominador) {
	assert(nuevoDenominador != 0);

	// Calculamos el signo de la fracci�n y lo ponemos en el numerador
	// Por lo tanto hacemos que el denominador siempre sea positivo
	if (nuevoDenominador < 0) {
		nuevoDenominador = -nuevoDenominador;
		nuevoNumerador = -nuevoNumerador;
	}

	// Guardamos el numerador y el denominador en el objeto actual
	numerador = nuevoNumerador;
	denominador = nuevoDenominador;
}

Racional Racional::sumar(Racional sumando) {
	// Sumamos dos fracciones: la del objeto actual (this) y la pasada como par�metro
	// Para simplificar, las llamaremos numerador1/denominador1 y numerador2/denominador2
	int numerador1 = numerador;
	int denominador1 = denominador;
	int numerador2 = sumando.getNumerador();
	int denominador2 = sumando.getDenominador();

	int nuevoDenominador; // Nuevo denominador de la fraccion resultante
	int nuevoNumerador;   // Nuevo numerador de la fracci�n resultante

	// El nuevo denominador com�n del resultado idealmente seria el m�nimo comun m�ltiplo, pero
	// para simplificar hacemos que sea la multiplicaci�n de ambos denominadores
	nuevoDenominador = denominador1 * denominador2;

	// A partir del nuevo denominador com�n, calculamos los nuevos numeradores de los sumandos
	numerador1 = numerador1 * denominador2;
	numerador2 = numerador2 * denominador1;

	// Calculamos el numerador del resultado
	nuevoNumerador = numerador1 + numerador2;

	// Creamos la fracci�n resultado y lo devolvemos
	Racional resultado(nuevoNumerador, nuevoDenominador);
	return (resultado);
}

Racional Racional::multiplicar(Racional multiplicador) {
	// Calculamos el nuevo numerador y denominador del resultado
	int nuevoNumerador = numerador * multiplicador.getNumerador();
	int nuevoDenominador = denominador * multiplicador.getDenominador();

	// Creamos el resultado y lo devolvemos
	Racional resultado(nuevoNumerador, nuevoDenominador);
	return (resultado);
}

int Racional::getNumerador() {
	return(numerador);
}

int Racional::getDenominador() {
	return(denominador);
}

void Racional::simplificar() {
	int maximoComunDivisor; // m�ximo com�n divisor del valor absoluto del denominador y del valor absoluto del denominador
	maximoComunDivisor = calcularMaximoComunDivisor(abs(numerador), abs(denominador));
	numerador = numerador / maximoComunDivisor;
	denominador = denominador / maximoComunDivisor;
}

void Racional::escribir() {
	if (numerador == 0 || denominador == 1) cout << numerador;
	else cout << numerador << "/" << denominador; // Se imprimen tres cosas seguidas por la pantalla
}
