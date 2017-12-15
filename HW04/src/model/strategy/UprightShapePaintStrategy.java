package model.strategy;

/**
 * keep a shape upright.
 * @author Yiqing Lu
 * @author Ye Wang
 */

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.Graphics;
import ball.Ball;

public class UprightShapePaintStrategy extends ShapePaintStrategy {

	public UprightShapePaintStrategy(Shape shape) {
		super(shape);
		// TODO Auto-generated constructor stub
	}

	public UprightShapePaintStrategy(AffineTransform at, Shape shape) {
		super(at, shape);
		// TODO Auto-generated constructor stub
	}

	protected void paintCfg(Graphics g, Ball host) {
		super.paintCfg(g, host);
		if (Math.abs(Math.atan2(host.getVelocity().y, host.getVelocity().x)) > Math.PI / 2.0) {
			//host.getVelocity().x = -host.getVelocity().x;
			at.scale(1.0, -1.0);
		}
	}
}
