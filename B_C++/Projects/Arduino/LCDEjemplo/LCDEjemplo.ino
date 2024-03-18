#include <LiquidCrystal.h>
LiquidCrystal lcd(7, 8, 9, 10, 11 , 12);

void setup() {
  // Inicializar el LCD con el número de  columnas y filas del LCD
  lcd.begin(16,2);
  // Escribimos el Mensaje en el LCD
  lcd.print("Hola Mundo");
}

void loop() {
  // Ubicamos el cursor en la primera posición(columna:0) de la segunda línea(fila:1)
  lcd.setCursor(0, 2);
   // Escribimos el número de segundos trascurridos
  lcd.print(millis()/1000);
  lcd.print(" Segundos");
  delay(100);
}