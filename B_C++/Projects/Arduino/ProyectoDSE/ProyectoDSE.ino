//Librerias:
#include <MD_MAX72xx.h>
#include <Servo.h>
#include <LiquidCrystal.h>
#include <IRremote.h>
#include <stdlib.h>

//-------------------------------------------------------------------
//Constantes:
#define HARDWARE_TYPE         MD_MAX72XX::DR0CR0RR1_HW
#define NUM_OF_MATRIX         2
#define DELAY_ANIMATION       200
#define N_FRAMES_AUTO         30
#define N_FRAMES_MANUAL       14
#define N_FRAMES_PARKING      8
#define N_RANGOS_PARPADEO     3
#define PARPADEOS_POR_FRAME   1
#define A_ROWS                8
#define GRADOS_PARKING        90
#define D_MAX                 50
#define D_MIN                 5
#define NUM_VELOCIDADES_AUTO  6
const float velocidades_auto[NUM_VELOCIDADES_AUTO]={2,1.75,1.5,1.25,1,0.75};
#define NUM_GRADOS_GIRO       4
const int grados_manual[NUM_GRADOS_GIRO]={3,6,12,36};

//-------------------------------------------------------------------
//Pines:
#define SERVO_PIN 13
#define TRIGGER   47
#define ECHO      49
#define DIN       22
#define CS        24
#define CLK       26
#define IR        9
#define RS        35
#define E         37
#define D4        39
#define D5        41
#define D6        43
#define D7        45

//-------------------------------------------------------------------
//Codigo modos:
#define MODO_AUTO     0
#define MODO_MANUAL   1
#define MODO_PARKING  2

//-------------------------------------------------------------------
//Codigos de devoluciones de isPressed:
#define NUM_OF_BUTTOMS  21
#define ON_OFF          0  // º
#define VOL_POS         1  // VOL+
#define FUNC_STOP       2  // FUNC/STOP
#define ARROW_LEFT      3  // >>|
#define PLAY_PAUSE      4  // >||
#define ARROW_RIGHT     5  // |<<
#define ARROW_DOWN      6  // ↓
#define VOL_NEG         7  // VOL-
#define ARROW_UP        8  // ^
#define ZERO            9  // 0
#define EQ              10 // EQ
#define ST_REPT         11 // ST/REPT
#define ONE             12 // 1
#define TWO             13 // 2
#define THREE           14 // 3
#define FOUR            15 // 4
#define FIVE            16 // 5
#define SIX             17 // 6
#define SEVEN           18 // 7
#define EIGHT           19 // 8
#define NINE            20 // 9

const long long codigos[NUM_OF_BUTTOMS]{
  0xBA45FF00,0xB946FF00,0xB847FF00,0xBB44FF00,
  0xBF40FF00,0xBC43FF00,0xF807FF00,0xEA15FF00,
  0xF609FF00,0xE916FF00,0xE619FF00,0xF20DFF00,
  0xF30CFF00,0xE718FF00,0xA15EFF00,0xF708FF00,
  0xE31CFF00,0xA55AFF00,0xBD42FF00,0xAD52FF00,0xB54AFF00
};
//-------------------------------------------------------------------
//Estructuras
typedef struct DetectedPoint {
  int nMatrix;
  int col;
  int row;
}detectedPoint;

//-------------------------------------------------------------------
//Frames:
//Frames del punto central de la matriz de la derecha
const byte frameDef[]={0x00,0x00,0x00,0x00,0x00,0x00,0x80,0x80};
//Frames del punto central de la matriz de la izquierda
const byte frameDef2[]={0x00,0x00,0x00,0x00,0x00,0x00,0x01,0x01};

