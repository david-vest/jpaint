package model.shapes;

import model.interfaces.IShape;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * ShapeList relies on an ArrayList of IShapes to hold all the shapes drawn.
 */

public class ShapeList {

  private final ShapeRenderer renderer;
  private final ArrayList<IShape> shapeContainer = new ArrayList<>();

  public ShapeList(ShapeRenderer renderer) {
    this.renderer = renderer;
  }

  public void add(IShape shape) {
    shapeContainer.add(shape);
  }

  public boolean remove(IShape shape) {
    if (shapeContainer.isEmpty()) {
      throw new EmptyStackException();
    }
    return shapeContainer.remove(shape);
  }

  public void draw(Graphics2D graphics2D) {
    shapeContainer.forEach((s) -> renderer.renderShape(s, graphics2D));
  }
}
