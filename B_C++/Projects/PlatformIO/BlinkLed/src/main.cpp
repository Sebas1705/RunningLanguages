#include <Arduino.h>

#define LED 2

TaskHandle_t taskHandle;

void loopSecondCore(void *pvParameters);

void setup() {
  Serial.begin(115200);
  pinMode(LED,OUTPUT);
  xTaskCreatePinnedToCore(loopSecondCore,"SecondaryCore",1000,NULL,1,&taskHandle,0);
}

void loop() {
  digitalWrite(LED,HIGH);
  delay(1000);
  digitalWrite(LED, LOW);
  delay(1000);
}

void loopSecondCore(void *pvParameters){
  while(true) {
    Serial.print(xPortGetCoreID());
    Serial.print(":");
    Serial.println((digitalRead(LED)==HIGH)?"HIGH":"LOW");
    delay(200);
  }
  vTaskDelay(10);
}
