package view.interfaces;

import java.awt.Graphics2D;
import model.interfaces.IShape;

/**
 * DrawStrategy is an interface that handles drawing the ShapeDecorator for the three shapes.
 * */

public interface DrawStrategy {
  void draw(Graphics2D graphics2D, IShape shape);
  ShapeDecorator getDecorator();
  void setDecorator(ShapeDecorator decorator);
}
