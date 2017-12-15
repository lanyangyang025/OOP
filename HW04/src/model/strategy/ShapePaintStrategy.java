package model.strategy;

/**
 * A class which could provide storage for an arbitrary shape and to implement 
 * the paintXfrm method which uses the existing affine transform to create the shape 
 * image at the desired size, rotation and location:.
 * @author Yiqing Lu
 * @author Ye Wang
 */

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;

import ball.Ball;

public class ShapePaintStrategy extends APaintStrategy {

	public Shape shape;

	ShapePaintStrategy(Shape shape) {
		// TODO Auto-generated constructor stub
		this(new AffineTransform(), shape);
	}

	ShapePaintStrategy(AffineTransform at, Shape shape) {
		// TODO Auto-generated constructor stub
		super(at);
		this.shape = shape;
	}

	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		((Graphics2D) g).fill(at.createTransformedShape(shape));
	}
}
