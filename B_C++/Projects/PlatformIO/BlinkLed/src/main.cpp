#include <Arduino.h>
#include <BluetoothSerial.h>

#if !defined(CONFIG_BT_ENABLED) || !defined(CONFIG_BLUEDROID_ENABLED)
#error Bluetooth is not enabled! Please run `make menuconfig` to and enable it
#endif

#if !defined(CONFIG_BT_SPP_ENABLED)
#error Serial Bluetooth not available or not enabled. It is only available for the ESP32 chip.
#endif

#define LED 2
BluetoothSerial serial;
TaskHandle_t taskHandle;
const char * device_name = "ESP32-BT-MINIBAR";

void loopSecondCore(void *pvParameters);
void printMsg(const char *msg);

void setup() {
  Serial.begin(115200);
  serial.begin(device_name);
  pinMode(LED,OUTPUT);
  xTaskCreatePinnedToCore(loopSecondCore,"SecondaryCore",1000,NULL,1,&taskHandle,0);
}

void loop() {
  if(serial.available()) {
    Serial.println("Command: "+serial.readString());
  }
  delay(1000);
}

void loopSecondCore(void *pvParameters){
  while(true) {
    if(digitalRead(LED)==HIGH){
      printMsg("High");
    }
    delay(1000);
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