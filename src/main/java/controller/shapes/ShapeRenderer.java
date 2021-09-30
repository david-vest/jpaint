package controller.shapes;

import controller.interfaces.IShape;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import model.interfaces.UserChoices;
import model.persistence.UserChoicesImpl;

public class ShapeRenderer {
  UserChoices state;
  Graphics2D graphics2D;

  public ShapeRenderer(UserChoices state, Graphics2D graphics2D) {
   this.state = state;
   this.graphics2D = graphics2D;
  }

  public void renderRectangle(IShape shape) {
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

}
