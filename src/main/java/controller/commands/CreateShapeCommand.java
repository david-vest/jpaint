package controller.commands;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import controller.shapes.ShapeRenderer;
import java.awt.Point;
import controller.interfaces.IShape;
import model.interfaces.UserChoices;
import controller.shapes.ShapeFactory;
import view.gui.PaintCanvas;

public class CreateShapeCommand implements ICommand, Undoable {

  private UserChoices state;
  private final Point start;
  private final Point end;
  private final ShapeRenderer renderer;

  public CreateShapeCommand(UserChoices state, ShapeRenderer renderer, Point start, Point end){
    this.state = state;
    this.renderer = renderer;
    this.start = start;
    this.end = end;
  }

  @Override
  public void execute() {
    IShape shape = ShapeFactory.createShape(state, start, end);
    renderer.renderRectangle(shape);
    CommandHistory.add(this);
  }

  @Override
  public void undo() {

  }

  @Override
  public void redo() {

  }
}
