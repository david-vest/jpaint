package model;

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
    Point[] points = Point.normalizePoints(start, end);
    this.start = points[0];
    this.end = points[1];
    this.width = getWidth();
    this.height = getHeight();
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
  public boolean doesCollide(IBoundingBox box) {
    return this.getStart().getX() < box.getEnd().getX() && this.getEnd().getX() > box.getStart().getX()
        && this.getStart().getY() < box.getEnd().getY() && this.getEnd().getY() > box.getStart().getY();
  }
}
