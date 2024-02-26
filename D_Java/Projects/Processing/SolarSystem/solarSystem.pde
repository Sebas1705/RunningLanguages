import peasy.*;

float theta = 0;
Bodie sun;
PeasyCam cam;
PImage sunI;
PImage back;
String[] childsImages;      

void setup() {
  size(1400,800,P3D);
  childsImages = new String[]{
    "./src/earthmap1k.jpg",
    "./src/jupitermap.jpg",
    "./src/mars_1k_color.jpg",
    "./src/mercurymap.jpg",
    "./src/neptunemap.jpg",
    "./src/plutomap1k.jpg",
    "./src/saturnmap.jpg",
    "./src/uranusmap.jpg",
    "./src/venusmap.jpg"
  };   
  cam = new PeasyCam(this,500);
  sunI = loadImage("./src/sunmap.jpg");
  back = loadImage("./src/back.jpg");
  back.resize(1400,800);
  sun = new Bodie(100,0,0,sunI);
  sun.spawnChildren(9,1);
  lights();
}

void draw() {
  background(back);
  
  sun.show();
  sun.orbit();
  theta += 0.01;
}