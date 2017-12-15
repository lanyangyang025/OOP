package model.strategy.paint.shape;

/**
 * The factory that stores an ellipse shape.
 * @author HaoyuanYue
 * @author YiqingLu
 */

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class EllipseShapeFactory implements IShapeFactory {
	/**
	 * A static factory for later using
	 */
	public static EllipseShapeFactory Singleton = new EllipseShapeFactory();
	
	/**
	 * The constructor for the factory
	 */
	private EllipseShapeFactory() { }
	
	/**
	 * Make shape
	 * @param x The x position
	 * @param y The y position
	 * @param xScale The scale of the x
	 * @param yScale The scale of the y
	 */
	@Override
	public Shape makeShape(double x, double y, double xScale, double yScale) {
		return new Ellipse2D.Double(x - xScale, y - yScale, 2 * xScale, 2 * yScale);
	}

}
