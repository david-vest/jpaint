package view.draw;

import java.awt.Graphics2D;
import java.awt.Polygon;
import model.interfaces.IShape;
import view.interfaces.ShapeDecorator;

/**
 * NullDrawer is a null object pattern that is used once the last ShapeDecorator is reached to end the
 * chain.
 */
public class NullDrawer implements ShapeDecorator {

  @Override
  public void drawRectangle(Graphics2D graphics2D, IShape shape) {

  }

  @Override
  public void drawEllipse(Graphics2D graphics2D, IShape shape) {

  }

  @Override
  public void drawTriangle(Graphics2D graphics2D, IShape shape, Polygon poly) {

  }
}