//Frames de ambas matrices del modo automatico
const byte framesAuto[N_FRAMES_AUTO][A_ROWS]={
  {0x00,0x00,0x00,0x00,0x00,0x00,0x01,0xff},{0x00,0x00,0x00,0x00,0x00,0x00,0xf1,0x0f},
  {0x00,0x00,0x00,0x00,0x00,0xc0,0x39,0x07},{0x00,0x00,0x00,0x00,0xc0,0x30,0x0d,0x03},
  {0x00,0x00,0x00,0x80,0x60,0x18,0x05,0x03},{0x00,0x00,0x80,0x60,0x10,0x0c,0x03,0x01},
  {0x00,0x80,0x40,0x20,0x18,0x04,0x03,0x01},{0x80,0x40,0x20,0x10,0x08,0x04,0x03,0x01},
  {0x40,0x20,0x10,0x08,0x08,0x04,0x03,0x01},{0x20,0x10,0x08,0x08,0x04,0x02,0x01,0x01},
  {0x10,0x08,0x08,0x04,0x02,0x02,0x01,0x01},{0x08,0x08,0x04,0x04,0x02,0x02,0x01,0x01},
  {0x04,0x04,0x02,0x02,0x02,0x02,0x01,0x01},{0x02,0x02,0x02,0x02,0x01,0x01,0x01,0x01},
  {0x01,0x01,0x01,0x01,0x01,0x01,0x01,0x01},{0x80,0x80,0x80,0x80,0x80,0x80,0x80,0x80},
  {0x40,0x40,0x40,0x40,0x80,0x80,0x80,0x80},{0x20,0x20,0x40,0x40,0x40,0x40,0x80,0x80},
  {0x10,0x10,0x20,0x20,0x40,0x40,0x80,0x80},{0x08,0x10,0x10,0x20,0x40,0x40,0x80,0x80},
  {0x04,0x08,0x10,0x10,0x20,0x20,0xc0,0x80},{0x02,0x04,0x08,0x10,0x10,0x20,0xc0,0x80},
  {0x01,0x02,0x04,0x08,0x10,0x20,0xc0,0x80},{0x00,0x01,0x02,0x04,0x18,0x20,0xc0,0x80},
  {0x00,0x00,0x01,0x06,0x08,0x30,0xc0,0x80},{0x00,0x00,0x00,0x01,0x06,0x18,0xe0,0x80},
  {0x00,0x00,0x00,0x00,0x03,0x0c,0xb0,0xc0},{0x00,0x00,0x00,0x00,0x00,0x03,0x9c,0xe0},
  {0x00,0x00,0x00,0x00,0x00,0x00,0x8f,0xf0},{0x00,0x00,0x00,0x00,0x00,0x00,0x80,0xff}
};

//Frames de la matriz de la izquierda del modo manual
const byte framesManual1[N_FRAMES_MANUAL][A_ROWS]={
  {0x00,0x00,0x00,0x00,0x00,0x00,0x01,0x01},
  {0x00,0x00,0x00,0x00,0x00,0x01,0x03,0x03},
  {0x00,0x00,0x00,0x00,0x01,0x02,0x05,0x05},
  {0x00,0x00,0x00,0x01,0x02,0x04,0x09,0x09},
  {0x00,0x00,0x01,0x02,0x04,0x08,0x11,0x11},
  {0x00,0x01,0x02,0x08,0x08,0x10,0x21,0x21},
  {0x01,0x02,0x04,0x08,0x10,0x20,0x41,0x41},
  {0x02,0x04,0x08,0x10,0x20,0x40,0x81,0x81},
  {0x04,0x08,0x10,0x20,0x40,0x80,0x01,0x01},
  {0x08,0x10,0x20,0x40,0x80,0x00,0x01,0x01},
  {0x10,0x20,0x40,0x80,0x00,0x00,0x01,0x01},
  {0x20,0x40,0x80,0x00,0x00,0x00,0x01,0x01},
  {0x40,0x80,0x00,0x00,0x00,0x00,0x01,0x01},
  {0x80,0x00,0x00,0x00,0x00,0x00,0x01,0x01}
};

