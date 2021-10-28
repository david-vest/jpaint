package model.interfaces;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;
import model.Point;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.DrawStrategy;
import view.interfaces.ShapeDecorator;

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
  void draw(Graphics2D graphics2D);
  DrawStrategy getDrawStrategy();
  ShapeDecorator getShapeDecorator();
  boolean isSelected();
  void setSelected(boolean isSelected);
  void move(int x, int y);
  IBoundingBox getBBox();
}
