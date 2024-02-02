int filas = 20;
int columnas = 20;
int bs = 20;
ArrayList<Integer> posX = new ArrayList<Integer>();
ArrayList<Integer> posY = new ArrayList<Integer>();

int dir=3;
int[] dx = {0, 0, -1, 1};
int[] dy = {-1, 1, 0, 0};

int appleX;
int appleY;

boolean gameOver=true;
boolean modeEpilepsia=false;
void setup() {
  size(400, 400);
  frameRate(10);
  //IniSnake
  posX.add(10);
  posY.add(10);
  appleX = (int) random(0, 20);
  appleY = (int) random(0, 20);
}
void draw() {
  if (modeEpilepsia) {
    background((int) random(0, 255), (int) random(0, 255), (int) random(0, 255));
  } else {
    background(255);//Fondo Blanco
  }
  if (gameOver) {
    fill(0);
    textSize(20);
    text("Press space to continue.", 100, height/2);
  } else {
    //Grid
    fill(0);
    for (int i = 0; i < filas; i++) {
      line(0, i*bs, width, i*bs);
    }
    for (int j = 0; j < columnas; j++) {
      line(j*bs, 0, j*bs, height);
    }


    //moveSnake
    posX.add(0, posX.get(0)+dx[dir]);
    posY.add(0, posY.get(0)+dy[dir]);
    posX.remove(posX.size()-1);
    posY.remove(posY.size()-1);
    //detectBorder
    if ( ( posX.get(0)<0 )||( posX.get(0)>filas-1 )||( posY.get(0)<0 )||( posY.get(0)>columnas-1 ) ) {
      gameOver=true;
    }

    //eat
    if ((posX.get(0)==appleX)&&(posY.get(0)==appleY)) {
      appleX = (int) random(0, 20);
      appleY = (int) random(0, 20);
      posX.add(posX.get(posX.size()-1));
      posY.add(posY.get(posY.size()-1));
    }
    //drawApple
    if (modeEpilepsia) {
      fill((int) random(0, 255), (int) random(0, 255), (int) random(0, 255));
    } else {
      fill(255, 0, 0);
    }
    rect(appleX*bs, appleY*bs, bs, bs);
    //drawSnake
    if (modeEpilepsia) {
      fill((int) random(0, 255), (int) random(0, 255), (int) random(0, 255));
    } else {
      fill(0, 0, 255);
    }
    for (int i = 0; i < posX.size(); i++) {
      rect(posX.get(i)*bs, posY.get(i)*bs, bs, bs);
    }
  }
}

void keyPressed() {
  if (key=='h')modeEpilepsia=!modeEpilepsia;
  if (key=='w')dir=0;
  if (key=='s')dir=1;
  if (key=='a')dir=2;
  if (key=='d')dir=3;
  if (key==' ') {
    gameOver=false;
    posX.clear();
    posY.clear();
    posX.add(10);
    posY.add(10);
    appleX = (int) random(0, 20);
    appleY = (int) random(0, 20);
  }
}