package model.strategy.paint;

/**
 * This class provides the basic affine transform services that its subclasses 
 * will use to resize, translate and rotate their prototype images into their 
 * proper current locations and orientations on the screen.    
 * This class is designed to be the root class for all strategies that use affine 
 * transforms to create their visual representations.
 * @author Yiqing Lu
 * @author HaoyuanYue
 */

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.ball.Ball;

public class APaintStrategy implements IPaintStrategy {
	/**
	 * An AffineTransform to change the ball
	 */
	protected AffineTransform at = new AffineTransform();
	
	/**
	 * Init the strategy
	 * @param host A ball
	 */
	@Override
	public void init(Ball host) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Constructor for the paint strategy
	 * @param at An affine transform to change the ball
	 */
	public APaintStrategy(AffineTransform at) {
		this.at = at;
	}

	/**
	 * This Template Design Pattern method sets up AffineTransform object to translate, 
	 * scale and rotate based on the the ball's current position, radius and velocity.   
	 * It then delegates  to two other methods to finish the job, the paintCfg method to 
	 * finish any further refinements of the affine transform and the paintXfrm method to 
	 * actually perform the painting.
	 * @param g A graphics to draw balls
	 * @param host A ball 
	 */

	@Override
	public void paint(Graphics g, Ball host) {
		double scale = host.getRadius();
		at.setToTranslation(host.getLoc().x, host.getLoc().y);
		at.scale(scale, scale);
		at.rotate(host.getVelocity().x, host.getVelocity().y);
		g.setColor(host.getColor());
		paintCfg(g, host);
		paintXfrm(g, host, at);
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
	protected void paintCfg(Graphics g, Ball host) { }

	/**
	 * A secondary paint operation that is the last step of the above paint method, which does not calculate 
	 * its own affine transform, but instead, uses a supplied affine transform. 
	 * @param g The Graphics object.
	 * @param host The ball object we need to paint.
	 * @param at the affine transform.
	 */

	protected void paintXfrm(Graphics g, Ball host, AffineTransform at) { }

	/**
	 * getter method of the ball's affine transform
	 * @return the current ball's affine transform
	 */
	protected AffineTransform getAT() {
		return this.at;
	}

}