//Frames de la matriz de la derecha del modo manual
const byte framesManual2[N_FRAMES_MANUAL][A_ROWS]={
  {0x00,0x00,0x00,0x00,0x00,0x00,0x80,0x80},
  {0x00,0x00,0x00,0x00,0x00,0x80,0xc0,0xc0},
  {0x00,0x00,0x00,0x00,0x80,0x40,0xa0,0xa0},
  {0x00,0x00,0x00,0x80,0x40,0x20,0x90,0x90},
  {0x00,0x00,0x80,0x40,0x20,0x10,0x88,0x88},
  {0x00,0x80,0x40,0x10,0x10,0x08,0x84,0x84},
  {0x80,0x40,0x20,0x10,0x08,0x04,0x82,0x82},
  {0x40,0x20,0x10,0x08,0x04,0x02,0x81,0x81},
  {0x20,0x10,0x08,0x04,0x02,0x01,0x80,0x80},
  {0x10,0x08,0x04,0x02,0x01,0x00,0x80,0x80},
  {0x08,0x04,0x02,0x01,0x00,0x00,0x80,0x80},
  {0x04,0x02,0x01,0x00,0x00,0x00,0x80,0x80},
  {0x02,0x01,0x00,0x00,0x00,0x00,0x80,0x80},
  {0x01,0x00,0x00,0x00,0x00,0x00,0x80,0x80}
};

const byte framesParking1[N_FRAMES_PARKING][A_ROWS]={
  {0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x0f},
  {0x00,0x00,0x00,0x00,0x00,0x00,0x0f,0x0e},
  {0x00,0x00,0x00,0x00,0x00,0x0f,0x0e,0x0e},
  {0x00,0x00,0x00,0x00,0x0f,0x0e,0x0e,0x0e},
  {0x00,0x00,0x00,0x0f,0x0e,0x0e,0x0e,0x0e},
  {0x00,0x00,0x0f,0x0e,0x0e,0x0e,0x0e,0x0e},
  {0x00,0x0f,0x0e,0x0e,0x0e,0x0e,0x0e,0x0e},
  {0x0f,0x0e,0x0e,0x0e,0x0e,0x0e,0x0e,0x0e}
};

//Frames de la matriz de la derecha del modo parking
const byte framesParking2[N_FRAMES_PARKING][A_ROWS]={
  {0x00,0x00,0x00,0x00,0x00,0x00,0x00,0xf0},
  {0x00,0x00,0x00,0x00,0x00,0x00,0xf0,0x70},
  {0x00,0x00,0x00,0x00,0x00,0xf0,0x70,0x70},
  {0x00,0x00,0x00,0x00,0xf0,0x70,0x70,0x70},
  {0x00,0x00,0x00,0xf0,0x70,0x70,0x70,0x70},
  {0x00,0x00,0xf0,0x70,0x70,0x70,0x70,0x70},
  {0x00,0xf0,0x70,0x70,0x70,0x70,0x70,0x70},
  {0xf0,0x70,0x70,0x70,0x70,0x70,0x70,0x70}
};

//-------------------------------------------------------------------
//Variables:
float gradoActual=180.0;
detectedPoint *points;
int lastIndex=0;
int modoActual = MODO_AUTO;
float gr= PI/180;
int modificador_velocidad=NUM_VELOCIDADES_AUTO/2;
int grados_giro=NUM_GRADOS_GIRO/2;
int tam=20;

//-------------------------------------------------------------------
//Objetos:
MD_MAX72XX mx = MD_MAX72XX(HARDWARE_TYPE, DIN, CLK, CS, NUM_OF_MATRIX);
Servo ms;
LiquidCrystal lcd1(RS,E,D4,D5,D6,D7);


//-------------------------------------------------------------------
//Setup:
void setup() {
    Serial.begin(9600);
    pinMode(ECHO,INPUT);
    pinMode(TRIGGER,OUTPUT);
    ms.attach(SERVO_PIN);
    ms.write(90);
    mx.begin(); 
    lcd1.begin(16,2);
    lcd1.setCursor(0,1);
    testInicial();
    lcd1.setCursor(0,0);
    lcd1.print("Info:");
    mx.control(MD_MAX72XX::INTENSITY, 5);
    IrReceiver.begin(IR, DISABLE_LED_FEEDBACK);
}

