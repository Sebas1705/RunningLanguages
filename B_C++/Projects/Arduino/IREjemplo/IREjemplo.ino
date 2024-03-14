#include <IRremote.h> 
#include <Servo.h>    

#define IR_BUTTON_1 12
#define IR_BUTTON_2 24
#define IR_BUTTON_3 94
#define IR_BUTTON_PLAY_PAUSE 64

int RECV_PIN =7;
int SERVO_PIN =8;     
      
Servo ms;  

void setup(){     
  Serial.begin(9600);    
  IrReceiver.begin(RECV_PIN);     
  ms.attach(SERVO_PIN);
  ms.write(90); 
} 

void loop(){
  if (IrReceiver.decode()){     
    IrReceiver.resume();
    int command = IrReceiver.decodedIRData.command;
    switch (command) {
      case IR_BUTTON_1: {
        Serial.println("Pressed on button 1");
        break;
      }
      case IR_BUTTON_2: {
        Serial.println("Pressed on button 2");
        break;
      }
      case IR_BUTTON_3: {
        Serial.println("Pressed on button 3");
        break;
      }
      case IR_BUTTON_PLAY_PAUSE: {
        // Serial.println("Pressed on button play/pause");
        break;
      }
      default: {
        // Serial.println("Button not recognized");
      }
    }
  }
}      
