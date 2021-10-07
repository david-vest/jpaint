package model.commands;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import model.Point;
import model.BoundingBox;
import model.interfaces.IBoundingBox;
import model.interfaces.UserChoices;
import model.shapes.ShapeList;

public class SelectShapesCommand implements ICommand {

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
    IBoundingBox selectingBox = new BoundingBox(start, end);

    shapeList.getList().forEach((s) -> {
      s.setSelected(false);
      if (selectingBox.doesCollide(s.getBBox())) {
        s.setSelected(true);
      }
    });
  }
}
