package model;

/**
 * Point holds the x and y points on the PaintCanvas. This class also holds a static method to return
 * an array of two Points for normalization.
 */

public class Point {

  private int x;
  private int y;

  public Point(int x, int y){
    this.x = x;
    this.y = y;
  }

  public int getX() { return x; }

  public int getY() { return y; }

  public void setX(int x) { this.x = x; }

  public void setY(int y) { this.y = y; }

  public Point copy() {
    return new Point(x, y);
  }

  @Override
  public String toString(){
    return "Point(" + x + "," + y + ")";
  }
}
