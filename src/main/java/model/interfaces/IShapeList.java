package model.interfaces;

import java.awt.Graphics2D;
import java.util.ArrayList;

public interface IShapeList {
  void add(IShape shape);
  void remove(IShape shape);
  void select(IBoundingBox box);
  ArrayList<IShape> getSelected();
  IShape get(int index);
  ArrayList<IShape> getList();
  void draw(Graphics2D graphics2D);
}
