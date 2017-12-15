package model.strategy.paint;

/**
 * Keep an image upright.
 * @author YiqingLu
 * @author HaoyuanYue
 */
import java.awt.Graphics;

import model.ball.Ball;

public class UprightImagePaintStrategy extends ImagePaintStrategy {
	/**
	 * The constructor for the paint strategy
	 * @param filename The file of the image
	 * @param fillFactor The fill factor for the iamge
	 */
	public UprightImagePaintStrategy(String filename, double fillFactor) {
		super(filename, fillFactor);
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
