package controller;

import controller.shapes.ShapeRenderer;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.EmptyStackException;
import controller.interfaces.IShape;

public class ShapeList {

  private final ShapeRenderer renderer;
  private ArrayList<IShape> shapeContainer = new ArrayList<>();

  public ShapeList(ShapeRenderer renderer) {
    this.renderer = renderer;
  }

  public void add(IShape shape) {
    shapeContainer.add(shape);
  }

  public IShape pop() {
    if (shapeContainer.isEmpty()) {
      throw new EmptyStackException();
    }
    return shapeContainer.remove(shapeContainer.size() - 1);
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
