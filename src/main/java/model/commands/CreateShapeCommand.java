package model.commands;

import model.Point;
import model.interfaces.IBoundingBox;
import model.shapes.Shape;
import model.shapes.ShapeList;
import controller.command.CommandHistory;
import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import model.interfaces.IShape;
import model.interfaces.UserChoices;

/**
 * CreateShapeCommand gets a shape instance and renders the shape.
 */

public class CreateShapeCommand implements ICommand, Undoable {

  private final ShapeList shapeList;
  private final UserChoices state;
  private final IBoundingBox box;
  private IShape shape;

  public CreateShapeCommand(UserChoices state, ShapeList shapeList, IBoundingBox box){
    this.state = state;
    this.shapeList = shapeList;
    this.box = box;
    this.shape = null;
    this.box.normalize();
  }

  @Override
  public void execute() {
    shape = new Shape(state, box);
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
