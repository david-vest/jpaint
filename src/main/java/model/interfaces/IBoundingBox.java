package model.interfaces;

import model.Point;

public interface IBoundingBox {
  model.Point getStart();
  Point getEnd();
  int getWidth();
  int getHeight();
  boolean doesCollide(IBoundingBox box);
}
