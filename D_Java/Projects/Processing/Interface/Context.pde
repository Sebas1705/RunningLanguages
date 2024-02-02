public class Point {
  private int x, y;
  
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  public Point() {
    this(0, 0);
  }
  
  public int getX() { return x; }
  public int getY() { return y; }
}

public class Dimension {
  
  private int w, h;
  
  public Dimension(int w, int h) {
    this.w = w;
    this.h = h;
  }
    
  public Dimension() {
    w = 0;
    h = 0;
  }
  
  public int getW() { return w; }
  public int getH() { return h; }
}