//-------------------------------------------------------------------
//Loop:
void loop() {
  lastIndex=0;
  switch(modoActual) {
    case MODO_AUTO:
      gradoActual=180.0;
      modificador_velocidad=1;
      modoAuto();  
      break;
    case MODO_MANUAL:
      modoManual();
      grados_giro=6;
      break;
    case MODO_PARKING:
      gradoActual=90.0;
      modoParking();
      break; 
  }
}

//-------------------------------------------------------------------
//Funciones:

/*Función que lleva el modo automatico del programa*/
void modoAuto(){
  printInfo("AUTO",NULL);
  while(1){
    points=(detectedPoint*)malloc(sizeof(detectedPoint)*30); 
    lastIndex=0; 
    delay(DELAY_ANIMATION);
    mx.clear();  
    for(int i=0;i<N_FRAMES_AUTO;i++){
      ms.write(gradoActual);
      double valor=ultraSonido();
      delay(DELAY_ANIMATION*velocidades_auto[modificador_velocidad]);
      int id=isPressed();
      if(id==ON_OFF||id==VOL_POS||id==FUNC_STOP) {
        modoActual=id;
        return;
      }
      else if(id==ARROW_UP){
        if(modificador_velocidad<NUM_VELOCIDADES_AUTO)printInfo("Vel = ",modificador_velocidad++);
        else printError("MAX VEL.");
      }else if(id==ARROW_DOWN){
        if(modificador_velocidad>0)printInfo("Vel = ",modificador_velocidad--);
        else printError("MIN VEL.");
      }else if(id>=ONE&&id<=NINE){
        mx.control(MD_MAX72XX::INTENSITY, id-11);
        printInfo("Brillo = ",id-11);
      }else if(id==PLAY_PAUSE){
        printInfo("Pausa",NULL);
        while(1){
          id=isPressed();
          if(id==PLAY_PAUSE) break;
          else if(id==ARROW_UP){
            if(tam<D_MAX) printInfo("Tam = ",++tam);
            else printError("TAM MAX");
          }else if(id==ARROW_DOWN){
            if(tam>D_MIN) printInfo("Tam = ",--tam);
            else printError("TAM MIN");
          } 
        }
        printInfo("Play",NULL); 
      }
      if(i<N_FRAMES_AUTO/2) {
        drawRows(framesAuto[i],frameDef);
        addDetectedPoint(0,valor);
      }else {
        addDetectedPoint(1,valor);
        drawRows(frameDef2,framesAuto[i]); 
      }
      drawDetectedPoints(false);
      gradoActual-=6;
    }  
    gradoActual=180.0;
    ms.write(gradoActual);
    free(points);
  }
}

