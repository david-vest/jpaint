package model.shapes;

import java.awt.Graphics2D;
import model.Point;
import model.ShapeType;
import model.interfaces.UserChoices;
import view.draw.EllipseDrawer;

public class Ellipse extends Shape {

  public Ellipse(UserChoices state, Point start, Point end) {
    super(state, start, end);
  }

  @Override
  public ShapeType getShapeType(){
    return ShapeType.ELLIPSE;
  }

  @Override
  public void draw(Graphics2D graphics2D) {
    drawStrategy = new EllipseDrawer();
    drawStrategy.draw(graphics2D, this);
  }
}
