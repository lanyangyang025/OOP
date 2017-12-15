package model.strategy.paint;

/** 
 * Paint strategy to paint an image
 * @author YiqingLu
 * @author HaoyuanYue
 */

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

import model.ball.Ball;

import java.awt.Graphics2D;

public class ImagePaintStrategy extends APaintStrategy {
	/**
	 * An image observer
	 */
	protected ImageObserver imageObs;
	
	/**
	 * An image object to store the image
	 */
	protected Image image;
	
	/**
	 * A scaleFactor for the image
	 */
	protected double scaleFactor = 1.0;
	
	/**
	 * A fillFactor for the image
	 */
	protected double fillFactor = 1.0;
	
	/**
	 * An affine transform for the image object
	 */
	protected AffineTransform localAT = new AffineTransform();
	
	/**
	 * Constructor for the image paint strategy
	 * @param filename The file name of the image
	 * @param fillFactor The fill factor for the image
	 */
	public ImagePaintStrategy(String filename, double fillFactor) {
		this(new AffineTransform(), filename, fillFactor);
	}
	
	/**
	 * Init the strategy
	 * @param host The ball
	 */
	public void init(Ball host) {
		imageObs = (ImageObserver) host.getCanvas();
		MediaTracker mt = new MediaTracker(host.getCanvas());
		mt.addImage(image, 1);
		try {
			mt.waitForAll();
		} catch (Exception e) {
			System.out.println("ImagePaintStrategy.init(): Error waiting for image.  Exception = " + e);
		}
		this.scaleFactor = 2.0 / (fillFactor * (image.getWidth(imageObs) + image.getHeight(imageObs)) / 2.0);
	}
	
	/**
	 * Constructor for the image paint strategy
	 * @param at An affine transform object
	 * @param filename The file name of the image
	 * @param fillFactor The fill factor for the image
	 */
	public ImagePaintStrategy(AffineTransform at, String filename, double fillFactor) {
		super(at);
		this.fillFactor = fillFactor;
		try {
			image = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(filename));
		} catch (Exception e) {
			System.err.println("ImagePaintStrategy: Error reading file: " + filename + "\n" + e);
		}
	}
	
	/**
	 * makes the paint strategy update every 5*50 = 250 ms	 
	 * @param g The Graphics object.
	 * @param host The ball object we need to paint.
	 * @param at The affine transform.
	 */
	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		localAT.setToScale(scaleFactor, scaleFactor);
		localAT.translate(-image.getWidth(imageObs) / 2.0, -image.getHeight(imageObs) / 2.0);
		localAT.preConcatenate(at);
		((Graphics2D) g).drawImage(image, localAT, imageObs);
	}
}