/*Función que lleva el modo manual del programa*/
void modoManual(){
  printInfo("MANUAL",NULL);
  while(1){
    //Poner gradoActual en 180 antes y nframe a 0
    //Limpiamos la pantalla antes de empezar de nuevo la animacion
    points=(detectedPoint*)malloc(sizeof(detectedPoint)*30); 
    lastIndex=0; 
    mx.clear();  
    for(int i=0;i<N_FRAMES_MANUAL;i++){
      //Dibujamos la animación siempre (dibujarla antes que los puntos marcados para no taparlos)
      drawRows(framesManual1[i],framesManual2[i]);
      ms.write(gradoActual);
      double valor=ultraSonido();
      delay(DELAY_ANIMATION);
      //Dibujamos los puntos marcados respecto a los frames del modo auto (es la mejor referencia para ello)
      if(gradoActual>=90) addDetectedPoint(0, valor);
      else addDetectedPoint(1, valor);
      drawDetectedPoints(false);
      int id=isPressed();
      if(id==ON_OFF||id==VOL_POS||id==FUNC_STOP) {
        modoActual=id;
        return;
      }else if(id==ARROW_UP){
        Serial.println("UP");
        if(grados_giro<NUM_GRADOS_GIRO)printInfo("Giro = ",grados_manual[++grados_giro]);
        else printError("MAX GIRO");
      }else if(id==ARROW_DOWN){ 
        Serial.println("DOWN");
        if(grados_giro>0)printInfo("Giro = ",grados_manual[--grados_giro]);
        else printError("MIN GIRO");
      }else if(id==ARROW_RIGHT){
        if(gradoActual>grados_manual[grados_giro]){
          gradoActual-=grados_manual[grados_giro];
          printInfo("Der = ",grados_manual[grados_giro]);
        }else printError("MAX DER");
      }else if(id==ARROW_LEFT){
        if(gradoActual<180-grados_manual[grados_giro]){
          gradoActual+=grados_manual[grados_giro];
          printInfo("Izq = ",grados_manual[grados_giro]);
        }else printError("MAX IZQ");
      }else if(id>=ONE&&id<=NINE){
        mx.control(MD_MAX72XX::INTENSITY, id-11);
        printInfo("Brillo = ",id-11);
      }else if(id==PLAY_PAUSE){
        printInfo("Pausa",NULL);
        while(1){
          id=isPressed();
          if(id==PLAY_PAUSE) break;
          else if(id==ARROW_UP){
            if(tam<D_MAX) printInfo("Tam = ",++tam);
            else printError("TAM MAX");
          }else if(id==ARROW_DOWN){
            if(tam>D_MIN) printInfo("Tam = ",--tam);
            else printError("TAM MIN");
          } 
        }
        printInfo("Play",NULL); 
      }
    }
    free(points);
  }
}

/*Función que lleva el modo de aparcamiento del programa*/
void modoParking(){
  printInfo("PARKING",NULL);
  while(1){
    points=(detectedPoint*)malloc(sizeof(detectedPoint)*30); 
    lastIndex=0; 
    mx.clear(); 
    ms.write(GRADOS_PARKING);
    for(int i=0;i<N_FRAMES_PARKING;i++){
      double valor=ultraSonido();
      addDetectedPoint(i,valor);
      addDetectedPoint(i,valor);
      drawAnimationParking(i,valor);
      int id=isPressed();
      if(id==ON_OFF||id==VOL_POS||id==FUNC_STOP) {
        modoActual=id;
        return;
      }else if(id>=ONE&&id<=NINE){
        mx.control(MD_MAX72XX::INTENSITY, id-11);
        printInfo("Brillo = ",id-11);
      }else if(id==PLAY_PAUSE){
        printInfo("Pausa",NULL);
        while(1){
          id=isPressed();
          if(id==PLAY_PAUSE) break;
          else if(id==ARROW_UP){
            if(tam<D_MAX) printInfo("Tam = ",++tam);
            else printError("TAM MAX");
          }else if(id==ARROW_DOWN){
            if(tam>D_MIN) printInfo("Tam = ",--tam);
            else printError("TAM MIN");
          } 
        }
        printInfo("Play",NULL); 
      }
    } 
    free(points);
  }
}

/*Función que ejecuta el ultrasonido y devuelve la distancia */
double ultraSonido(){
  digitalWrite(TRIGGER, LOW); 
  delayMicroseconds(5);
  digitalWrite(TRIGGER, HIGH); 
  delayMicroseconds(10); 
  digitalWrite(TRIGGER, LOW);
  return pulseIn(ECHO,HIGH)*0.017;
}

/*Función que añade un punto detectado a la lista de puntos que vamos a marcar como detectados si procede*/
void addDetectedPoint(int numMatrix,double distancia){
  //Solo añadimos el punto si esta dentro de los margenes
  if(distancia <= tam && tam>=D_MIN) {
    detectedPoint point;
    point.nMatrix = numMatrix;
    int disAprox=map((long)distancia,D_MIN,tam,0,8);
    if(numMatrix==0){
      point.col=abs((int)disAprox*cos((180-gradoActual)*gr));
      point.row=8-abs((int)disAprox*sin((180-gradoActual)*gr));
    }else{
      point.col=16-abs((int)disAprox*cos(gradoActual*gr));  
      point.row=8-abs((int)disAprox*sin(gradoActual*gr));
    }
    lcd1.setCursor(0,1);
    lcd1.print("G:");
    lcd1.print((int)gradoActual);
    lcd1.print(" ");
    lcd1.setCursor(6,1);    
    lcd1.print(" | L:");
    lcd1.print((int)distancia);
    lcd1.print("cm   ");
    if(!isPoints(point))points[lastIndex++]=point;
  }
}

