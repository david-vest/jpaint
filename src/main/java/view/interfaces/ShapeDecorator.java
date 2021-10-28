package view.interfaces;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.io.Serializable;
import model.interfaces.IShape;

public interface ShapeDecorator {

  void drawRectangle(Graphics2D graphics2D, IShape shape);
  void drawEllipse(Graphics2D graphics2D, IShape shape);
  void drawTriangle(Graphics2D graphics2D, IShape shape, Polygon poly);
}
