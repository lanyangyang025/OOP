package model.strategy.paint.shape;

/**
 * The factory that stores a polygon shape.
 * @author HaoyuanYue
 * @author YiqingLu
 */

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

public class PolygonFactory implements IShapeFactory {
	/**
	 * The polygon object for the shape
	 */
	private Polygon poly = new Polygon();
	
	/**
	 * The affine transform for the shape
	 */
	private AffineTransform at = new AffineTransform();
	
	/**
	 * The scale factor for the shape
	 */
	private double scaleFactor = 1.0;
	
	/**
	 * Constructor for the factory
	 * @param at An affine transform for the shape
	 * @param scaleFactor A scale factor for the shape
	 * @param pts The points of the shape
	 */
	public PolygonFactory(AffineTransform at, double scaleFactor, Point... pts) {
		this.at = at;
		this.scaleFactor = scaleFactor;
		for (Point pt : pts) {
			poly.addPoint(pt.x, pt.y);
		}
	}
	
	/**
	 * Make shape
	 */
	@Override
	public Shape makeShape(double x, double y, double xScale, double yScale) {
		// TODO Auto-generated method stub
		at.setToTranslation(x, y);
		at.scale(xScale * scaleFactor, yScale * scaleFactor); // optional rotation can be added as well
		return at.createTransformedShape(poly);
	}

}
