package model.strategy.paint.shape;

import java.awt.Rectangle;
import java.awt.Shape;

/**
 * The factory that stores a rectangle shape.
 * @author HaoyuanYue
 * @author YiqingLu
 */
public class RectangleShapeFactory implements IShapeFactory {
	/**
	 * A static factory for later using
	 */
	public static RectangleShapeFactory Singleton = new RectangleShapeFactory();
	
	/**
	 * The constructor for the factory
	 */
	private RectangleShapeFactory() { }
	
	/**
	 * Make shape
	 * @param x The x position
	 * @param y The y position
	 * @param xScale The scale of the x
	 * @param yScale The scale of the y
	 */	
	@Override
	public Shape makeShape(double x, double y, double xScale, double yScale) {
		return new Rectangle.Double(x - xScale, y - yScale, 2 * xScale, 2 * yScale);
	}

}
