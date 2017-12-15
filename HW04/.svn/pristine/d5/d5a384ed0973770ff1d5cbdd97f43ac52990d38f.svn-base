package model.strategy;

/**
 * Class that provides default behavior for subclasses that will decorate another IPaintStrategy 
 * to add functionality to that strategy.
 * This class essentially inserts an indirection layer above its decoree, allowing the various methods 
 * to intercept their calls and perform additional behaviors, such as resetting the drawing color so 
 * that something always draws with the same color.  
 * @author Yiqing Lu
 * @author Ye Wang
 */

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import ball.Ball;

public class ADecoratorPaintStrategy extends APaintStrategy {

	public APaintStrategy decoree;

	ADecoratorPaintStrategy(APaintStrategy decoree) {
		super(new AffineTransform());
		// TODO Auto-generated constructor stub
		this.decoree = decoree;
	}

	public void init(Ball host) {
		decoree.init(host);
	}

	public void paint(Graphics g, Ball host) {
		decoree.paint(g, host);
	}

	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		decoree.paintXfrm(g, host, at);
	}
}
