package controller.commands;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import java.awt.Point;
import controller.interfaces.IShape;
import model.interfaces.UserChoices;
import controller.shapes.ShapeFactory;
import view.gui.PaintCanvas;

public class CreateShapeCommand implements ICommand, Undoable {

  private UserChoices state;
  private PaintCanvas paintCanvas;
  private final Point start;
  private final Point end;

  public CreateShapeCommand(UserChoices state, PaintCanvas paintCanvas, Point start, Point end){
    this.state = state;
    this.paintCanvas = paintCanvas;
    this.start = start;
    this.end = end;
  }

  @Override
  public void execute() {
    IShape shape = ShapeFactory.createShape(state, start, end);
    paintCanvas.picture.push(shape);
  }

  @Override
  public void undo() {

  }

  @Override
  public void redo() {

  }
}
