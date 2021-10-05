package model.shapes;

import java.awt.Graphics2D;
import model.interfaces.IShape;
import java.awt.Color;
import java.awt.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.UserChoices;
import view.interfaces.DrawStrategy;

/**
 * @see model.interfaces.IShape
 */

public class Shape implements IShape {

  private Point start;
  private Point end;
  private final ShapeColor primary;
  private final ShapeColor secondary;
  private final ShapeShadingType shading;
  private final ShapeType type;
  protected DrawStrategy drawStrategy;

  public Shape(UserChoices state, Point start, Point end) {
    this.start = start;
    this.end = end;
    this.primary = state.getActivePrimaryColor();
    this.secondary = state.getActiveSecondaryColor();
    this.shading = state.getActiveShapeShadingType();
    this.type = state.getActiveShapeType();
    normalizePoints();
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
  public ShapeType getShapeType() { return type; }

  @Override
  public int getWidth() {

    return end.x - start.x;
  }

  @Override
  public int getHeight() {

    return end.y - start.y;
  }

  @Override
  public void normalizePoints() {
    int x1 = Math.min(start.x, end.x);
    int x2 = Math.max(start.x, end.x);
    int y1 = Math.min(start.y, end.y);
    int y2 = Math.max(start.y, end.y);

    start = new Point(x1, y1);
    end = new Point(x2, y2);
  }

  @Override
  public void setStart(Point p) {
    this.start = p;
  }

  @Override
  public void setEnd(Point p) {
    this.end = p;
  }

  @Override
  public void draw(Graphics2D graphics2D) {
  }
}
