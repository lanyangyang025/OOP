package model.strategy.paint.shape;

/**
 * The factory that stores a fish2(polygon) shape.
 * @author HaoyuanYue
 * @author Yiqing Lu
 */

import java.awt.Point;
import java.awt.geom.AffineTransform;

public class Fish2PolygonFactory extends PolygonFactory {
	/**
	 * A static factory for later using
	 */
	public static Fish2PolygonFactory Singleton = new Fish2PolygonFactory();
	
	/**
	 * The constructor for the factory
	 */
	private Fish2PolygonFactory() {
		super(new AffineTransform(), 0.07, new Point(-2, 0), new Point(0, 2), new Point(-6, 4), new Point(-10, 5),
				new Point(-14, 4), new Point(-20, 0), new Point(-25, 5), new Point(-25, -5), new Point(-20, 0),
				new Point(-14, -4), new Point(-10, -5), new Point(-6, -4), new Point(0, -2), new Point(-2, 0));
	}

}
