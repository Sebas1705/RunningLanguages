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
