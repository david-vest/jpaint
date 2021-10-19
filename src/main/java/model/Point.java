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

  public static Point[] normalizePoints(Point start, Point end) {
    int x1 = Math.min(start.getX(), end.getX());
    int x2 = Math.max(start.getX(), end.getX());
    int y1 = Math.min(start.getY(), end.getY());
    int y2 = Math.max(start.getY(), end.getY());

    Point[] normalizedPoints = new Point[2];

    normalizedPoints[0] = new Point(x1, y1);
    normalizedPoints[1] = new Point(x2, y2);

    return normalizedPoints;
  }
}
