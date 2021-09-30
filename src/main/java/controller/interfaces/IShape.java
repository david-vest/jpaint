package controller.interfaces;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public interface IShape {

  Point getStart();
  Point getEnd();
  Color getPrimaryColor();
  Color getSecondaryColor();
}
