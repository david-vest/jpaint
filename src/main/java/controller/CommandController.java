package controller;

import controller.commands.CommandHistory;
import controller.commands.CreateShapeCommand;
import controller.interfaces.ICommand;
import controller.shapes.ShapeRenderer;
import java.awt.Point;
import model.MouseMode;
import model.interfaces.UserChoices;
import view.gui.PaintCanvas;

public class CommandController {

  private final PaintCanvas paintCanvas;
  private final UserChoices state;
  private final ShapeRenderer renderer;

  public CommandController(UserChoices state, PaintCanvas paintCanvas, ShapeRenderer renderer) {
    this.state = state;
    this.paintCanvas = paintCanvas;
    this.renderer = renderer;
  }

  public void onDraw(Point start, Point end) {
    ICommand command;
    if (state.getActiveMouseMode() == MouseMode.DRAW) {
      command = new CreateShapeCommand(state, renderer, start, end);
      command.execute();
      paintCanvas.repaint();
    }
  }
}
