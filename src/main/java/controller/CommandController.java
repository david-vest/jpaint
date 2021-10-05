package controller;

import controller.command.CommandHistory;
import model.commands.CreateShapeCommand;
import controller.interfaces.ICommand;
import model.shapes.ShapeList;
import java.awt.Point;
import model.MouseMode;
import model.interfaces.UserChoices;
import view.gui.PaintCanvas;

/**
 * CommandController communicates with MouseHandler to call the appropriate commands depending on the UserChoices state
 */

public class CommandController {

  private final PaintCanvas paintCanvas;
  private final UserChoices state;
  private final ShapeList shapeList;

  public CommandController(UserChoices state, ShapeList shapeList, PaintCanvas paintCanvas) {
    this.state = state;
    this.paintCanvas = paintCanvas;
    this.shapeList = shapeList;
  }

  public void onDraw(Point start, Point end) {
    ICommand command;
    if (state.getActiveMouseMode() == MouseMode.DRAW) {
      command = new CreateShapeCommand(state, shapeList, start, end);
      command.execute();
      paintCanvas.repaint();
    }
  }

  public void onUndo() {
    CommandHistory.undo();
    paintCanvas.repaint();
  }

  public void onRedo() {
    CommandHistory.redo();
    paintCanvas.repaint();
  }
}
