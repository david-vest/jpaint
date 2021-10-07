package model.interfaces;

import java.util.function.Consumer;

public interface IShapeList {
  void add(IShape shape);
  void remove(IShape shape);
  int size();
  IShape get(int index);
}
