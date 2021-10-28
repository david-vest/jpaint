package controller.command;

import controller.interfaces.ICommand;
import model.commands.CopyShapesCommand;
import model.commands.PasteShapesCommand;
import model.shapes.BoundingBox;
import model.Point;
import model.commands.CreateShapeCommand;
import model.commands.MoveShapesCommand;
import model.commands.SelectShapesCommand;
import model.interfaces.UserChoices;
import model.shapes.ShapeList;

/**
 * CommandFactory is a factory method that instantiates a new ICommand depending on the current mouse
 * mode
 */

public class CommandFactory {

  private final UserChoices state;
  private final ShapeList shapeList;

  public CommandFactory(UserChoices state, ShapeList shapeList) {
    this.state = state;
    this.shapeList = shapeList;
  }

  public ICommand makeDrawCommand(Point start, Point end) {

    BoundingBox box = new BoundingBox(start, end);

    switch (state.getActiveMouseMode()) {
      case DRAW:
        return new CreateShapeCommand(state, shapeList, box);
      case SELECT:
        return new SelectShapesCommand(shapeList, box);
      case MOVE:
        return new MoveShapesCommand(shapeList, box);
    }
    throw new IllegalStateException("No active mouse mode");
  }

  public ICommand makeCopyCommand() {
    return new CopyShapesCommand(shapeList);
  }

  public ICommand makePasteCommand() {
    return new PasteShapesCommand(shapeList);
  }
}
