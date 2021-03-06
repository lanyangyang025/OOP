package model.strategy;

/** 
 * Paint strategy to paint a fish(Fish 1)
 * @author Yiqing Lu
 * @author Ye Wang
 */

import java.awt.geom.AffineTransform;

import model.strategy.shape.Fish1PolygonFactory;

public class Fish1PaintStrategy extends ShapePaintStrategy {

	public Fish1PaintStrategy(AffineTransform at) {
		super(at, Fish1PolygonFactory.Singleton.makeShape(0, 0, 1, 1));
		// TODO Auto-generated constructor stub
	}

	public Fish1PaintStrategy() {
		this(new AffineTransform());
		// TODO Auto-generated constructor stub
	}

}
