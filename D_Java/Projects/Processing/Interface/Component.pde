public abstract class Component{
  
  //Atributes:
  private double x,y;
  private double w,h;
  private boolean visible=false;
  private boolean stroked=true;
  private boolean opaqued=false;
  private boolean focusable=false;

  //Constructores:
  public Component(double x,double y,double w,double h){
    this.x=x;
    this.y=y;
    this.w=w;
    this.h=h;
  }
  public Component(){this(0,0,0,0);}
  
  //Setters:
  public void setX(double x){this.x=x;}
  public void setY(double y){this.y=y;}
  public void setW(double w){this.w=w;}
  public void setH(double h){this.h=h;}
  public void setLocation(double x,double y){
    this.x=x;
    this.y=y;
  }
  public void setSize(double w, double h){
    this.w=w;
    this.h=h;
  }

  public abstract void display();
}
