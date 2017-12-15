package model.strategy;

/** 
 * The strategy that makes the shape animated.
 * @author Yiqing Lu
 * @author Ye Wang
 */

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import ball.Ball;

public class AnimatePaintStrategy extends APaintStrategy {

	int count = 0;
	APaintStrategy[] pstrats;

	public AnimatePaintStrategy(APaintStrategy... pstrats) {
		this(new AffineTransform(), pstrats);
		// TODO Auto-generated constructor stub
	}

	public AnimatePaintStrategy(AffineTransform at, APaintStrategy... pstrats) {
		super(at);
		// TODO Auto-generated constructor stub
		this.pstrats = pstrats;
	}

	/**
	 * makes the paint strategy update every 5*50 = 250 ms	 
	 * @param g The Graphics object.
	 * @param host The ball object we need to paint.
	 * @param at the affine transform.
	 */

	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		pstrats[count / 5].paintXfrm(g, host, at);
		count++;
		if (count == pstrats.length * 5) {
			count = 0;
		}
	}
}
