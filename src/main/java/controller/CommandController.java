package controller;

import controller.command.CommandFactory;
import controller.command.CommandHistory;
import controller.interfaces.ICommandFactory;
import model.Point;
import model.commands.CreateShapeCommand;
import controller.interfaces.ICommand;
import model.shapes.ShapeList;
import model.MouseMode;
import model.interfaces.UserChoices;
import view.gui.PaintCanvas;

/**
 * CommandController communicates with MouseHandler to call the appropriate commands depending on the UserChoices state
 */

public class CommandController {

  private final PaintCanvas paintCanvas;
  private final UserChoices state;
  private final ICommandFactory commandFactory;

  public CommandController(UserChoices state, CommandFactory commandFactory, PaintCanvas paintCanvas) {
    this.state = state;
    this.paintCanvas = paintCanvas;
    this.commandFactory = commandFactory;
  }

  public void onDraw(Point start, Point end) {
    ICommand command = commandFactory.makeDrawCommand(start, end);
    command.execute();
    paintCanvas.repaint();
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
