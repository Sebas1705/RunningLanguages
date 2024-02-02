float theta1 = 0;
float theta2 = 0;

void setup() {
  size(200, 200, P3D);
}
void draw() {
  background(255);
  stroke(0);
  fill(255);
  rectMode(CENTER);
  pushMatrix(); 
  translate(50, 50); 
  rotateZ(theta1);
  rect(0, 0, 60, 60); 
  popMatrix(); 
  pushMatrix();
  translate(150, 150); 
  rotateY(theta2);
  rect(0, 0, 60, 60); 
  popMatrix();
  theta1 += 0.02;
  theta2 += 0.02;
}