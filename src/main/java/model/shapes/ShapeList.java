package model.shapes;

import java.util.stream.Collectors;
import model.interfaces.IBoundingBox;
import model.interfaces.IShape;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * ShapeList relies on an ArrayList of IShapes to hold all the shapes drawn.
 */

public class ShapeList {

  private final ArrayList<IShape> shapeContainer = new ArrayList<>();

  public ShapeList() {
  }

  public void add(IShape shape) {
    shapeContainer.add(shape);
  }

  public void remove(IShape shape) {
    shapeContainer.remove(shape);
  }

  public void select(IBoundingBox box) {
    shapeContainer.forEach((s) -> {
      s.setSelected(false);
      boolean collision = s.getBBox().doesCollide(box);
      s.setSelected(collision);
    });
  }

  public ArrayList<IShape> getSelected() {
    return (ArrayList<IShape>) shapeContainer.stream().filter(IShape::isSelected).collect(Collectors.toList());
  }

  public void draw(Graphics2D graphics2D) {
    shapeContainer.forEach((s) -> s.draw(graphics2D));
  }
}
