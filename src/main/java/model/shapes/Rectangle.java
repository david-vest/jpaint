package model.shapes;

import java.awt.Point;
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