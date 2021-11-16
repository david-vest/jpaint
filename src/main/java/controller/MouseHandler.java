package controller;

import controller.command.CommandController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Point;

/**
 * MouseHandler is responsible for propagating mouse coordinates into our application
 * classes. This is a boundary class so very little code should be added here.
 */
public class MouseHandler extends MouseAdapter {

  private final CommandController controller;
  private Point startPoint;

  public MouseHandler(CommandController controller) {
    this.controller = controller;
  }


  @Override
  public void mousePressed(MouseEvent e) {
    startPoint = new Point(e.getX(), e.getY());
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    Point endPoint = new Point(e.getX(), e.getY());
    controller.onDraw(startPoint, endPoint);
  }
}
