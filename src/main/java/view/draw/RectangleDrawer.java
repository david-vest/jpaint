package view.draw;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import model.interfaces.IShape;
import view.interfaces.DrawStrategy;
import view.interfaces.ShapeDecorator;

/**
 * @see view.interfaces.DrawStrategy
 */

public class RectangleDrawer implements DrawStrategy {

  private ShapeDecorator shapeDecorator;

  public RectangleDrawer(ShapeDecorator shapeDecorator) {
    if (shapeDecorator == null) {
      this.shapeDecorator = new NullDrawer();
    }

    this.shapeDecorator = shapeDecorator;
  }

  @Override
  public ShapeDecorator getDecorator() {
    return shapeDecorator;
  }

  @Override
  public void setDecorator(ShapeDecorator decorator) {
    this.shapeDecorator = decorator;
  }

  @Override
  public void draw(Graphics2D graphics2D, IShape shape) {
    graphics2D.setStroke(new BasicStroke(3));
    shapeDecorator.drawRectangle(graphics2D, shape);
  }
}
