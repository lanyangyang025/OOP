package model.strategy.paint;

/**
 * Class that provides default behavior for subclasses that will decorate another IPaintStrategy 
 * to add functionality to that strategy.
 * This class essentially inserts an indirection layer above its decoree, allowing the various methods 
 * to intercept their calls and perform additional behaviors, such as resetting the drawing color so 
 * that something always draws with the same color.  
 * @author YiqingLu
 * @author HaoyuanYue
 */

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.ball.Ball;

public class ADecoratorPaintStrategy extends APaintStrategy {
	/**
	 * A paint strategy
	 */
	public APaintStrategy decoree;
	
	/**
	 * Constructor for this strategy
	 * @param decoree A paint strategy
	 */
	ADecoratorPaintStrategy(APaintStrategy decoree) {
		super(new AffineTransform());
		this.decoree = decoree;
	}
	
	/**
	 * Init the strategy
	 * @param host A ball
	 */
	public void init(Ball host) {
		decoree.init(host);
	}
	
	/**
	 * Paint the ball
	 * @param g A graphics component to draw balls
	 * @param host A ball
	 */
	public void paint(Graphics g, Ball host) {
		decoree.paint(g, host);
	}
	
	/**
	 * Paint the affine transform ball
	 * @param g A graphics component
	 * @param host A ball
	 * @param at A transform to change the ball
	 */
	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		decoree.paintXfrm(g, host, at);
	}
}
