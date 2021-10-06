package model.interfaces;

import java.awt.Point;
import model.shapes.ShapeList;

public interface IBoundingBox {
  Point getStart();
  Point getEnd();
  int getWidth();
  int getHeight();
  boolean doesCollide(ShapeList shapeList);


}
