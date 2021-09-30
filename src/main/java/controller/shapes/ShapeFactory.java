package controller.shapes;

import java.awt.Point;
import controller.interfaces.IShape;
import model.ShapeType;
import model.interfaces.UserChoices;

public class ShapeFactory {

  public static IShape createShape(UserChoices state, Point start, Point end) {
    IShape shape = null;
    switch (state.getActiveShapeType()) {
      case RECTANGLE:
        shape = new Rectangle(state, start, end);
        break;
      case TRIANGLE:
        shape = new Triangle(state, start, end);
        break;
      case ELLIPSE:
        shape = new Ellipse(state, start, end);
    }
    return shape;
  }
}
