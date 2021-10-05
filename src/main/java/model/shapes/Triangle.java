package model.shapes;

import java.awt.Graphics2D;
import java.awt.Point;
import model.ShapeType;
import model.interfaces.UserChoices;
import view.draw.TriangleDrawer;

public class Triangle extends Shape {

  public Triangle(UserChoices state, Point start, Point end) {
    super(state, start, end);
  }

  @Override
  public ShapeType getShapeType() {
    return ShapeType.TRIANGLE;
  }

  @Override
  public void draw(Graphics2D graphics2D) {
    drawStrategy = new TriangleDrawer();
    drawStrategy.draw(graphics2D, this);
  }
}
