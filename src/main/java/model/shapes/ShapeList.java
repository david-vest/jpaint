package model.shapes;

import model.interfaces.IBoundingBox;
import model.interfaces.IShape;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * ShapeList relies on an ArrayList of IShapes to hold all the shapes drawn.
 */

public class ShapeList {

  private final ArrayList<IShape> shapeContainer = new ArrayList<>();
  private final ArrayList<IShape> clipboard = new ArrayList<>();

  public ShapeList() {
  }

  public void add(IShape shape) {
    shapeContainer.add(shape);
  }

  public void remove(IShape shape) {
    if (shapeContainer.isEmpty()) {
      throw new EmptyStackException();
    }
    shapeContainer.remove(shape);
  }

  public void select(IBoundingBox box) {
    shapeContainer.forEach((s) -> {
      s.setSelected(false);
      System.out.println("Deselected " + s + "\n");
      if (box.doesCollide(s.getBBox())) {
        s.setSelected(true);
      }
    });
  }

  public void copySelected() {
    clipboard.clear();
    for (IShape s : shapeContainer) {
      if (s.isSelected()) {
        System.out.println("Copying: " + s);
        clipboard.add(s);
      }
    }
  }

  public ArrayList<IShape> getList() {
    return shapeContainer;
  }

  public ArrayList<IShape> getClipboard() {
    return clipboard;
  }

  public void draw(Graphics2D graphics2D) {
    shapeContainer.forEach((s) -> {
      System.out.print("Drawing " + s + "\n");
      s.draw(graphics2D);
    });
  }
}
