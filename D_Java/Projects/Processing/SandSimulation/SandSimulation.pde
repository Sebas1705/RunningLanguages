import java.util.Iterator;


final int WINDOW_WIDTH = 1600;
final int WINDOW_HEIGHT = 1000;
final int CELL_WIDTH = 10;
final int CELL_HEIGHT = 10;


public class Cursor{

    private int size;

    public void setSize(int size) { this.size=size; }
    public int getSize(){ return size; }

    public Cursor(){ this.size=0;noCursor(); }

    public void display(){
        int widthCursor=(size*2+1)*CELL_WIDTH,heightCursor=(size*2+1)*CELL_HEIGHT;
        noFill();
        strokeWeight(1);
        stroke(255,0,0);
        line(mouseX-widthCursor/2,mouseY,mouseX+widthCursor/2,mouseY);
        line(mouseX,mouseY-heightCursor/2,mouseX,mouseY+heightCursor/2);
        stroke(255);
        ellipse(mouseX,mouseY,widthCursor,heightCursor);
    }
}

public class World {

    private ArrayList<Entity> entities; 
    private color line;  
    private int tamX, tamY;

    public World(int tamX,int tamY,color line) {
        entities = new ArrayList<Entity>();
        this.line=line;
        this.tamX=tamX;
        this.tamY=tamY;
    }

    public int getTamX() {return tamX;}
    public int getTamY() {return tamY;}

    public void addEntity(Entity entity){
        if(getEntity(entity.getX(),entity.getY())==null)
            entities.add(entity);
    }

    public Entity getEntity(int x,int y){
        for(Entity entity : entities) 
            if(entity.getX()==x&&entity.getY()==y)
                return entity;
        return null;
    }

    private void setFloor(){
        for(int i=0;i<tamX;i++) addEntity(new Rock(i*CELL_WIDTH,(tamY-1)*CELL_HEIGHT));
    }

    private void drawWorld(){
        stroke(line);
        strokeWeight(0.01);
        for(int i=0;i<=tamX;i++) line(CELL_WIDTH*i,0,CELL_WIDTH*i,height);
        for(int j=0;j<=tamY;j++) line(0,CELL_HEIGHT*j,width,CELL_HEIGHT*j);
    }
    private void drawEntities(){
        noStroke();
        for(Entity entity: entities){
            fill(entity.getBackgroundColor());
            rect(entity.getX()*CELL_WIDTH,entity.getY()*CELL_HEIGHT,CELL_WIDTH,CELL_HEIGHT);
        }
    }

    private void updateEntities(){
        Iterator<Entity> it = entities.iterator();
        while(it.hasNext()){
            Entity entity = it.next();
            if(entity.getX()<0||entity.getX()>tamX||entity.getY()>tamY) it.remove();
            else entity.physics(this);
        }
    }

    public void display(){
        drawEntities();
        //drawWorld();
        updateEntities();
    }

    public void drawABox(int x,int y,int size,int mb){
        for(int i=-size;i<=size;i++){
            for(int j=-size;j<=size;j++){
                int nx=x+CELL_WIDTH*i,ny=y+CELL_HEIGHT*j;
                if(mb==LEFT) addEntity(new Water(nx,ny));
                else if(mb==RIGHT) addEntity(new Sand(nx,ny));
                else if(mb==CENTER) addEntity(new Rock(nx,ny));
            }
        }
    }

}

World world;
Cursor cursor;

void settings() {
    size(WINDOW_WIDTH, WINDOW_HEIGHT);
}

void setup() {
    world=new World(width/CELL_WIDTH,height/CELL_HEIGHT,color(255));
    cursor=new Cursor();
    world.setFloor();
    frameRate(60);
}

void draw() {
    background(0);
    world.display();
    cursor.display();
    if(mousePressed) world.drawABox(mouseX,mouseY,cursor.getSize(),mouseButton);
}

void keyPressed(){
    if(keyCode=='1') cursor.setSize(0);
    else if(keyCode=='2') cursor.setSize(1);
    else if(keyCode=='3') cursor.setSize(3);
}
