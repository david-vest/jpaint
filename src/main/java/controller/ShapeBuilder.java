package controller;

import java.awt.Color;
import javax.swing.border.Border;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IBoundingBox;
import model.interfaces.IShape;
import model.shapes.BoundingBox;
import model.shapes.Shape;
import view.draw.BorderDrawer;
import view.draw.EllipseDrawer;
import view.draw.FillDrawer;
import view.draw.RectangleDrawer;
import view.draw.TriangleDrawer;
import view.interfaces.DrawStrategy;
import view.interfaces.ShapeDecorator;

public class ShapeBuilder {
  private Color primaryColor;
  private Color secondaryColor;
  private ShapeShadingType shadingType;
  private ShapeDecorator shapeDecorator;
  private ShapeType type;
  private IBoundingBox bbox;


  public ShapeBuilder setFillColor(Color color) {
    this.primaryColor = color;
    return this;
  }

  public ShapeBuilder setBorderColor(Color color) {
    this.secondaryColor = color;
    return this;
  }

  public ShapeBuilder setShadingType(ShapeShadingType shadingType) {
    this.shadingType = shadingType;
    return this;
  }

  public ShapeBuilder setShapeType(ShapeType type) {
    this.type = type;
    return this;
  }

  public ShapeBuilder setBBox(IBoundingBox bbox) {
    this.bbox = bbox;
    return this;
  }

  /**Optional */
  public ShapeBuilder setDecorator(ShapeDecorator decorator) {
    this.shapeDecorator = decorator;
    return this;
  }

  private ShapeDecorator getShapeDecorator() {
    if (shapeDecorator == null) {
      switch (shadingType) {
        case FILLED_IN:
          return new FillDrawer();
        case OUTLINE:
          return new BorderDrawer();
        case OUTLINE_AND_FILLED_IN:
          return new BorderDrawer(new FillDrawer());
        default:
          throw new IllegalStateException("No shading type");
      }
    }
    return shapeDecorator;
  }

  private DrawStrategy getDrawStrategy() {
    switch (type) {
      case RECTANGLE:
        return new RectangleDrawer(shapeDecorator);
      case ELLIPSE:
        return new EllipseDrawer(shapeDecorator);
      case TRIANGLE:
        return new TriangleDrawer(shapeDecorator);
      default:
        throw new IllegalArgumentException("No shape type");
    }
  }

  public IShape build() {
    DrawStrategy drawStrategy;
      shapeDecorator = getShapeDecorator();
      drawStrategy = getDrawStrategy();

      return new Shape(bbox, primaryColor, secondaryColor, type, drawStrategy);
    }
}
