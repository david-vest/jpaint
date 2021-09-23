package controller;

import controller.commands.CommandHistory;
import controller.commands.CreateShapeCommand;
import controller.interfaces.ICommand;
import java.awt.Point;
import model.MouseMode;
import model.interfaces.UserChoices;
import view.gui.PaintCanvas;

public class CommandController {

  private final PaintCanvas paintCanvas;
  private final UserChoices state;

  public CommandController(UserChoices state, PaintCanvas paintCanvas) {
    this.state = state;
    this.paintCanvas = paintCanvas;
  }

  public void onDraw(Point start, Point end) {
    ICommand command;
    if (state.getActiveMouseMode() == MouseMode.DRAW) {
      command = new CreateShapeCommand(state, paintCanvas, start, end);
      command.execute();
      CommandHistory.add(command);
      paintCanvas.repaint();
    }
  }
}