/*Funcion que devuelve true o false si el punto ya esta en la lista*/
bool isPoints(DetectedPoint p){
  for(int i = 0; i < lastIndex; i++){
    detectedPoint point = points[i];
    if(p.row==point.row&&p.col==point.row)return true;
  }  
  return false;
}

/*Función que dibuja los puntos marcados como detectados*/
void drawDetectedPoints(bool isParking){
  for(int i = 0; i < lastIndex; i++){
    detectedPoint point = points[i];
    mx.setPoint(point.row,point.col,true);
    if(isParking)mx.setPoint(point.row,15,true);
  }
}

/*Función que dibuja en las columnas de leds los frames*/
void drawRows(const byte fig[],const byte fig2[]){
  for( int i = 0; i < 8; i++ ){
    mx.setRow(0, i, fig[i]);
    mx.setRow(1, i, fig2[i]);
	}
}

/*Función que se encarga de comprobar si una tecla del mando ha sido pulsada*/
int isPressed(){
  if (IrReceiver.decode()) {   
    for(int i=0;i<NUM_OF_BUTTOMS;i++){ 
      if(IrReceiver.decodedIRData.decodedRawData==codigos[i]){
        Serial.print("Codigo: ");
        Serial.print(IrReceiver.decodedIRData.decodedRawData, HEX);
        Serial.print(" con numero ");        
        Serial.println(i);
        IrReceiver.resume(); 
        return i;
      }
    } 
    IrReceiver.resume();          
  }
  return -1;
}

/*Función para crear el parpadeo de los leds sobrantes de la animación del parking en función de la cercanía del obstaculo*/
void drawAnimationParking(int nFrame,double distancia){
    drawRows(framesParking1[nFrame],framesParking2[nFrame]);
    drawDetectedPoints(true);
    int parpadeos = PARPADEOS_POR_FRAME;
    for(int i = N_RANGOS_PARPADEO - 1; i > 0; i--) if(distancia < D_MAX*i/N_RANGOS_PARPADEO) parpadeos *= 2;
    int d = DELAY_ANIMATION/(2*parpadeos);
    for(int i = 0; i < parpadeos; i++){
      drawAnimationPoints(true);
      delay(d);
      drawAnimationPoints(false);
      delay(d);
    }
}

/*Función para pintar/despintar los leds de parpadeo del modo parking*/
void drawAnimationPoints(bool isPintar){
  for(int row = 0; row < A_ROWS; row++){
    for(int col = 0; col < 4; col++) {
      if(isPintar){
        mx.setColumn(0, col + 4, 0xff);
        mx.setColumn(1, col , 0xff);
      }
      else{
        mx.setColumn(0, col + 4, 0x00);
        mx.setColumn(1, col , 0x00);
      }
    }
  }
}

void testInicial(){
  	mx.control(MD_MAX72XX::TEST, true);
    lcd1.setCursor(0,0);
  	lcd1.print("Prueba MX");
  	for(int i=0;i<=100;i++){
      lcd1.setCursor(0,1);
      lcd1.print("Test: ");
      lcd1.print(i);
      lcd1.print("% :)");
      delay(50);
  	}
    lcd1.clear();
  	mx.control(MD_MAX72XX::TEST, false);
}	

void printInfo(char* msg, int var){
  lcd1.setCursor(0,0);
  lcd1.print("Info: ");
  lcd1.print(msg);
  if(var!=NULL) lcd1.print(var);
  lcd1.print("      ");
}

void printError(char* msg){
  lcd1.setCursor(0,0);
  lcd1.print("ERROR: ");  
  lcd1.print(msg);
  lcd1.print("       ");
}