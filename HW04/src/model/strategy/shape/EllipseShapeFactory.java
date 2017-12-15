package model.strategy.shape;

/**
 * the factory that stores an ellipse shape.
 * @author Ye Wang
 * @author Yiqing Lu
 */

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class EllipseShapeFactory implements IShapeFactory {

	public static EllipseShapeFactory Singleton = new EllipseShapeFactory();

	private EllipseShapeFactory() {
	}

	@Override
	public Shape makeShape(double x, double y, double xScale, double yScale) {
		// TODO Auto-generated method stub
		return new Ellipse2D.Double(x - xScale, y - yScale, 2 * xScale, 2 * yScale);
	}

}
