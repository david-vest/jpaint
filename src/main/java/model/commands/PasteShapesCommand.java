package model.commands;

import controller.ShapeBuilder;
import controller.command.CommandHistory;
import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.Point;
import model.interfaces.IBoundingBox;
import model.interfaces.IShape;
import model.shapes.BoundingBox;
import model.shapes.ShapeList;

public class PasteShapesCommand implements ICommand, Undoable {

  private final ArrayList<IShape> clipboard;
  private final ArrayList<IShape> pasted;
  private final ShapeList shapeList;

  public PasteShapesCommand(ShapeList shapeList) {
    this.shapeList = shapeList;
    this.clipboard = shapeList.getClipboard();
    this.pasted = new ArrayList<>();
  }

  @Override
  public void execute() {
    for (IShape s : clipboard) {
      System.out.println("Pasting: " + s);
      ShapeBuilder builder = new ShapeBuilder();
      Point start = new Point(s.getStart().getX() + 10, s.getStart().getY() + 10);
      Point end = new Point(s.getEnd().getX() + 10, s.getEnd().getY() + 10);
      IBoundingBox bbox = new BoundingBox(start, end);

      builder.setBBox(bbox).setFillColor(s.getPrimaryColor()).setBorderColor(s.getSecondaryColor())
          .setDecorator(s.getShapeDecorator()).setShapeType(s.getShapeType());

      IShape shape = builder.build();
      shape.setSelected(true);
      shapeList.add(shape);
      pasted.add(shape);
    }

    CommandHistory.add(this);
  }

  @Override
  public void undo() {
    for(IShape s : pasted){
      shapeList.remove(s);
    }
  }

  @Override
  public void redo() {
    for (IShape s : pasted) {
      shapeList.add(s);
    }
  }
}
