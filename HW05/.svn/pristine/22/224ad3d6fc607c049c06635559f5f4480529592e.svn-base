package model.strategy.paint;

/**
 * A class which would animate a fish. The fish could open its eye and its mouth.
 * @author YiqingLu
 * @author HaoyuanYue
 */

import java.awt.geom.AffineTransform;

public class SwimFishPaintStrategy extends AnimatePaintStrategy {
	/**
	 * Constructor for this paint strategy
	 */
	public SwimFishPaintStrategy() {
		super(new Fish1PaintStrategy(), new NiceFishPaintStrategy());
	}
	/**
	 * Constructor for this strategy
	 * @param at An affine transform for the paint strategy
	 */
	public SwimFishPaintStrategy(AffineTransform at) {
		super(new Fish1PaintStrategy(at), new NiceFishPaintStrategy(at));
	}
}
