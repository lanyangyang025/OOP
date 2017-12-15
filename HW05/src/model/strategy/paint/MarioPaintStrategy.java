package model.strategy.paint;

/**
 * A class that will paint an image on the GUI and keep it on the right.
 * @author YiqingLu
 * @author HaoyuanYue
 */

public class MarioPaintStrategy extends UprightImagePaintStrategy {
	/**
	 * Constructor for this strategy
	 */
	public MarioPaintStrategy() {
		super("images/Mario_animate.gif", 0.5);
	}
}
