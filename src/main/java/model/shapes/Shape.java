package model.shapes;

import model.interfaces.IShape;
import java.awt.Color;
import java.awt.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.UserChoices;

/**
 * @see model.interfaces.IShape
 */

public class Shape implements IShape {

  private final UserChoices state;
  private final Point start;
  private final Point end;
  private final ShapeColor primary;
  private final ShapeColor secondary;
  private final ShapeShadingType shading;

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
