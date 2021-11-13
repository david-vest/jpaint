package model.shapes;

import model.Point;
import model.interfaces.IBoundingBox;

/**
 * @see model.interfaces.IBoundingBox
 */

public class BoundingBox implements IBoundingBox {
  private Point start;
  private Point end;

  public BoundingBox(Point start, Point end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public void normalize(){
    int x1 = Math.min(start.getX(), end.getX());
    int x2 = Math.max(start.getX(), end.getX());
    int y1 = Math.min(start.getY(), end.getY());
    int y2 = Math.max(start.getY(), end.getY());

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
  public void move(int x, int y) {
    start = new Point(start.getX() + x, start.getY() + y);
    end = new Point(end.getX() + x, end.getY() + y);
  }

  @Override
  public boolean doesCollide(IBoundingBox box) {
    return this.getStart().getX() < box.getEnd().getX() && this.getEnd().getX() > box.getStart().getX()
        && this.getStart().getY() < box.getEnd().getY() && this.getEnd().getY() > box.getStart().getY();
  }

  @Override
  public IBoundingBox copy() {
    return new BoundingBox(start.copy(), end.copy());
  }
}
