package model;

import java.awt.Point;
import model.interfaces.IBoundingBox;
import model.interfaces.IShape;
import model.shapes.SelectedShapeList;
import model.shapes.ShapeList;

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
  public Point getStart() {
    return start;
  }

  @Override
  public Point getEnd() {
    return end;
  }

  @Override
  public int getWidth() {
    return end.x - start.x;
  }

  @Override
  public int getHeight() {
    return end.y - start.y;
  }

  @Override
  public boolean doesCollide(ShapeList shapeList) {
    for (int i = 0; i < shapeList.size(); i++) {
      IShape shape = shapeList.get(i);

      if (this.start.x > shape.getStart().x && this.start.x < shape.getEnd().x) {
        if (this.start.y > shape.getStart().y && this.start.y < shape.getEnd().y) {
          System.out.println("Selection collides");
          return true;
        }
      }

    }
    return false;
  }
}
