package model.strategy;

/**
 * A class that will paint a fish which has an eye on the front of the fish.
 * @author Yiqing Lu
 * @author Ye Wang
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import ball.Ball;

public class NiceFishPaintStrategy extends MultiPaintStrategy {

	public NiceFishPaintStrategy() {
		this(new AffineTransform());
	}

	public NiceFishPaintStrategy(AffineTransform at) {
		super(at, new Fish2PaintStrategy(at),
				new ColorDecoratoinPaintStrategy(Color.BLACK, new EllipsePaintStrategy(at, -0.4, -0.2, 0.15, 0.15)));
	}

	public void paintCfg(Graphics g, Ball host) {
		super.paintCfg(g, host);
		if (Math.abs(Math.atan2(host.getVelocity().y, host.getVelocity().x)) > Math.PI / 2.0) {
			//host.getVelocity().x = -host.getVelocity().x;
			at.scale(1.0, -1.0);
		}
	}
}
