
//Abstract class => semi-plantilla de clases
public abstract class Forma {
    
    private int x,y;
    protected int width,height;

    public Forma(int x,int y,int width,int height){
        this.height = height;
        this.x = x;
        this.y = y;
        this.width = width;
    }
    public Forma(){
        this(0,0,1,1);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public abstract int perimetro();

    public abstract int area();
}
