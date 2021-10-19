package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.ICommandFactory;
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

public class CommandFactory implements ICommandFactory {

  private final UserChoices state;
  private final ShapeList shapeList;

  public CommandFactory(UserChoices state, ShapeList shapeList) {
    this.state = state;
    this.shapeList = shapeList;
  }

  @Override
  public ICommand makeDrawCommand(Point start, Point end) {

    switch (state.getActiveMouseMode()) {
      case DRAW:
        return new CreateShapeCommand(state, shapeList, start, end);
      case SELECT:
        return new SelectShapesCommand(state, shapeList, start, end);
      case MOVE:
        return new MoveShapesCommand(state, shapeList, start, end);
    }
    return null;
  }
}
