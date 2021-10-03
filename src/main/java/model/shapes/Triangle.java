package model.shapes;

import java.awt.Point;
import model.ShapeType;
import model.interfaces.UserChoices;

public class Triangle extends Shape {

  public Triangle(UserChoices state, Point start, Point end) {
    super(state, start, end);
  }

  public ShapeType getShapeType() {
    return ShapeType.TRIANGLE;
  }
}
