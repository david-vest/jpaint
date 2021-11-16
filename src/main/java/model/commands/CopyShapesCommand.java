package model.commands;

import controller.Clipboard;
import controller.interfaces.ICommand;
import model.shapes.ShapeList;

public class CopyShapesCommand implements ICommand {

  private final ShapeList shapeList;
  private final Clipboard clipboard;

  public CopyShapesCommand(ShapeList shapeList, Clipboard clipboard) {
    this.shapeList = shapeList;
    this.clipboard = clipboard;
  }

  @Override
  public void execute() {
    clipboard.clear();
    shapeList.getSelected().forEach(clipboard::add);
  }
}
