package view.interfaces;

import java.awt.Graphics2D;
import java.awt.Polygon;
import model.interfaces.IShape;

/**
 * ShapeDecorator is a decorator interface that handles the style of each of the shapes.
 */
public interface ShapeDecorator {

  void drawRectangle(Graphics2D graphics2D, IShape shape);
  void drawEllipse(Graphics2D graphics2D, IShape shape);
  void drawTriangle(Graphics2D graphics2D, IShape shape, Polygon poly);
}
