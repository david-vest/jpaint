package model.commands;

import controller.ShapeBuilder;
import java.awt.Color;
import model.interfaces.IBoundingBox;
import model.shapes.ShapeList;
import controller.command.CommandHistory;
import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import model.interfaces.IShape;
import model.interfaces.UserChoices;

/**
 * CreateShapeCommand gets a shape instance and renders the shape.
 */

public class CreateShapeCommand implements ICommand, Undoable {

  private final ShapeList shapeList;
  private final UserChoices state;
  private final IBoundingBox bbox;
  private IShape shape;

  public CreateShapeCommand(UserChoices state, ShapeList shapeList, IBoundingBox box){
    this.state = state;
    this.shapeList = shapeList;
    this.bbox = box;
    this.shape = null;
    this.bbox.normalize();
  }

  @Override
  public void execute() {
    ShapeBuilder shapeBuilder = new ShapeBuilder();
    Color primaryColor = state.getActivePrimaryColor().get();
    Color secondaryColor = state.getActiveSecondaryColor().get();
    shapeBuilder
        .setBBox(bbox)
            .setFillColor(primaryColor)
                .setBorderColor(secondaryColor)
                    .setShapeType(state.getActiveShapeType())
                        .setShadingType(state.getActiveShapeShadingType());

    shape = shapeBuilder.build();
    shapeList.add(shape);
    CommandHistory.add(this);
  }

  @Override
  public void undo() {
    shapeList.remove(shape);
  }

  @Override
  public void redo() {
    shapeList.add(shape);
  }
}
