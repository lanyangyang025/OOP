package model.strategy;

/**
 * keep an image upright.
 * @author Yiqing Lu
 * @author Ye Wang
 */
import java.awt.Graphics;

import ball.Ball;

public class UprightImagePaintStrategy extends ImagePaintStrategy {

	public UprightImagePaintStrategy(String filename, double fillFactor) {
		super(filename, fillFactor);
		// TODO Auto-generated constructor stub
	}

	public void paintCfg(Graphics g, Ball host) {
		super.paintCfg(g, host);
		if (Math.abs(Math.atan2(host.getVelocity().y, host.getVelocity().x)) > Math.PI / 2.0) {
			//host.getVelocity().x = -host.getVelocity().x;
			at.scale(1.0, -1.0);
		}
	}
}
