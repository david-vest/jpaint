package model.interfaces;

import java.awt.Graphics2D;

/**
 * IRenderer is responsible for rendering and drawing each shape
 */

public interface IRenderer {

  void renderShape(IShape shape, Graphics2D graphics2D);

}
