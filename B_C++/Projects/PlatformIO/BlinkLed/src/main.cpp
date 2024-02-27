#include <Arduino.h>

#define LED 2

TaskHandle_t taskHandle;

void loopSecondCore(void *pvParameters);
void printMsg(const char *msg);

void setup() {
  Serial.begin(115200);
  pinMode(LED,OUTPUT);
  xTaskCreatePinnedToCore(loopSecondCore,"SecondaryCore",1000,NULL,1,&taskHandle,0);
}

void loop() {
  digitalWrite(LED,HIGH);
  printMsg("Set high");
  delay(1000);
  digitalWrite(LED, LOW);
  printMsg("Set low");
  delay(1000);
}

void loopSecondCore(void *pvParameters){
  while(true) {
    printMsg((digitalRead(LED)==HIGH)?"HIGH":"LOW");
    delay(400);
  }
  vTaskDelay(10);
}

void printMsg(const char *msg){
  Serial.print(xPortGetCoreID());
  Serial.print(".");
  Serial.print(xPortGetTickRateHz());
  Serial.print(":");
  Serial.println(msg);
}