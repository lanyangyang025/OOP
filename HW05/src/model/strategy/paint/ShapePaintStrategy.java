package model.strategy.paint;

/**
 * A class which could provide storage for an arbitrary shape and to implement 
 * the paintXfrm method which uses the existing affine transform to create the shape 
 * image at the desired size, rotation and location:.
 * @author YiqingLu
 * @author HaoyuanYue
 */

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import model.ball.Ball;

import java.awt.Graphics2D;

public class ShapePaintStrategy extends APaintStrategy {
	/**
	 * A shape for the paint strategy
	 */
	public Shape shape;
	
	/**
	 * Constructor for the paint strategy
	 * @param shape The shape for the paint strategy
	 */
	public ShapePaintStrategy(Shape shape) {
		this(new AffineTransform(), shape);
	}
	
	/**
	 * Constructor for the paint strategy
	 * @param shape The shape for the paint strategy
	 * @param at The affine transform for the paint strategy
	 */
	public ShapePaintStrategy(AffineTransform at, Shape shape) {
		super(at);
		this.shape = shape;
	}
	
	/**
	 * makes the paint strategy update every 5*50 = 250 ms	 
	 * @param g The Graphics object.
	 * @param host The ball object we need to paint.
	 * @param at The affine transform.
	 */
	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		((Graphics2D) g).fill(at.createTransformedShape(shape));
	}
}
