package controller.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import controller.interfaces.IShape;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.UserChoices;

public class Rectangle extends Shape {

  public Rectangle(UserChoices state, Point start, Point end) {
    super(state, start, end);
  }

  @Override
  public ShapeType getShapeType() {
    return ShapeType.RECTANGLE;
  }
}