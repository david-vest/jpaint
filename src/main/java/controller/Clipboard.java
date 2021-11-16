package controller;

import java.util.ArrayList;
import model.interfaces.IShape;
import model.shapes.ShapeList;

/**
 * Clipboard holds an ArrayList of IShape instances that have been copied
 */
public class Clipboard {
  private final ArrayList<IShape> clipboard = new ArrayList<>();

  public Clipboard(ShapeList shapeList) {
  }

  public void add(IShape shape) {
    clipboard.add(shape);
  }

  public void clear() {
    clipboard.clear();
  }

  public ArrayList<IShape> getClipboard() {
    return clipboard;
  }
}
