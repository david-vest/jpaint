package controller.shapes;

import controller.interfaces.IShape;
import java.awt.Color;
import java.awt.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.UserChoices;

public class Shape implements IShape {

  private UserChoices state;
  private Point start;
  private Point end;
  private ShapeColor primary, secondary;
  private ShapeShadingType shading;

  public Shape(UserChoices state, Point start, Point end) {
    this.state = state;
    this.start = start;
    this.end = end;
    this.primary = state.getActivePrimaryColor();
    this.secondary = state.getActiveSecondaryColor();
    this.shading = state.getActiveShapeShadingType();
  }

  @Override
  public Point getStart() {
    return start;
  }

  @Override
  public Point getEnd() {
    return end;
  }

  @Override
  public Color getPrimaryColor() {
    return primary.get();
  }

  @Override
  public Color getSecondaryColor() {
    return secondary.get();
  }

  @Override
  public ShapeType getShapeType() {
    return null;
  }
}
