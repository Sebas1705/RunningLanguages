
final int WINDOW_WIDTH = 800;
final int WINDOW_HEIGHT = 600;
final int CELL_WIDTH = 50;
final int CELL_HEIGHT = 50;

public class Entity {

}

public class World {

    private Color[][] colors;    

    public World(int tamX,int tamY,Color background) {
        this.colors=new Color[tamX][tamY];
        for(int i=0;i<getTamX();i++)
            for(int j=0;j<getTamY();j++)
                colors = background;
    }

    public int getTamX() {return colors.length;}
    public int getTamY() {return colors[0].length;}
    public void setColor(int x,int y,Color colorS) {this.colors[x][y]=colorS;}

}

public class Sandbox {
    
    private World context;
    private ArrayList<Entity> entities;

    public Sandbox(){
        context =
    }

}


void settings() {
    size(WINDOW_WIDTH, WINDOW_HEIGHT);
}

void setup() {
    
}

void draw() {
    
}
