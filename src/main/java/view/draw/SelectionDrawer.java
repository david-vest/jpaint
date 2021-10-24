package view.draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import model.Point;
import model.interfaces.IShape;
import view.interfaces.ShapeDecorator;

public class SelectionDrawer implements ShapeDecorator {
  private ShapeDecorator shapeDecorator;
  private BasicStroke stroke;
  private final int OFFSET = 5;
  private final int LEN_OFFSET = OFFSET * 2;

  public SelectionDrawer(ShapeDecorator shapeDecorator) {
    if (shapeDecorator == null) {
      this.shapeDecorator = new NullDrawer();
    }
    this.shapeDecorator = shapeDecorator;
    this.stroke = getStroke();
  }

  @Override
  public void drawRectangle(Graphics2D graphics2D, IShape shape) {
    shapeDecorator.drawRectangle(graphics2D, shape);
    graphics2D.setStroke(stroke);
    graphics2D.setColor(Color.darkGray);
    graphics2D.drawRect(shape.getStart().getX() -OFFSET, shape.getStart().getY() - OFFSET, shape.getWidth() + LEN_OFFSET, shape.getHeight() + LEN_OFFSET);
  }

  @Override
  public void drawEllipse(Graphics2D graphics2D, IShape shape) {
    shapeDecorator.drawEllipse(graphics2D, shape);
    graphics2D.setStroke(stroke);
    graphics2D.setColor(Color.darkGray);
    graphics2D.draw(new Ellipse2D.Double(shape.getStart().getX() - OFFSET, shape.getStart().getY() - OFFSET,
        shape.getWidth() + LEN_OFFSET, shape.getHeight() + LEN_OFFSET));
  }

  @Override
  public void drawTriangle(Graphics2D graphics2D, IShape shape, Polygon poly) {
    shapeDecorator.drawTriangle(graphics2D, shape, poly);
    graphics2D.setStroke(stroke);
    graphics2D.setColor(Color.darkGray);
    Point newPoint = new Point(shape.getStart().getX() - OFFSET, shape.getStart().getY() - OFFSET);
    int[][] new_dim = TriangleDrawer.getDimensions(newPoint, shape.getWidth() + LEN_OFFSET, shape.getHeight() + LEN_OFFSET);
    graphics2D.drawPolygon(new Polygon(new_dim[0], new_dim[1], 3));
  }

  private BasicStroke getStroke() {
    float[] dashed = {10.0f};
    return new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dashed, 0.0f);
  }
}
