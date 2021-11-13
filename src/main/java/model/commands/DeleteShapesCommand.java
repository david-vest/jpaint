package model.commands;

import controller.command.CommandHistory;
import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.interfaces.IShape;
import model.shapes.ShapeList;

public class DeleteShapesCommand implements ICommand, Undoable {

  private final ShapeList shapeList;
  private final ArrayList<IShape> deletedShapes;

  public DeleteShapesCommand(ShapeList shapeList) {
    this.shapeList = shapeList;
    this.deletedShapes = new ArrayList<>();
  }

  @Override
  public void execute() {
    deletedShapes.addAll(shapeList.getSelected());
    deletedShapes.forEach(shapeList::remove);
    CommandHistory.add(this);
  }

  @Override
  public void undo() {
    deletedShapes.forEach(shapeList::add);
  }

  @Override
  public void redo() {
    deletedShapes.forEach(shapeList::remove);
  }
}
