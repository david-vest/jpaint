package controller.command;

import model.Point;
import controller.interfaces.ICommand;
import view.gui.PaintCanvas;

/**
 * CommandController communicates with MouseHandler and PaintCanvas to execute commands created by
 * CommandFactory
 */

public class CommandController {

  private final PaintCanvas paintCanvas;
  private final CommandFactory commandFactory;

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

  public void onCopy() {
    ICommand command = commandFactory.makeCopyCommand();
    command.execute();
  }

  public void onPaste() {
    ICommand command = commandFactory.makePasteCommand();
    command.execute();
    paintCanvas.repaint();
  }
}
