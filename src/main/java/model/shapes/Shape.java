package model.shapes;

import java.awt.Graphics2D;
import model.interfaces.IBoundingBox;
import model.interfaces.IShape;
import java.awt.Color;
import model.Point;
import model.ShapeColor;
import model.ShapeType;
import model.interfaces.UserChoices;
import view.draw.EllipseDrawer;
import view.draw.RectangleDrawer;
import view.draw.SelectionDrawer;
import view.draw.TriangleDrawer;
import view.interfaces.DrawStrategy;
import view.interfaces.ShapeDecorator;

/**
 * @see model.interfaces.IShape
 */

public class Shape implements IShape {

  private final Color primary;
  private final Color secondary;
  private final ShapeType type;
  private final DrawStrategy drawStrategy;
  private ShapeDecorator initialShapeDecorator;
  private IBoundingBox boundingBox;
  private boolean selected;

  public Shape(IBoundingBox box, Color primary, Color secondary, ShapeType type, DrawStrategy strategy) {
    this.boundingBox = box;
    this.primary = primary;
    this.secondary = secondary;
    this.type = type;
    this.selected = false;
    this.drawStrategy = strategy;
    this.initialShapeDecorator = strategy.getDecorator();
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
    return primary;
  }

  @Override
  public Color getSecondaryColor() {
    return secondary;
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

    if (selected) {
      drawStrategy.setDecorator(new SelectionDrawer(drawStrategy.getDecorator()));
    }
    else {
      drawStrategy.setDecorator(initialShapeDecorator);
    }
  }

  @Override
  public void move(int x, int y) {
    boundingBox.move(x, y);
  }

  @Override
  public final IBoundingBox getBBox(){
    return boundingBox;
  }
}
