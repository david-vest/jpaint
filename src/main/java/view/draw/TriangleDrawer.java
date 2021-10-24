package view.draw;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import model.Point;
import java.awt.Polygon;
import model.interfaces.IShape;
import view.interfaces.DrawStrategy;
import view.interfaces.ShapeDecorator;

/**
 * @see view.interfaces.DrawStrategy
 */

public class TriangleDrawer implements DrawStrategy {

  private ShapeDecorator shapeDecorator;

  public TriangleDrawer(ShapeDecorator shapeDecorator) {
    if (shapeDecorator == null) {
      this.shapeDecorator = new NullDrawer();
    }
    this.shapeDecorator = shapeDecorator;
  }

  @Override
  public void draw(Graphics2D graphics2D, IShape shape) {
    graphics2D.setStroke(new BasicStroke(3));
    int[][] dimensions = getDimensions(shape.getStart(), shape.getWidth(), shape.getHeight());
    Polygon triangle = new Polygon(dimensions[0], dimensions[1], 3);
    shapeDecorator.drawTriangle(graphics2D, shape, triangle);
  }

  @Override
  public ShapeDecorator getDecorator() {
    return shapeDecorator;
  }

  @Override
  public void setDecorator(ShapeDecorator decorator) {
    this.shapeDecorator = decorator;
  }

  protected static int[][] getDimensions(Point start, int width, int height) {
    int[] xDim = new int[3];
    int[] yDim = new int[3];

    int x = start.getX();
    int y = start.getY();

    xDim[0] = x;
    xDim[1] = x + (width / 2);
    xDim[2] = x + width;
    yDim[0] = y + height;
    yDim[1] = y;
    yDim[2] = y + height;

    return new int[][] {xDim, yDim};
  }
}
