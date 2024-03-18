#include <Servo.h>

Servo servo;

void setup() {
  servo.attach(9);
  servo.write(0);
  Serial.begin(9600);
}

void loop() {
  delay(300);
  servo.write(0);
  delay(300);
  for(int i=0;i<=180;i++){
    Serial.print("Servo Pos:");
    Serial.println(i);
    servo.write(i);
    delay(15);
  }
  // for(int i=180;i>=0;i--){
  //   Serial.print("Servo Pos:");
  //   Serial.println(i);
  //   servo.write(i);
  //   delay(15);
  // }
}
