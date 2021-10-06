package model.commands;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import java.awt.Point;
import model.interfaces.UserChoices;
import model.shapes.ShapeList;

public class MoveShapesCommand implements ICommand, Undoable {

  public MoveShapesCommand(UserChoices state, ShapeList shapeList, Point start, Point end) {
  }

  @Override
  public void execute() {
    System.out.println("Moving shapes...");
  }

  @Override
  public void undo() {

  }

  @Override
  public void redo() {

  }
}
