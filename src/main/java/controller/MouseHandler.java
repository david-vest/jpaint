package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MouseHandler is responsible for propagating mouse coordinates into our application
 * classes. This is a boundary class so very little code should be added here.
 */
public class MouseHandler extends MouseAdapter {

  private static final Logger log = LoggerFactory.getLogger(MouseHandler.class);
  private final CommandController controller;
  private Point startPoint;
  private Point endPoint;

  public MouseHandler(CommandController controller) {
    this.controller = controller;
  }


  @Override
  public void mousePressed(MouseEvent e) {
    log.debug("Start " + e.getX() + " " + e.getY());
    startPoint = new Point(e.getX(), e.getY());
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    log.debug("End " + e.getX() + " " + e.getY());
    endPoint = new Point(e.getX(), e.getY());
    controller.onDraw(startPoint, endPoint);
  }
}
