package model.strategy;

/** 
 * Paint strategy to paint a fish(Fish 2)
 * @author Yiqing Lu
 * @author Ye Wang
 */

import java.awt.geom.AffineTransform;

import model.strategy.shape.Fish2PolygonFactory;

public class Fish2PaintStrategy extends ShapePaintStrategy {

	public Fish2PaintStrategy(AffineTransform at) {
		super(at, Fish2PolygonFactory.Singleton.makeShape(0, 0, 1, 1));
		// TODO Auto-generated constructor stub
	}

	public Fish2PaintStrategy() {
		this(new AffineTransform());
		// TODO Auto-generated constructor stub
	}

}