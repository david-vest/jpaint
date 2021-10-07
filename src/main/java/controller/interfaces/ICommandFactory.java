package controller.interfaces;


import model.Point;

public interface ICommandFactory {
  ICommand makeDrawCommand(Point start, Point end);
}
