package controller.interfaces;

import java.awt.Point;

public interface ICommandFactory {
  ICommand makeDrawCommand(Point start, Point end);
}
