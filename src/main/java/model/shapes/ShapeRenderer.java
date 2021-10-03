package model.shapes;

import model.interfaces.IShape;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import model.interfaces.IRenderer;

public class ShapeRenderer implements IRenderer {

  public void renderShape(IShape shape, Graphics2D graphics2D) {
    switch (shape.getShapeType()) {
      case RECTANGLE:
        renderRectangle(shape, graphics2D);
        break;
      case TRIANGLE:
        renderTriangle(shape, graphics2D);
        break;
      case ELLIPSE:
        renderEllipse(shape, graphics2D);
        break;
    }
  }

  private void renderRectangle(IShape shape, Graphics2D graphics2D) {
    Color primColor = shape.getPrimaryColor();
    Point start = shape.getStart();
    Point end = shape.getEnd();
    int x1, y1, x2, y2;
    x1 = Math.min(start.x, end.x);
    y1 = Math.min(start.y, end.y);
    x2 = Math.max(start.x, end.x);
    y2 = Math.max(start.y, end.y);

    int width = x2 - x1;
    int height = y2 - y1;

    graphics2D.setPaint(primColor);
    graphics2D.fillRect(x1, y1, width, height);
    graphics2D.drawRect(x1, y1, width, height);
  }

  //TODO: Render Triangle
  private void renderTriangle(IShape shape, Graphics2D graphics2D) {

  }

  //TODO: Render Ellipse
  private void renderEllipse(IShape shape, Graphics2D graphics2D) {

  }

}
