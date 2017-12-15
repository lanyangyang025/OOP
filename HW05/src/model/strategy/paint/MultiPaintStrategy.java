package model.strategy.paint;

/**
 * A class that could load many paint strategies.
 * @author YiqingLu
 * @author HaoyuanYue
 */

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.ball.Ball;

public class MultiPaintStrategy extends APaintStrategy {
	
	/**
	 * An array to store the paint strategies
	 */
	private APaintStrategy[] pstrats;
	
	/**
	 * Constructor for the paint strategy
	 * @param at An affine transform object for the paint strategy
	 * @param pstrats The paint strategies
	 */
	public MultiPaintStrategy(AffineTransform at, APaintStrategy... pstrats) {
		super(at);
		this.pstrats = pstrats;
	}
	
	/**
	 * Constructor for the paint strategy
	 * @param pstrats The paint strategies
	 */
	public MultiPaintStrategy(APaintStrategy... pstrats) {
		this(new AffineTransform(), pstrats);
	}
	
	/**
	 * Init the strategy
	 * @param host The ball
	 */
	public void init(Ball host) {
		for (APaintStrategy pstrat : pstrats) {
			pstrat.init(host);
		}
	}
	
	/**
	 * makes the paint strategy update every 5*50 = 250 ms	 
	 * @param g The Graphics object.
	 * @param host The ball object we need to paint.
	 * @param at The affine transform.
	 */
	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		for (APaintStrategy pstrat : pstrats) {
			pstrat.paintXfrm(g, host, at);
		}
	}
}
