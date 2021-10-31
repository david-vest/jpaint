package view.draw;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import model.interfaces.IShape;
import view.interfaces.ShapeDecorator;

public class FillDrawer implements ShapeDecorator {

  private ShapeDecorator shapeDecorator;

  public FillDrawer(ShapeDecorator shapeDecorator) {
    if (shapeDecorator ==  null) {
      this.shapeDecorator = new NullDrawer();
      throw new IllegalArgumentException("Null is not allowed. Use empty constructor.");
    }

    this.shapeDecorator = shapeDecorator;
  }

  public FillDrawer() {
    this.shapeDecorator = new NullDrawer();
  }

  @Override
  public void drawRectangle(Graphics2D graphics2D, IShape shape) {
    shapeDecorator.drawRectangle(graphics2D, shape);
    graphics2D.setColor(shape.getPrimaryColor());
    graphics2D.fillRect(shape.getStart().getX(), shape.getStart().getY(), shape.getWidth(), shape.getHeight());
  }

  @Override
  public void drawEllipse(Graphics2D graphics2D, IShape shape) {
    shapeDecorator.drawEllipse(graphics2D, shape);
    graphics2D.setColor(shape.getPrimaryColor());
    graphics2D.fill(new Ellipse2D.Double(shape.getStart().getX(), shape.getStart().getY(), shape.getWidth(), shape.getHeight()));
  }

  @Override
  public void drawTriangle(Graphics2D graphics2D, IShape shape, Polygon poly) {
    shapeDecorator.drawTriangle(graphics2D, shape, poly);
    graphics2D.setColor(shape.getPrimaryColor());
    graphics2D.fillPolygon(poly);
  }
}
