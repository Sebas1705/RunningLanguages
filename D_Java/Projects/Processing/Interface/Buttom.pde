public abstract class Component extends Component { 
  protected String text="";
  protected color c = color(0, 0, 0);
  public SComponent() {
    super();
  }
  public void setText(String text) {
    this.text=text;
  }
  public String getText() {
    return text;
  }
  public void setColor(color c) {
    this.c=c;
  }
  public color getColor() {
    return c;
  }
  public abstract void showCompt();
  public abstract int listen();
}


public class Buttom extends Component{
  
  //Atributes
  private String text="";
  
  //Constructors
  public Buttom(double x,double y,double w,double h){
    super(x,y,w,h);
  }
  public Buttom(){
    super();
  }
  
  //Publics
  @Override
  public void display(){
    
  }
  
  //Privates
  private boolean isPressed(){
    return isIn()&&mousePressed;
  }
  private boolean isIn(){
    return mouseX>=x&&mouseX<=x+w&&mouseY>=y&&mouseY<=y+h;
  }
}
