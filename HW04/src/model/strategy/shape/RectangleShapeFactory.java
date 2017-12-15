package model.strategy.shape;

/**
 * the factory that stores a rectangle shape.
 * @author Ye Wang
 * @author Yiqing Lu
 */

import java.awt.Rectangle;
import java.awt.Shape;

public class RectangleShapeFactory implements IShapeFactory {

	public static RectangleShapeFactory Singleton = new RectangleShapeFactory();

	private RectangleShapeFactory() {
	}

	@Override
	public Shape makeShape(double x, double y, double xScale, double yScale) {
		// TODO Auto-generated method stub
		return new Rectangle.Double(x - xScale, y - yScale, 2 * xScale, 2 * yScale);
	}

}
