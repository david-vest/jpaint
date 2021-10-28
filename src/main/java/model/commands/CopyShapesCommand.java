package model.commands;

import controller.interfaces.ICommand;
import model.shapes.ShapeList;

public class CopyShapesCommand implements ICommand {

  private final ShapeList shapeList;

  public CopyShapesCommand(ShapeList shapeList) {
    this.shapeList = shapeList;
  }

  @Override
  public void execute() {
    shapeList.copySelected();
  }
}
