package model.commands;

import controller.Clipboard;
import controller.command.CommandHistory;
import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.interfaces.IShape;
import model.shapes.ShapeList;

public class PasteShapesCommand implements ICommand, Undoable {

  private final ArrayList<IShape> pasted;
  private final ShapeList shapeList;
  private final Clipboard clipboard;

  private final int OFFSET = 10;

  public PasteShapesCommand(ShapeList shapeList, Clipboard clipboard) {
    this.shapeList = shapeList;
    this.clipboard = clipboard;
    this.pasted = new ArrayList<>();
  }

  @Override
  public void execute() {
    clipboard.getClipboard().forEach(s -> {
      IShape newShape = s.copy();
      newShape.move(OFFSET, OFFSET);
      newShape.setSelected(true);
      shapeList.add(newShape);
      pasted.add(newShape);
    });

    CommandHistory.add(this);
  }

  @Override
  public void undo() {
    pasted.forEach(shapeList::remove);
  }

  @Override
  public void redo() {
   pasted.forEach(shapeList::add);
  }
}
