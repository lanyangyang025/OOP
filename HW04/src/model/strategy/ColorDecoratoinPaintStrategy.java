package model.strategy;

/**
 * A class which could paint a shape with a different color and the same affine transform.
 * @author Yiqing Lu
 * @author Ye Wang
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import ball.Ball;

public class ColorDecoratoinPaintStrategy extends ADecoratorPaintStrategy {

	Color color;

	ColorDecoratoinPaintStrategy(Color color, APaintStrategy strategy) {
		super(strategy);
		// TODO Auto-generated constructor stub
		this.color = color;
	}

	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		g.setColor(color);
		super.paintXfrm(g, host, at);
	}

}
