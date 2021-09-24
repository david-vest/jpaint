package controller.shapes;

import java.awt.Point;
import controller.interfaces.IShape;
import model.interfaces.UserChoices;

public class ShapeFactory {

  public static IShape createShape(UserChoices state, Point start, Point end) {
    return new Rectangle(state, start, end);
  }
}
