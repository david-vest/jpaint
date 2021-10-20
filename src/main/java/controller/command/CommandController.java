package controller.command;

import controller.command.CommandFactory;
import controller.command.CommandHistory;
import controller.interfaces.ICommandFactory;
import model.Point;
import controller.interfaces.ICommand;
import model.interfaces.UserChoices;
import view.gui.PaintCanvas;

/**
 * CommandController communicates with MouseHandler and PaintCanvas to execute commands created by
 * CommandFactory
 */

public class CommandController {

  private final PaintCanvas paintCanvas;
  private final ICommandFactory commandFactory;

  public CommandController(CommandFactory commandFactory, PaintCanvas paintCanvas) {
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
