package model.shapes;

import java.awt.Point;
import model.interfaces.IShape;
import model.interfaces.UserChoices;

/**
 * ShapeFactory is a static factory that creates a Shape instance depending on the UserChoices state
 */

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
