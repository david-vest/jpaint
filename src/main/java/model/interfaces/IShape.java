package model.interfaces;

import java.awt.Color;
import java.awt.Point;
import model.ShapeType;

/**
 *  IShape is responsible for holding a drawn shape's data.
 */


public interface IShape {

  Point getStart();
  Point getEnd();
  Color getPrimaryColor();
  Color getSecondaryColor();
  ShapeType getShapeType();
}
