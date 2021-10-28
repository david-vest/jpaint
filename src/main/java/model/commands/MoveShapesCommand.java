package model.commands;

import controller.command.CommandHistory;
import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.interfaces.IBoundingBox;
import model.interfaces.IShape;
import model.shapes.ShapeList;

/**
 * MoveShapesCommand is an ICommand that takes all selected shapes and moves them depending on the delta between the
 * start and end Points
 */

public class MoveShapesCommand implements ICommand, Undoable {

  private ArrayList<IShape> movedShapes;
  private final ShapeList shapeList;
  private final int deltaX;
  private final int deltaY;

  public MoveShapesCommand(ShapeList shapeList, IBoundingBox box) {
    this.movedShapes = new ArrayList<>();
    this.shapeList = shapeList;
    this.deltaX = box.getEnd().getX() - box.getStart().getX();
    this.deltaY = box.getEnd().getY() - box.getStart().getY();
    CommandHistory.add(this);
  }

  @Override
  public void execute() {
    for (IShape shape : shapeList.getList()){
      if (shape.isSelected()) {
        shape.move(deltaX, deltaY);
        movedShapes.add(shape);
      }
    }
  }

  @Override
  public void undo() {
    for (IShape shape : movedShapes) {
      shape.move(-deltaX, -deltaY);
    }
  }

  @Override
  public void redo() {
    for (IShape shape: movedShapes) {
      shape.move(deltaX, deltaY);
    }
  }
}
