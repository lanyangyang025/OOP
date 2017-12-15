
package model.ball;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import util.IDispatcher;
import util.IObserver;
import model.IBallCmd;
import model.strategy.interact.IInteractStrategy;
import model.strategy.paint.IPaintStrategy;
import model.strategy.update.*;

import java.awt.Component;

/**
 * The class that represents the basic movement and features of Ball.
 * @author Yiqing Lu
 * @author Haoyuan Yue
 */
public class Ball implements IObserver<IBallCmd> {
	/**
	 * The point of upperleft corner of the circle
	 */
	Point upperLeft;

	/**
	 * The x-coordinate and y-coordiante of the moving velocity of the circle
	 */
	Point velocity;

	/**
	 * The radius of the circle
	 */
	int radius;

	/**
	 * The color of the circle
	 */
	Color myColor;

	/**
	 * The strategy to update its state
	 */
	IUpdateStrategy<IBallCmd> strategy;

	/**
	 * The canvas of the circle to move and paint on
	 */
	Component canvas;
	
	/**
	 * The strategy to paint the ball
	 */
	IPaintStrategy paintStrategy;
	
	/**
	 * The strategy to interact with other balls
	 */
	IInteractStrategy interactStrategy;
	
	/**
	 * no-op ball
	 */
	public static final Ball NULL_OBJECT = new Ball(new Point(0, 0), new Point(0, 0), 0, Color.BLACK, null,
			(new IUpdateStrategy.NullFactory<IBallCmd>()).make(), (new IPaintStrategy.NullFactory()).make());
	
	/**
	 * Constructor of ABall
	 * @param upperLeft the point of upperleft corner of the circle
	 * @param velocity the point of velocity
	 * @param radius the radius of the circle
	 * @param myColor the color of the circle
	 * @param canvas canvas that to paint the circle
	 * @param strategy the ball's strategy of moving
	 * @param paintStrategy the ball's paint strategy
	 */
	public Ball(Point upperLeft, Point velocity, int radius, Color myColor, Component canvas, IUpdateStrategy<IBallCmd> strategy,
			IPaintStrategy paintStrategy) {
		this.upperLeft = upperLeft;
		this.velocity = velocity;
		this.radius = radius;
		this.myColor = myColor;
		this.strategy = strategy;
		this.canvas = canvas;
		setPaintStrategy(paintStrategy);
		setUpdateStrategy(strategy);
	}

	/**
	 *  Paint the circle in the given graphics
	 *  @param g The Graphics object to paint on.
	 */
	public void paint(Graphics g) {
		paintStrategy.paint(g, this);
	}

	/**
	 *  Change the location of the ball as per its velocity
	 */
	public void move() {
		upperLeft.x = upperLeft.x + velocity.x;
		upperLeft.y = upperLeft.y + velocity.y;
	}

	/**
	 *  Correct the location and velocity of a ball if it has contacted a wall
	 */
	public void bounce() {

		if (upperLeft.x - radius <= 0) {
			velocity.x = -velocity.x;
			upperLeft.x = 2 * radius - upperLeft.x;
		}
		if (upperLeft.x + radius >= canvas.getWidth()) {
			velocity.x = -velocity.x;
			upperLeft.x = 2 * canvas.getWidth() - upperLeft.x - 2 * radius;
		}

		if (upperLeft.y - radius <= 0) {
			velocity.y = -velocity.y;
			upperLeft.y = 2 * radius - upperLeft.y;
		}

		if (upperLeft.y + radius >= canvas.getHeight()) {
			velocity.y = -velocity.y;
			upperLeft.y = 2 * canvas.getHeight() - upperLeft.y - 2 * radius;
		}
	}

	/**
	 * Update the state of the ball
	 * @param dispatcher The dispatcher for the ball
	 */
	public void change(IDispatcher<IBallCmd> dispatcher) {
		strategy.updateState(this, dispatcher);
	}

	/**
	 * The update method called by the main ball Dispatcher to notify all the balls to perform the given command.
	 * The given command is executed.
	 * @param o The Dispatcher that sent the update request.
	 * @param cmd The IBallCmd that will be run.
	 */
	public void update(IDispatcher<IBallCmd> o, IBallCmd cmd) {
		 cmd.apply(this, o);
	}
	
	/**
	 * Return the ball's upper left location
	 * @return the upper left location of the ball
	 */
	public Point getLoc() {
		return upperLeft;
	}

	/**
	 * Return the ball's upper left location
	 * @param p the upper left location of the ball
	 */
	public void setLoc(Point p) {
		this.upperLeft = p;
	}
	
	/**
	 * Return the distance between two balls
	 * @param p The location of the target ball
	 * @return The distance between two balls
	 */
	public int distance(Point p) {
		return (int)(Math.sqrt((Math.pow((double)Math.abs((p.getX() - upperLeft.getX())), 2.0) + (Math.pow((double)Math.abs((p.getY() - upperLeft.getY())), 2.0)))));
	}
	
	/**
	 * Set the color of the ball
	 * @param newColor The new color given to the ball
	 */
	public void setColor(Color newColor) {
		this.myColor = newColor;
	}

	/**
	 * Return the ball's current velocity
	 * @return The current velocity
	 */
	public Point getVelocity() {
		return velocity;
	}

	/**
	 * Set the ball a new velocity
	 * @param v The new velocity given to the ball
	 */
	public void setVelocity(Point v) {
		this.velocity = v;
	}

	/**
	 * Return the ball's radius
	 * @return The current ball's radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * Set the ball's radius
	 * @param r The new radius
	 */
	public void setRadius(int r) {
		this.radius = r;
	}

	/**
	 * Return the ball's color
	 * @return The current ball's color
	 */

	public Color getColor() {
		return this.myColor;
	}

	/**
	 * Return the canvas
	 * @return The current canvas
	 */

	public Component getCanvas() {
		return this.canvas;
	}
	
	/**
	 * Set the paint strategy
	 * @param paintStrategy A paint strategy
	 */
	public void setPaintStrategy(IPaintStrategy paintStrategy) {
		this.paintStrategy = paintStrategy;
		this.paintStrategy.init(this);
	}

	/**
	 * Return the paint strategy
	 * @return The paint strategy
	 */
	public IPaintStrategy getPaintStrategy() {
		return paintStrategy;
	}
	
	/**
	 * Set the update strategy
	 * @param updateStrategy A update strategy
	 */
	public void setUpdateStrategy(IUpdateStrategy<IBallCmd> updateStrategy) {
		this.strategy = updateStrategy;
		this.strategy.init(this);
	}

	/**
	 * Return the update strategy
	 * @return The update strategy
	 */
	public IUpdateStrategy<IBallCmd> getUpdateStrategy() {
		return strategy;
	}
	
	/**
	 * Set the interact strategy
	 * @param interact An interact strategy
	 */
	public void setInteractStrategy(IInteractStrategy interact) {
		interactStrategy = interact;
	}
	
	/**
	 * Return the interact strategy
	 * @return The interact strategy
	 */
	public IInteractStrategy getInteractStrategy() {
		return interactStrategy;
	}
	
	/**
	 * Interact with another ball
	 * @param target The target ball
	 * @param disp The dispatcher
	 */
	public void interactWith(Ball target, IDispatcher<IBallCmd> disp) {
		if(interactStrategy != null) {
			interactStrategy.interact(this, target, disp);
		}
	}
}
