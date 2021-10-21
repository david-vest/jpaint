package model.commands;

import controller.interfaces.ICommand;
import model.interfaces.IBoundingBox;
import model.interfaces.IShapeList;

/**
 * SelectShapesCommand is an ICommand that selects each shape that collides with the drawn BoundingBox
 * and marks the IShape's "selected" field to true
 */

public class SelectShapesCommand implements ICommand {

  private final IBoundingBox box;
  private final IShapeList shapeList;

  public SelectShapesCommand(IShapeList shapeList, IBoundingBox box) {
    this.box = box;
    this.shapeList = shapeList;
    this.box.normalize();
  }

  @Override
  public void execute() { shapeList.select(box); }
}
