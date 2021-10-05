package view.interfaces;

import java.awt.Graphics2D;
import model.interfaces.IShape;

public interface DrawStrategy {
  void draw(Graphics2D graphics2D, IShape shape);
}
