package model.strategy.paint;

/** 
 * Paint strategy to paint a fish(Fish 1)
 * @author YiqingLu
 * @author HaoyuanYue
 */

import java.awt.geom.AffineTransform;

import model.strategy.paint.shape.Fish1PolygonFactory;

public class Fish1PaintStrategy extends ShapePaintStrategy {
	
	/**
	 * The constructor for this strategy with affine transform
	 * @param at An affine transform
	 */
	public Fish1PaintStrategy(AffineTransform at) {
		super(at, Fish1PolygonFactory.Singleton.makeShape(0, 0, 1, 1));
	}
	
	/**
	 * The constructor for this strategy
	 */
	public Fish1PaintStrategy() {
		this(new AffineTransform());
	}

}
