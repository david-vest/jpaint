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

  public IShape build() {
    ShapeDecorator shapeDecorator;
    DrawStrategy drawStrategy;

    switch (shadingType) {
      case FILLED_IN:
        shapeDecorator = new FillDrawer();
        break;
      case OUTLINE:
        shapeDecorator = new BorderDrawer();
        break;
      case OUTLINE_AND_FILLED_IN:
        shapeDecorator = new BorderDrawer(new FillDrawer());
        break;
      default:
        throw new IllegalArgumentException("No shading type");
    }

    switch(type) {
      case RECTANGLE:
        drawStrategy = new RectangleDrawer(shapeDecorator);
        break;
      case ELLIPSE:
        drawStrategy = new EllipseDrawer(shapeDecorator);
        break;
      case TRIANGLE:
        drawStrategy = new TriangleDrawer(shapeDecorator);
        break;
      default:
        throw new IllegalArgumentException("No shape type");
    }

    return new Shape(bbox, primaryColor, secondaryColor, type, drawStrategy);
  }

}
