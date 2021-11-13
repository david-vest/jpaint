package model.interfaces;

import model.Point;

/**
 * IBoundingBox controls the rectangular "bounds" of each of the shape. Changing the start and end
 * point will change the size and location of the shape. Mostly used to detect collision between two
 * Bounding Boxes
 */

public interface IBoundingBox {
  void normalize();
  Point getStart();
  Point getEnd();
  void move(int x, int y);
  boolean doesCollide(IBoundingBox box);
  IBoundingBox copy();
}
