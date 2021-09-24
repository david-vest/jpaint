package controller.interfaces;

import java.awt.Graphics2D;
import java.awt.Point;

public interface IShape {

  Point getStart();
  Point getEnd();
  void render(Graphics2D g);

}
