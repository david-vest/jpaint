package view.draw;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import javax.swing.border.Border;
import model.interfaces.IShape;
import view.interfaces.DrawStrategy;
import view.interfaces.ShapeDecorator;

public class BorderDrawer implements ShapeDecorator {

  private ShapeDecorator shapeDecorator;

  public BorderDrawer(ShapeDecorator shapeDecorator) {
    if (shapeDecorator == null) {
      this.shapeDecorator = new NullDrawer();
    }
    this.shapeDecorator = shapeDecorator;
  }

  public BorderDrawer() {
    this.shapeDecorator = new NullDrawer();
  }

  @Override
  public void drawRectangle(Graphics2D graphics2D, IShape shape) {
    shapeDecorator.drawRectangle(graphics2D, shape);
    graphics2D.setColor(shape.getSecondaryColor());
    graphics2D.drawRect(shape.getStart().getX(), shape.getStart().getY(), shape.getWidth(), shape.getHeight());
  }

  @Override
  public void drawEllipse(Graphics2D graphics2D, IShape shape) {
    shapeDecorator.drawEllipse(graphics2D, shape);
    graphics2D.setColor(shape.getSecondaryColor());
    graphics2D.draw(new Ellipse2D.Double(shape.getStart().getX(), shape.getStart().getY(), shape.getWidth(), shape.getHeight()));
  }

  @Override
  public void drawTriangle(Graphics2D graphics2D, IShape shape, Polygon poly) {
    shapeDecorator.drawTriangle(graphics2D, shape, poly);

    graphics2D.setColor(shape.getSecondaryColor());
    graphics2D.drawPolygon(poly);
  }
}
