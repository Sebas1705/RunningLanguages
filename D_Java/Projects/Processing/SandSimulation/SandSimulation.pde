
final int WINDOW_WIDTH = 800;
final int WINDOW_HEIGHT = 600;
final int CELL_WIDTH = 50;
final int CELL_HEIGHT = 50;

public enum Type { SAND, WATER, ROCK;}

public class Entity {

    private int x,y;
    private Type type;

    public Entity(int x,int y,Type type){
        this.x=x;
        this.y=y;
        this.type=type;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public Type getType() { return type; }

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

    public void addEntity(int x,int y,Type type){
        int rectX = floor(x/CELL_WIDTH)*CELL_WIDTH;
        int rectY = floor(y/CELL_HEIGHT)*CELL_HEIGHT;
        if(isNotEntity(rectX,rectY))
            entities.add(new Entity(rectX,rectY,type));
    }

    private boolean isNotEntity(int x,int y){
        for(Entity entity : entities) 
            if(entity.getX()==x&&entity.getY()==y)
                return false;
        return true;
    }

    private void drawWorld(){
        stroke(line);
        strokeWeight(2);
        for(int i=0;i<=tamX;i++) line(CELL_WIDTH*i,0,CELL_WIDTH*i,height);
        for(int j=0;j<=tamY;j++) line(0,CELL_HEIGHT*j,width,CELL_HEIGHT*j);
    }
    private void drawEntities(){
        for(Entity entity: entities){
            noStroke();
            switch(entity.getType()){
                case SAND:
                fill(202, 197, 0);
                break;
                case WATER:
                break;
                case ROCK:
                break;
                default:
                break;
            }
            rect(entity.getX(),entity.getY(),CELL_WIDTH,CELL_HEIGHT);
        }
    }

    private void updateEntities(){
        boolean[][] collisions = new boolean[tamX][tamY];
        for(Entity entity: entities){
            switch (entity.getType()) {
                case SAND:
                break;
                case WATER:
                break;
                case ROCK:
                break;
                default:
                break;
            }
        }
    }

    public void display(){
        updateEntities();
        drawEntities();
        drawWorld();
    }

}

World world;

void settings() {
    size(WINDOW_WIDTH, WINDOW_HEIGHT);
}

void setup() {
    world=new World(width/CELL_WIDTH,height/CELL_HEIGHT,color(255));
}

void draw() {
    background(0);
    world.display();
}

void mousePressed() {
    world.addEntity(mouseX,mouseY,Type.SAND);
}
