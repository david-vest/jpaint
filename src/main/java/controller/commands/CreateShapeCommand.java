package controller.commands;

import controller.ShapeList;
import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import controller.shapes.ShapeRenderer;
import java.awt.Point;
import controller.interfaces.IShape;
import model.interfaces.UserChoices;
import controller.shapes.ShapeFactory;
import view.gui.PaintCanvas;

public class CreateShapeCommand implements ICommand, Undoable {

  private final PaintCanvas paintCanvas;
  private final ShapeList shapeList;
  private final UserChoices state;
  private final Point start;
  private final Point end;
  private final ShapeRenderer renderer;

  public CreateShapeCommand(UserChoices state, ShapeRenderer renderer, ShapeList shapeList, PaintCanvas paintCanvas, Point start, Point end){
    this.state = state;
    this.renderer = renderer;
    this.shapeList = shapeList;
    this.paintCanvas = paintCanvas;
    this.start = start;
    this.end = end;
  }

  @Override
  public void execute() {
    IShape shape = ShapeFactory.createShape(state, start, end);
    renderer.renderShape(shape, paintCanvas.getGraphics2D());
    shapeList.add(shape);
    CommandHistory.add(this);
  }

  @Override
  public void undo() {

  }

  @Override
  public void redo() {

  }
}
