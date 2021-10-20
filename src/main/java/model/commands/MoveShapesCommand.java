package model.commands;

import controller.command.CommandHistory;
import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import model.Point;
import model.interfaces.IBoundingBox;
import model.interfaces.IShape;
import model.interfaces.UserChoices;
import model.shapes.ShapeList;

/**
 * MoveShapesCommand is an ICommand that takes all selected shapes and moves them depending on the delta between the
 * start and end Points
 */

public class MoveShapesCommand implements ICommand, Undoable {

  private final ShapeList shapeList;
  private final IBoundingBox box;
  private int deltaX;
  private int deltaY;

  //TODO: Fix MoveShapes
  public MoveShapesCommand(ShapeList shapeList, IBoundingBox box) {
    this.shapeList = shapeList;
    this.box = box;
    this.deltaX = box.getEnd().getX() - box.getStart().getX();
    this.deltaY = box.getEnd().getY() - box.getStart().getY();
    CommandHistory.add(this);
  }

  @Override
  public void execute() {
    for (IShape shape : shapeList.getSelected()) {
      shape.setStart(new Point(shape.getStart().getX() + deltaX, shape.getStart().getY() + deltaY));
      shape.setEnd(new Point(shape.getEnd().getX() + deltaX, shape.getEnd().getY() + deltaY));
    }
  }

  @Override
  public void undo() {
    for (IShape shape : shapeList.getSelected()) {
      shape.setStart(new Point(shape.getStart().getX() - deltaX, shape.getStart().getY() - deltaY));
      shape.setEnd(new Point(shape.getEnd().getX() - deltaX, shape.getEnd().getY() - deltaY));
    }
  }

  @Override
  public void redo() {
    execute();
  }
}
