package controller.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import controller.interfaces.IShape;
import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.UserChoices;

public class Rectangle implements IShape {

  private UserChoices state;
  private Point start;
  private Point end;
  private ShapeColor primary, secondary;
  private ShapeShadingType shading;

  public Rectangle(UserChoices state, Point start, Point end) {
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
}