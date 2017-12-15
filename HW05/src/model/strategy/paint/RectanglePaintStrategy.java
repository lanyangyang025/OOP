package model.strategy.paint;

/**
 * A class that will paint a rectangle on the GUI.
 * @author YiqingLu
 * @author HaoyuanYue
 */

import java.awt.geom.AffineTransform;

import model.strategy.paint.shape.RectangleShapeFactory;

public class RectanglePaintStrategy extends ShapePaintStrategy {

	/**
	 * No parameter constructor that creates a rectangle
	 * An AffineTranform for internal use is instantiated.
	 */
	public RectanglePaintStrategy() {
		this(new AffineTransform(), 0, 0, 4.0 / 3.0, 2.0 / 3.0);
	}
	
	/**
	 * Constructor to create a rectangle
	 * @param at An affine transform
	 * @param x The x positon
	 * @param y The y position
	 * @param width The width of the rectangle
	 * @param height The height of the rectangle
	 */
	public RectanglePaintStrategy(AffineTransform at, double x, double y, double width, double height) {
		super(at, RectangleShapeFactory.Singleton.makeShape(x, y, width, height));
	}
}