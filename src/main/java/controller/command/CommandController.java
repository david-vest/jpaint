package controller.command;

import controller.Clipboard;
import model.Point;
import controller.interfaces.ICommand;
import model.interfaces.UserChoices;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

/**
 * CommandController communicates with MouseHandler and PaintCanvas to execute commands created by
 * CommandFactory
 */

public class CommandController {

  private final UserChoices state;
  private final ShapeList shapeList;
  private final PaintCanvas paintCanvas;
  private final Clipboard clipboard;

  public CommandController(UserChoices state, ShapeList shapeList, PaintCanvas paintCanvas, Clipboard clipboard) {
    this.state = state;
    this.shapeList = shapeList;
    this.paintCanvas = paintCanvas;
    this.clipboard = clipboard;
  }

  public void onDraw(Point start, Point end) {
    ICommand command = CommandFactory.makeDrawCommand(state, shapeList, start, end);
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
    ICommand command = CommandFactory.makeCopyCommand(shapeList, clipboard);
    command.execute();
  }

  public void onPaste() {
    ICommand command = CommandFactory.makePasteCommand(shapeList, clipboard);
    command.execute();
    paintCanvas.repaint();
  }

  public void onDelete() {
    ICommand command = CommandFactory.makeDeleteCommand(shapeList);
    command.execute();
    paintCanvas.repaint();
  }
}
