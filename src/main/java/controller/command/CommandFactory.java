package controller.command;

import controller.Clipboard;
import controller.interfaces.ICommand;
import model.commands.CopyShapesCommand;
import model.commands.DeleteShapesCommand;
import model.commands.PasteShapesCommand;
import model.shapes.BoundingBox;
import model.Point;
import model.commands.CreateShapeCommand;
import model.commands.MoveShapesCommand;
import model.commands.SelectShapesCommand;
import model.interfaces.UserChoices;
import model.shapes.ShapeList;

/**
 * CommandFactory is a static factory that instantiates a new ICommand depending on the current mouse
 * mode, as well as make the instances of copy, paste, and delete.
 */

public class CommandFactory {

  public static ICommand makeDrawCommand(UserChoices state, ShapeList shapeList, Point start, Point end) {
    BoundingBox box = new BoundingBox(start, end);

    switch (state.getActiveMouseMode()) {
      case DRAW:
        return new CreateShapeCommand(state, shapeList, box);
      case SELECT:
        return new SelectShapesCommand(shapeList, box);
      case MOVE:
        return new MoveShapesCommand(shapeList, box);
      default:
        throw new IllegalStateException("No active mouse mode");
    }
  }

  public static ICommand makeCopyCommand(ShapeList shapeList, Clipboard clipboard) {
    return new CopyShapesCommand(shapeList, clipboard);
  }

  public static ICommand makePasteCommand(ShapeList shapeList, Clipboard clipboard) { return new PasteShapesCommand(shapeList, clipboard); }

  public static ICommand makeDeleteCommand(ShapeList shapeList) { return new DeleteShapesCommand(shapeList); }
}
