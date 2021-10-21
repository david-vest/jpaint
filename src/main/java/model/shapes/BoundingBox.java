package model.shapes;

import model.Point;
import model.interfaces.IBoundingBox;

/**
 * @see model.interfaces.IBoundingBox
 */

public class BoundingBox implements IBoundingBox {
  private Point start;
  private Point end;
  private int width;
  private int height;

  public BoundingBox(Point start, Point end) {
    this.start = start;
    this.end = end;
    this.width = getWidth();
    this.height = getHeight();
  }

  @Override
  public void normalize(){
    int x1 = Math.min(start.getX(), end.getX());
    int x2 = Math.max(start.getX(), end.getX());
    int y1 = Math.min(start.getY(), end.getY());
    int y2 = Math.max(start.getY(), end.getY());

    Point[] normalizedPoints = new Point[2];

    start = new Point(x1, y1);
    end = new Point(x2, y2);
  }

  @Override
  public Point getStart() {
    return start;
  }

  @Override
  public Point getEnd() {
    return end;
  }

  @Override
  public void setStart(Point s) {
    this.start = s;
  }

  @Override
  public void setEnd(Point e) {
    this.end = e;
  }

  @Override
  public int getWidth() {
    return end.getX() - start.getX();
  }

  @Override
  public int getHeight() {
    return end.getY() - start.getY();
  }

  @Override
  public void move(int x, int y) {
    System.out.println("Starting: " + start.toString() + " End: " + end.toString());
    start = new Point(start.getX() + x, start.getY() + y);
    end = new Point(end.getX() + x, end.getY() + y);
    System.out.println("Starting: " + start.toString() + " End: " + end.toString());
  }

  @Override
  public boolean doesCollide(IBoundingBox box) {
    return this.getStart().getX() < box.getEnd().getX() && this.getEnd().getX() > box.getStart().getX()
        && this.getStart().getY() < box.getEnd().getY() && this.getEnd().getY() > box.getStart().getY();
  }
}