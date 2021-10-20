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
import view.draw.EllipseDrawer;
import view.draw.RectangleDrawer;
import view.draw.TriangleDrawer;
import view.interfaces.DrawStrategy;

/**
 * @see model.interfaces.IShape
 */

public class Shape implements IShape {

  private final ShapeColor primary;
  private final ShapeColor secondary;
  private final ShapeType type;
  private final DrawStrategy drawStrategy;
  private final IBoundingBox boundingBox;
  private boolean selected;

  public Shape(UserChoices state, IBoundingBox box) {
    this.boundingBox = box;
    this.primary = state.getActivePrimaryColor();
    this.secondary = state.getActiveSecondaryColor();
    this.type = state.getActiveShapeType();
    this.selected = false;
    this.drawStrategy = getStrategy();
  }

  @Override
  public Point getStart() {
    return boundingBox.getStart();
  }

  @Override
  public Point getEnd() {
    return boundingBox.getEnd();
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
  public final ShapeType getShapeType() { return type; }

  @Override
  public int getWidth() {

    return this.getEnd().getX() - this.getStart().getX();
  }

  @Override
  public int getHeight() {
    return this.getEnd().getY() - this.getStart().getY();
  }

  @Override
  public void setStart(Point p) {
    this.boundingBox.setStart(p);
  }

  @Override
  public void setEnd(Point p) {
    this.boundingBox.setEnd(p);
  }

  @Override
  public DrawStrategy getStrategy() {
    switch (type) {
      case RECTANGLE:
        return new RectangleDrawer();
      case ELLIPSE:
        return new EllipseDrawer();
      case TRIANGLE:
        return new TriangleDrawer();
    }
    return null;
  }

  @Override
  public void draw(Graphics2D graphics2D) {
    drawStrategy.draw(graphics2D, this);
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
  public final IBoundingBox getBBox(){
    return boundingBox;
  }
}
