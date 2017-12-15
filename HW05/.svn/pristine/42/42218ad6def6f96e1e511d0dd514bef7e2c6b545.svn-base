package model.strategy.paint;

/**
 * A class that will paint a fish which has an eye on the front of the fish.
 * @author YiqingLu
 * @author HaoyuanYue
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.ball.Ball;

public class NiceFishPaintStrategy extends MultiPaintStrategy {
	/**
	 * Constructor for the paint strategy
	 */
	public NiceFishPaintStrategy() {
		this(new AffineTransform());
	}
	
	/**
	 * The paint strategy for the paint strategy
	 * @param at An affine transform object for the strategy
	 */
	public NiceFishPaintStrategy(AffineTransform at) {
		super(at, new Fish2PaintStrategy(at),
				new ColorDecoratoinPaintStrategy(Color.BLACK, new EllipsePaintStrategy(at, -0.4, -0.2, 0.15, 0.15)));
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
	public void paintCfg(Graphics g, Ball host) {
		super.paintCfg(g, host);
		if (Math.abs(Math.atan2(host.getVelocity().y, host.getVelocity().x)) > Math.PI / 2.0) {
			at.scale(1.0, -1.0);
		}
	}
}
