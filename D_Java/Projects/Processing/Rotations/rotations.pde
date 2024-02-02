float theta = 0.0;
void setup() {
  size(800, 800, P3D);
}

void draw() {
  background(255);
  stroke(0);
  fill(23,54,76);
  translate(width/2, height/2);
  rotateX(theta);
  rectMode(CENTER);
  rect(0,0,300,300);
  stroke(0);
  fill(0);
  translate(width/64, height/64);
  rotateY(theta);
  ellipseMode(CENTER);
  ellipse(0,0,250,250);
  theta += 0.05;
}