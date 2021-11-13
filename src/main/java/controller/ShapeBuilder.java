package controller;

import java.awt.Color;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IBoundingBox;
import model.interfaces.IShape;
import model.shapes.Shape;
import view.draw.BorderDrawer;
import view.draw.FillDrawer;
import view.draw.ShapeDrawer;
import view.interfaces.DrawStrategy;
import view.interfaces.ShapeDecorator;

/**
 * ShapeBuilder follows the builder design pattern to create Shapes
 */

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

  public IShape build() {
    shapeDecorator = getShapeDecorator();
    DrawStrategy drawStrategy = new ShapeDrawer(shapeDecorator);

    return new Shape(bbox, primaryColor, secondaryColor, type, drawStrategy);
  }
}
