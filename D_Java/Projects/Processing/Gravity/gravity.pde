float x = 400;   
float y = 0; 
float speed = 5;   
float gravity = 0.5;  

void setup() {
  size(800, 800);
}

void draw() {
  background(#030303);
  fill(255,0,0);
  stroke(#030303);
  ellipseMode(CENTER);
  ellipse(x, y, 100, 100);
  y = y + speed;
  speed = speed + gravity;
  if (y > height) {
    speed = speed * -0.95;
    y = height;
  }
}