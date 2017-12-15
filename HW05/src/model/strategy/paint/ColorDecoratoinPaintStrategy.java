package model.strategy.paint;

/**
 * A class which could paint a shape with a different color and the same affine transform.
 * @author YiqingLu
 * @author HaoyuanYue
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.ball.Ball;

public class ColorDecoratoinPaintStrategy extends ADecoratorPaintStrategy {
	/**
	 * A color object to the set the color of the ball
	 */
	private Color color;
	
	/**
	 * The constructor for this strategy
	 * @param color A color
	 * @param strategy A paint strategy
	 */
	public ColorDecoratoinPaintStrategy(Color color, APaintStrategy strategy) {
		super(strategy);
		this.color = color;
	}
	
	/**
	 * makes the paint strategy update every 5*50 = 250 ms	 
	 * @param g The Graphics object.
	 * @param host The ball object we need to paint.
	 * @param at The affine transform.
	 */
	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		g.setColor(color);
		super.paintXfrm(g, host, at);
	}

}
