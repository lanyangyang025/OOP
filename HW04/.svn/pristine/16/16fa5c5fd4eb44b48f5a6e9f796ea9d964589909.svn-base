package model.strategy;

/** 
 * Paint strategy to paint an image
 * @author Yiqing Lu
 * @author Ye Wang
 */

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;
import java.awt.Graphics2D;
import ball.Ball;

public class ImagePaintStrategy extends APaintStrategy {

	public ImageObserver imageObs;
	public Image image;
	public double scaleFactor = 1.0;
	public double fillFactor = 1.0;

	protected AffineTransform localAT = new AffineTransform();

	public ImagePaintStrategy(String filename, double fillFactor) {
		this(new AffineTransform(), filename, fillFactor);
	}

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

	public ImagePaintStrategy(AffineTransform at, String filename, double fillFactor) {
		super(at);
		// TODO Auto-generated constructor stub
		this.fillFactor = fillFactor;
		try {
			image = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(filename));
		} catch (Exception e) {
			System.err.println("ImagePaintStrategy: Error reading file: " + filename + "\n" + e);
		}
	}

	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		localAT.setToScale(scaleFactor, scaleFactor);
		localAT.translate(-image.getWidth(imageObs) / 2.0, -image.getHeight(imageObs) / 2.0);
		localAT.preConcatenate(at);
		((Graphics2D) g).drawImage(image, localAT, imageObs);
	}
}
