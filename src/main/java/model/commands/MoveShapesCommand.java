package model.commands;

import controller.command.CommandHistory;
import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import model.Point;
import model.interfaces.IShape;
import model.interfaces.UserChoices;
import model.shapes.ShapeList;

public class MoveShapesCommand implements ICommand, Undoable {

  private final UserChoices state;
  private final ShapeList shapeList;
  private final Point start;
  private final Point end;
  private final Point delta;

  public MoveShapesCommand(UserChoices state, ShapeList shapeList, Point start, Point end) {
    this.state = state;
    this.shapeList = shapeList;
    this.start = start;
    this.end = end;
    this.delta = new Point(end.getX() - start.getX(), end.getY() - start.getY());
    CommandHistory.add(this);
  }

  @Override
  public void execute() {
    shapeList.getList().stream().filter(IShape::isSelected).forEach((s) -> {
      Point newStart = new Point(s.getStart().getX() + delta.getX(), s.getStart().getY() + delta.getY());
      Point newEnd = new Point(s.getEnd().getX() + delta.getX(), s.getEnd().getY() + delta.getY());
      s.setStart(newStart);
      s.setEnd(newEnd);
    });
  }

  @Override
  public void undo() {
    shapeList.getList().stream().filter(IShape::isSelected).forEach((s) -> {
      Point newStart = new Point(s.getStart().getX() - delta.getX(), s.getStart().getY() - delta.getY());
      Point newEnd = new Point(s.getEnd().getX() - delta.getX(), s.getEnd().getY() - delta.getY());
      s.setStart(newStart);
      s.setEnd(newEnd);
    });
  }

  @Override
  public void redo() {
    execute();
  }
}
