package model.strategy.paint;

import java.awt.Shape;
import java.awt.geom.AffineTransform;

import model.ball.Ball;

import java.awt.Graphics;
/**
 * Keep a shape upright.
 * @author YiqingLu
 * @author HaoyuanYue
 */

public class UprightShapePaintStrategy extends ShapePaintStrategy {
	/**
	 * Constructor for the paint strategy
	 * @param shape The shape of the painting
	 */
	public UprightShapePaintStrategy(Shape shape) {
		super(shape);
	}
	
	/**
	 * Constructor for the paint strategy
	 * @param at An affine transform for the strategy
	 * @param shape The shape of the painting
	 */
	public UprightShapePaintStrategy(AffineTransform at, Shape shape) {
		super(at, shape);
		
	}
	/**
	 * The paintCfg method is set to be a concrete no-op that the subclasses may or may not override. 
	 * This method allows the subclass to inject additional processing into the paint method process before 
	 * the final transformations are performed.     
	 * Since this method is "protected", it is only available for use by the subclasses and not other types 
	 * of objects.
	 * @param g The Graphics object.
	 * @param host The ball object we need to paint.
	 */
	protected void paintCfg(Graphics g, Ball host) {
		super.paintCfg(g, host);
		if (Math.abs(Math.atan2(host.getVelocity().y, host.getVelocity().x)) > Math.PI / 2.0) {
			//host.getVelocity().x = -host.getVelocity().x;
			at.scale(1.0, -1.0);
		}
	}
}
