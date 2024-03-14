const int echo = 13;
const int tigger = 12;

double dur,cm;

void setup() {
  Serial.begin(9600);
  pinMode(echo,INPUT);
  pinMode(tigger,OUTPUT);
}

void loop() {
  digitalWrite(tigger, LOW); 
  delayMicroseconds(5);
  digitalWrite(tigger, HIGH); 
  delayMicroseconds(10); 
  digitalWrite(tigger, LOW);
  dur = pulseIn(echo, HIGH);
  Serial.print("Dur: ");
  Serial.println(dur);
  cm = dur*0.017;
  Serial.print("Distancia al objeto: ");
  Serial.print(cm);
  Serial.println(" cm");
  delay(1000); 
}
