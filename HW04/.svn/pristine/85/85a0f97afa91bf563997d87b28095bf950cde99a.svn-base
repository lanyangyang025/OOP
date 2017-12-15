package model.strategy;

/**
 * A class that could load many paint strategies.
 * @author Yiqing Lu
 * @author Ye Wang
 */

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import ball.Ball;

public class MultiPaintStrategy extends APaintStrategy {

	APaintStrategy[] pstrats;

	public MultiPaintStrategy(AffineTransform at, APaintStrategy... pstrats) {
		// TODO Auto-generated constructor stub
		super(at);
		this.pstrats = pstrats;
	}

	public MultiPaintStrategy(APaintStrategy... pstrats) {
		// TODO Auto-generated constructor stub
		this(new AffineTransform(), pstrats);
	}

	public void init(Ball host) {
		for (APaintStrategy pstrat : pstrats) {
			pstrat.init(host);
		}
	}

	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		for (APaintStrategy pstrat : pstrats) {
			pstrat.paintXfrm(g, host, at);
		}
	}
}
