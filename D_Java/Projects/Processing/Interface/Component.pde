
public abstract class Component extends Object {
  
  //Attributes:
  protected Point location;
  protected Dimension size;
  protected boolean visible;
  
  //Constructors:
  public Component(Point location,Dimension size){
    this.location=location;
    this.size=size;
    visible=true;
  }
  public Component(int x,int y,int w,int h) { this(new Point(x, y),new Dimension(w, h)); }
  public Component() { this(0, 0, 0, 0); }
  
  //Setters:
  public void setSize(Dimension d) { this.size=d; }
  public void setSize(int w, int h) { this.size=new Dimension(w, h); }
  public void setLocation(Point p) { this.location=p; }
  public void setLocation(int x, int y) { this.location=new Point(x, y); }
  public void setVisible(boolean visible) { this.isVisible=visible; }
  
  //Getters:
  public Component getComponent() { return this; }
  public Point getLocation() { return location; }
  public Dimension getSize() { return size; }
  public boolean isVisible() { return isVisible;}

  //Abstracts:
  public abstract void show();

}

public abstract class Container extends Component {
  
  //Attributes:
  protected ArrayList<Component> components;;
  protected color background;

  //Constructors:
  public Container(Dimension size) {
    super();
    this.size=size;
  }
  public Container() { this(new Dimension()); }

  public void add(Component c){
    if(!components.contains(c)) components.add(c);
  }
  public void remove(Component c){
    if(components.contains(c)) components.remove(c);
  }
  public ArrayList<Component> getComponents(){return components;}
  public color getBackground(){return background;}
  public void setBackground(color c){background=c;}
}

public interface ComponentListener {
  public void onSizeChanged();
  public void onLocationChanged();
  public void onVisibleChanged();
}

public interface ContainerListener extends ComponentListener {
  public void onAddComponent();
  public void onRemoveComponent();
  public void onBackgroundChanged();
}

public interface MouseListener {
  public void onMousePressed();
  public void onMouseRealeased();
  public void onMouseEntered();
  public void onMouseClicked();
}