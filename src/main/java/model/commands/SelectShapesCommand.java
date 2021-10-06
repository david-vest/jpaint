package model.commands;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import java.awt.Point;
import model.interfaces.UserChoices;
import model.shapes.ShapeList;

public class SelectShapesCommand implements ICommand, Undoable {

  private final UserChoices state;
  private final ShapeList shapeList;
  private final Point start;
  private final Point end;

  public SelectShapesCommand(UserChoices state, ShapeList shapeList, Point start, Point end) {

    this.state = state;
    this.shapeList = shapeList;
    this.start = start;
    this.end = end;
  }

  @Override
  public void execute() {
    System.out.println("Selecting shapes...");

  }

  @Override
  public void undo() {

  }

  @Override
  public void redo() {

  }
}
