package model.strategy.paint;

/**
 * A class paints one of the two images on the GUI randomly. Each image has 50% chance to be chosen.
 * @author YiqingLu
 * @author HaoyuanYue
 */

public class BirdSheepImagePaintStrategy extends ImagePaintStrategy {
	/**
	 * Constructor for this strategy
	 */
	public BirdSheepImagePaintStrategy() {
		super(Math.random() < 0.5 ? "images/sheep_animate.gif" : "images/humbird_animate.gif", 0.5);
	}

}
