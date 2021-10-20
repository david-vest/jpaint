package model.shapes;

import model.interfaces.IBoundingBox;
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
  private final ArrayList<IShape> selected = new ArrayList<>();

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
  public void select(IBoundingBox box) {
    selected.clear();

    shapeContainer.forEach((s) -> {
      s.setSelected(false);
      if (box.doesCollide(s.getBBox())) {
        s.setSelected(true);
      }
    });
  }

  @Override
  public ArrayList<IShape> getSelected() {
    return selected;
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
