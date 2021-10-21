package model.interfaces;

import java.awt.Color;
import java.awt.Graphics2D;
import model.Point;
import model.ShapeType;
import view.interfaces.DrawStrategy;

/**
 *  IShape is responsible for holding a drawn shape's data.
 */


public interface IShape {

  Point getStart();
  Point getEnd();
  Color getPrimaryColor();
  Color getSecondaryColor();
  ShapeType getShapeType();
  int getWidth();
  int getHeight();
  void setStart(Point p);
  void setEnd(Point p);
  DrawStrategy getStrategy();
  void draw(Graphics2D graphics2D);
  boolean isSelected();
  void setSelected(boolean isSelected);
  void move(int x, int y);
  IBoundingBox getBBox();
}
