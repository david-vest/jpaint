package model.shapes;

import java.awt.Graphics2D;
import model.interfaces.IBoundingBox;
import model.interfaces.IShape;
import java.awt.Color;
import model.Point;
import model.ShapeType;
import view.draw.SelectionDrawer;
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
  private final ShapeDecorator initialShapeDecorator;
  private final IBoundingBox boundingBox;
  private boolean selected;

  public Shape(IBoundingBox box, Color primary, Color secondary, ShapeType type, DrawStrategy drawStrategy) {
    this.boundingBox = box;
    this.primary = primary;
    this.secondary = secondary;
    this.type = type;
    this.selected = false;
    this.drawStrategy = drawStrategy;
    this.initialShapeDecorator = drawStrategy.getDecorator();
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
  public void draw(Graphics2D graphics2D) {
    drawStrategy.draw(graphics2D, this);
  }

  @Override
  public ShapeDecorator getShapeDecorator() {
    return initialShapeDecorator;
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

  @Override
  public IShape copy() {
    DrawStrategy strategy = drawStrategy.copy();
    strategy.setDecorator(initialShapeDecorator);
    return new Shape(boundingBox.copy(), primary, secondary, type, strategy);
  }

  @Override
  public String toString() {
    return getPrimaryColor().toString() + " " + getShapeType().toString() + " starting at " +
        getStart().toString();
  }
}
