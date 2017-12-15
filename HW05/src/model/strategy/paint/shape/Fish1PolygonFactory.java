package model.strategy.paint.shape;

/**
 * The factory that stores a fish1(polygon) shape.
 * @author HaoyuanYue
 * @author Yiqing Lu
 */

import java.awt.Point;
import java.awt.geom.AffineTransform;

public class Fish1PolygonFactory extends PolygonFactory {
	/**
	 * A static factory for later using
	 */
	public static Fish1PolygonFactory Singleton = new Fish1PolygonFactory();

	/**
	 * The constructor for the factory
	 */
	private Fish1PolygonFactory() {
		super(new AffineTransform(), 0.1, new Point(0, 0), new Point(-2, 2), new Point(-6, 3), new Point(-10, 2),
				new Point(-12, 0), new Point(-15, 3), new Point(-15, -3), new Point(-12, 0), new Point(-10, -2),
				new Point(-6, -3), new Point(-2, -2), new Point(0, 0));
	}

}
