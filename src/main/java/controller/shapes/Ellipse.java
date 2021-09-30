package controller.shapes;

import java.awt.Point;
import model.ShapeType;
import model.interfaces.UserChoices;

public class Ellipse extends Shape {

  public Ellipse(UserChoices state, Point start, Point end) {
    super(state, start, end);
  }

  @Override
  public ShapeType getShapeType(){
    return ShapeType.ELLIPSE;
  }
}
