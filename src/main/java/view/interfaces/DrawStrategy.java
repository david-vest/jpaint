package view.interfaces;

import java.awt.Graphics2D;
import model.interfaces.IShape;

/**
 * DrawStrategy is a strategy responsible for interfacing with the graphics API and IShapes to draw shapes
 * according to their size, color, and other attributes.
 * */

public interface DrawStrategy {
  void draw(Graphics2D graphics2D, IShape shape);
}
