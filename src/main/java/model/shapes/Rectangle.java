package model.shapes;

import java.awt.Graphics2D;
import model.Point;
import model.ShapeType;
import model.interfaces.UserChoices;
import view.draw.RectangleDrawer;

public class Rectangle extends Shape {

  public Rectangle(UserChoices state, Point start, Point end) {
    super(state, start, end);
  }

  @Override
  public ShapeType getShapeType() {
    return ShapeType.RECTANGLE;
  }

  @Override
  public void draw(Graphics2D graphics2D) {
    drawStrategy = new RectangleDrawer();
    drawStrategy.draw(graphics2D, this);
  }
}