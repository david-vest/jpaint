package model.shapes;

import java.awt.Graphics2D;
import model.BoundingBox;
import model.interfaces.IBoundingBox;
import model.interfaces.IShape;
import java.awt.Color;
import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.UserChoices;
import view.interfaces.DrawStrategy;

/**
 * @see model.interfaces.IShape
 */

public abstract class Shape implements IShape {

  private Point start;
  private Point end;
  private final ShapeColor primary;
  private final ShapeColor secondary;
  private final ShapeShadingType shading;
  private final ShapeType type;
  protected DrawStrategy drawStrategy;
  private BoundingBox boundingBox;
  private boolean selected;

  public Shape(UserChoices state, Point start, Point end) {
    Point[] points = Point.normalizePoints(start, end);
    this.start = points[0];
    this.end = points[1];
    this.primary = state.getActivePrimaryColor();
    this.secondary = state.getActiveSecondaryColor();
    this.shading = state.getActiveShapeShadingType();
    this.type = state.getActiveShapeType();
    this.selected = false;

    this.boundingBox = new BoundingBox(this.start, this.end);
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

    return end.getX() - start.getX();
  }

  @Override
  public int getHeight() {

    return end.getY() - start.getY();
  }

  @Override
  public void normalizePoints() {
    int x1 = Math.min(start.getX(), end.getX());
    int x2 = Math.max(start.getX(), end.getX());
    int y1 = Math.min(start.getY(), end.getY());
    int y2 = Math.max(start.getY(), end.getY());

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

  @Override
  public boolean isSelected() {
    return selected;
  }

  @Override
  public void setSelected(boolean isSelected) {
    this.selected = isSelected;
  }

  @Override
  public IBoundingBox getBBox(){
    return boundingBox;
  }
}
