package model.commands;

import model.shapes.ShapeList;
import controller.command.CommandHistory;
import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import java.awt.Point;
import model.interfaces.IShape;
import model.interfaces.UserChoices;
import model.shapes.ShapeFactory;

/**
 * CreateShapeCommand gets a shape instance and renders the shape.
 */

public class CreateShapeCommand implements ICommand, Undoable {

  private final ShapeList shapeList;
  private final UserChoices state;
  private final Point start;
  private final Point end;
  private IShape shape;

  public CreateShapeCommand(UserChoices state, ShapeList shapeList, Point start, Point end){
    this.state = state;
    this.shapeList = shapeList;
    this.start = start;
    this.end = end;
    this.shape = null;
  }

  @Override
  public void execute() {
    shape = ShapeFactory.createShape(state, start, end);
    shapeList.add(shape);
    CommandHistory.add(this);
  }

  @Override
  public void undo() {
    shapeList.remove(shape);
  }

  @Override
  public void redo() {
    shapeList.add(shape);
  }
}
