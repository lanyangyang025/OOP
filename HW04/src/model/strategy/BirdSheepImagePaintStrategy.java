package model.strategy;

/**
 * A class paints one of the two images on the GUI randomly. Each image has 50% chance to be chosen.
 * @author Yiqing Lu
 * @author Ye Wang
 */

public class BirdSheepImagePaintStrategy extends ImagePaintStrategy {

	public BirdSheepImagePaintStrategy() {
		super(Math.random() < 0.5 ? "images/sheep_animate.gif" : "images/humbird_animate.gif", 0.5);
		// TODO Auto-generated constructor stub
	}

}
