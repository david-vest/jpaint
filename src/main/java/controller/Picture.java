package controller;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.EmptyStackException;
import controller.interfaces.IShape;

public class Picture {
  private ArrayList<IShape> shapeContainer = new ArrayList<>();

  public Picture() {
  }

  public void push(IShape shape) {
    shapeContainer.add(shape);
  }

  public IShape pop(IShape shape) {
    if (shapeContainer.isEmpty()) {
      throw new EmptyStackException();
    }

    return shapeContainer.remove(shapeContainer.size() - 1);
  }

  public void draw(Graphics2D graphics2D) {
    shapeContainer.forEach((s) -> s.render(graphics2D));
  }
}
