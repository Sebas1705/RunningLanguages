
public abstract class Entity {

    private int x,y;
    protected color backgroundColor = color(255);

    public Entity(int x,int y){
        int rectX = floor(x/CELL_WIDTH);
        int rectY = floor(y/CELL_HEIGHT);
        this.x=rectX;
        this.y=rectY;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public color getBackgroundColor() { return backgroundColor; }

    protected void fallDown(){ this.y+=1; }
    protected void fallLeft(){ this.x-=1; }
    protected void fallRight(){ this.x+=1; }
    protected void goUp(){ this.y-=1; }

    public abstract void physics(World context);

    @Override
    public boolean equals(Object o){
        return (o instanceof Entity)&&((Entity)o).getX()==this.x&&((Entity)o).getY()==this.y;
    }

}


public class Sand extends Entity {

    public Sand(int x,int y){
        super(x,y);
        this.backgroundColor = color(random(206,252),random(181,218),random(27,38));
    }

    @Override
    public void physics(World context) {
        Entity downEntity=context.getEntity(this.getX(),this.getY()+1);
        if(downEntity==null) this.fallDown();
        else if(downEntity instanceof Water){
            this.fallDown();
            downEntity.goUp();
        }
        else if(context.getEntity(this.getX()+1,this.getY()+1)==null) this.fallRight();
        else if(context.getEntity(this.getX()-1,this.getY()+1)==null) this.fallLeft();       
    }

}

public class Water extends Entity {

    private static final int dispersionRate = 5;

    public Water(int x,int y){
        super(x,y);
        this.backgroundColor = color(random(45,60),random(50,110),random(182,252));
    }

    @Override
    public void physics(World context) {
        if(context.getEntity(this.getX(),this.getY()+1)==null) this.fallDown();
        else if(random(0,100)>50){
            if(context.getEntity(this.getX()+1,this.getY())==null) this.fallRight();
            else if(context.getEntity(this.getX()-1,this.getY())==null) this.fallLeft();
        }else{
            if(context.getEntity(this.getX()-1,this.getY())==null) this.fallLeft();
            else if(context.getEntity(this.getX()+1,this.getY())==null) this.fallRight();
        }
    }

}

public class Rock extends Entity {

    public Rock(int x,int y){
        super(x,y);
        this.backgroundColor = color(random(100,200));
    }

    @Override
    public void physics(World context) {

    }

}

