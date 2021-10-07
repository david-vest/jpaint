package model.shapes;

import java.util.function.Consumer;
import model.interfaces.IShape;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.EmptyStackException;
import model.interfaces.IShapeList;

/**
 * ShapeList relies on an ArrayList of IShapes to hold all the shapes drawn.
 */

public class ShapeList implements IShapeList {

  private final ArrayList<IShape> shapeContainer = new ArrayList<>();

  public ShapeList() {
  }

  @Override
  public void add(IShape shape) {
    shapeContainer.add(shape);
  }

  @Override
  public void remove(IShape shape) {
    if (shapeContainer.isEmpty()) {
      throw new EmptyStackException();
    }
    shapeContainer.remove(shape);
  }

  @Override
  public int size() {
    return shapeContainer.size();
  }

  @Override
  public IShape get(int index) {
    return shapeContainer.get(index);
  }

  public ArrayList<IShape> getList() {
    return shapeContainer;
  }

  public void draw(Graphics2D graphics2D) {
    shapeContainer.forEach((s) -> s.draw(graphics2D));
  }
}
