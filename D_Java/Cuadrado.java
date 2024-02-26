public class Cuadrado extends Forma{
    
    public Cuadrado(int x,int y,int l){
        super(x,y,l,l);
    }
    public Cuadrado(){
        this(0,0,1);
    }

    @Override
    public int perimetro(){
        return width*2+height*2;
    }

    @Override
    public int area(){
        return width*height;
    }
}
