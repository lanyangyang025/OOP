package model.strategy.paint;

/** 
 * Paint strategy to paint a fish(Fish 2)
 * @author Yiqing Lu
 * @author Ye Wang
 */

import java.awt.geom.AffineTransform;

import model.strategy.paint.shape.Fish2PolygonFactory;

public class Fish2PaintStrategy extends ShapePaintStrategy {
	/**
	 * The constructor for this strategy with affine transform
	 * @param at An affine transform
	 */
	public Fish2PaintStrategy(AffineTransform at) {
		super(at, Fish2PolygonFactory.Singleton.makeShape(0, 0, 1, 1));
	}
	
	/**
	 * The constructor for this strategy
	 */
	public Fish2PaintStrategy() {
		this(new AffineTransform());
	}

}