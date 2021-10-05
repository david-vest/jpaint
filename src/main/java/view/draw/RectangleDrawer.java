package view.draw;

import java.awt.Graphics2D;
import model.interfaces.IShape;
import view.interfaces.DrawStrategy;

public class RectangleDrawer implements DrawStrategy {

  @Override
  public void draw(Graphics2D graphics2D, IShape shape) {
    graphics2D.setColor(shape.getPrimaryColor());
    graphics2D.fillRect(shape.getStart().x, shape.getStart().y, shape.getWidth(), shape.getHeight());
  }
}
