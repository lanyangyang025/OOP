package model.strategy;

/**
 * a class which would animate a fish. The fish could open its eye and its mouth.
 * @author Yiqing Lu
 * @author Ye Wang
 */

import java.awt.geom.AffineTransform;

public class SwimFishPaintStrategy extends AnimatePaintStrategy {
	public SwimFishPaintStrategy() {
		super(new Fish1PaintStrategy(), new NiceFishPaintStrategy());
	}

	public SwimFishPaintStrategy(AffineTransform at) {
		super(new Fish1PaintStrategy(at), new NiceFishPaintStrategy(at));
	}
}
