package model.interfaces;

public interface IShapeList {
  void add(IShape shape);
  void remove(IShape shape);
  int size();
  IShape get(int index);
}
