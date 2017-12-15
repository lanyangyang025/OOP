package model.strategy.paint;

/** 
 * The strategy that makes the shape animated.
 * @author YiqingLu
 * @author HaoyuanYue
 */

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.ball.Ball;

public class AnimatePaintStrategy extends APaintStrategy {
	
	/**
	 * A counter to record the times be called
	 */
	private int count = 0;
	
	/**
	 * An array to store strategy
	 */
	private APaintStrategy[] pstrats;
	
	/**
	 * Constructor for this strategy
	 * @param pstrats Paint strategies
	 */
	public AnimatePaintStrategy(APaintStrategy... pstrats) {
		this(new AffineTransform(), pstrats);
	}
	
	/**
	 * Constructor for this strategy
	 * @param at An affince transform to change the ball
	 * @param pstrats Paint strategies
	 */
	public AnimatePaintStrategy(AffineTransform at, APaintStrategy... pstrats) {
		super(at);
		this.pstrats = pstrats;
	}

	/**
	 * makes the paint strategy update every 5*50 = 250 ms	 
	 * @param g The Graphics object.
	 * @param host The ball object we need to paint.
	 * @param at The affine transform.
	 */

	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		pstrats[count / 5].paintXfrm(g, host, at);
		count++;
		if (count == pstrats.length * 5) {
			count = 0;
		}
	}
}
