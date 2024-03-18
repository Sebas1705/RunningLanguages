
//ejemplo para crear animaciones en módulo matriz LED con Arduino basado en MAX7219
#include <MD_MAX72xx.h>
 
#define HARDWARE_TYPE MD_MAX72XX::DR0CR0RR1_HW
#define NUM_OF_MATRIX 1
#define DELAY_ANIMATION 200

const byte ghost1[] = {0x18,0x7e,0xff,0xbd,0xff,0xff,0xff,0xa5};
const byte ghost2[] = {0x18,0x7e,0xbd,0xff,0xff,0xff,0xff,0xa5};
const byte ghost3[] = {0x18,0x7e,0xdb,0xff,0xff,0xff,0xff,0xa5};
const byte ghost4[] = {0x18,0x7e,0xff,0xdb,0xff,0xff,0xff,0xa5};
const byte ghost5[] = {0x18,0x7e,0x99,0x99,0xff,0xff,0xff,0xa5};
const byte ghost6[] = {0x3c,0x7e,0xd7,0xff,0xc3,0xff,0xff,0xdb};

MD_MAX72XX mx = MD_MAX72XX(HARDWARE_TYPE, 9, 11, 10, NUM_OF_MATRIX);

char letter = 'a';

void setup() {
  mx.begin(); 
  mx.control(MD_MAX72XX::TEST, true);
  delay(2000);
  // desactivando el modo de prueba
  mx.control(MD_MAX72XX::TEST, false);
  mx.control(MD_MAX72XX::INTENSITY, 5);
}

void loop() {
  //misc();
  //animateChar();
  animateGhost();
}

void misc(){
  // limpiar la matriz
  mx.clear();
  
  // encender los LEDs de las esquinas
  mx.setPoint( 0, 0, 1 );
  mx.setPoint( 7, 7, 1 );
  mx.setPoint( 0, 7, 1 );
  mx.setPoint( 7, 0, 1 );  
  delay(DELAY_ANIMATION);
  
  mx.setPoint( 3, 3, 1 );
  mx.setPoint( 3, 4, 1 );
  mx.setPoint( 4, 3, 1 );
  mx.setPoint( 4, 4, 1 );
  delay(2*DELAY_ANIMATION);
  
  for( int i = 0; i < 8; i += 2 ){
    
    // activar los LEDs alternos
    mx.setColumn( i, 0xAA );
 
    // esperar un tiempo
    delay(DELAY_ANIMATION);
 
    // estado invertido de la columna anterior
    mx.setColumn( i+1, ~0xAA );
    
    // esperar un tiempo
    delay(DELAY_ANIMATION);
  }

  delay(2*DELAY_ANIMATION);
  // invertir varias veces
  for( int i = 0; i < 12; i ++ ){
    mx.transform(MD_MAX72XX::TINV);
    delay(DELAY_ANIMATION);
  }
} // misc end


void animateChar( ){
  letter++;
  if( letter > 'z' ){
    letter = 'a';  
  }
  
  for( int i = 0; i < 12; i++ ){
    // limpiar la matriz
    mx.clear();
    // dibujar el caracter c empezando en la columna i
    mx.setChar( i, letter );
    // esperar un tiempo
    delay(DELAY_ANIMATION);
  }
}// animateChar end


void animateGhost(){
  // limpiar la pantalla
  mx.clear();
  
  // dibujar gráfico 1
  drawRows(ghost1);
  delay(2*DELAY_ANIMATION);
  // dibujar gráfico 2
  drawRows(ghost2);
  delay(2*DELAY_ANIMATION);
  // dibujar gráfico 3
  drawRows(ghost3);
  delay(2*DELAY_ANIMATION);
  // dibujar gráfico 4
  drawRows(ghost4);
  delay(2*DELAY_ANIMATION);
  // dibujar gráfico 5
  drawRows(ghost5);
  delay(2*DELAY_ANIMATION);
  // dibujar gráfico 6
  drawRows(ghost6);
  delay(2*DELAY_ANIMATION);
  
  // rotar varias veces la matriz.
  for( int i = 0; i < 8; i++ ){
    mx.transform( MD_MAX72XX::TRC );
    delay(DELAY_ANIMATION*3);
  }
}


void drawRows( const byte fig[] ){
  for( int i = 0; i < 8; i++ ){
    mx.setRow(0, i, fig[i]);
  }
}


