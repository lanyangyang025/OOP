package model;

import java.awt.*;

import java.util.Observer;
import java.util.Observable;
import model.IUpdateStrategy;

/**
 * Concrete class for a ball and defines its reasonable field and some common methods
 * @author Renqin
 * @author Yiqing Lu
 */
public class Ball implements Observer {
	/**
	 * The location of a ball
	 */
	public Point origin = new Point(50, 50);
	/**
	 * The velocity of a ball
	 */
	public Point velocity = new Point(5, 5);
	/**
	 * The color of a ball
	 */
	public Color color = Color.BLUE;
	/**
	 * The radius of a ball
	 */
	public int radius = 10;
	/**
	 * The canvas of the view
	 */
	protected Component canvas;

	protected IUpdateStrategy strategy;

	/**
	 * Constructor of Ball
	 * @param origin Location
	 * @param color Color
	 * @param radius Radius
	 * @param velocity Velocity
	 * @param canvas The canvas of the view
	 */
	public Ball(Point origin, Color color, int radius, Point velocity, Component canvas) {
		this.origin = origin;
		this.color = color;
		this.radius = radius;
		this.velocity = velocity;
		this.canvas = canvas;
	}

	/**
	 * paint a ball
	 * @param g the system Graphics object
	 */
	public void paint(Graphics g) {
		g.setColor(get_color()); // Set the color to use when drawing
		g.fillOval(get_x() - radius, get_y() - radius, 2 * radius, 2 * radius); // paint a filled 20x40 red ellipse whose upper left corner is at (75, 100)
	}

	/**
	 * @return the x coordinate of ball's location 
	 */
	public int get_x() {
		return origin.x;
	}

	/**
	 * @return the y coordinate of ball's location
	 */
	public int get_y() {
		return origin.y;
	}

	/**
	 * @return the ball's color
	 */
	public Color get_color() {
		return this.color;
	}

	/**
	 * @return the ball's radius
	 */
	public int get_radius() {
		return this.radius;
	}

	/**
	 * @return the x part of the ball's velocity
	 */
	public int get_x_velocity() {
		return velocity.x;
	}

	/**
	 * @return the y part of the ball's velocity
	 */
	public int get_y_velocity() {
		return velocity.x;
	}

	/**
	 * @param new_velocity the new velocity which is going to give to the ball
	 */
	public void set_velocity(Point new_velocity) {
		velocity = new_velocity;
	}

	/**
	 * @return the width and height of the panel where all ball appear
	 */
	public Point canvas_getSize() {
		int width = canvas.getWidth();
		int height = canvas.getHeight();
		return new Point(width, height);
	}

	/**
	 * move the ball to a new location according to its velocity every tick
	 */
	public void new_location() {
		origin.translate(velocity.x, velocity.y);
		//		origin.x +=  velocity.x;
		//		origin.y +=  velocity.y;
	}

	/**
	 * changes of velocity and location when the ball need to bounce
	 */
	public void bounce() {
		Point border = canvas_getSize();
		if (origin.x + radius >= border.x) {
			velocity.x = -velocity.x;
			origin.x = 2 * border.x - 2 * radius - origin.x;
		}
		if (origin.y + radius >= border.y) {
			velocity.y = -velocity.y;
			origin.y = 2 * border.y - 2 * radius - origin.y;
		}
		if (origin.x - radius <= 0) {
			velocity.x = -velocity.x;
			origin.x = 2 * radius - origin.x;
		}
		if (origin.y - radius <= 0) {
			velocity.y = -velocity.y;
			origin.y = 2 * radius - origin.y;
		}
	}

	/**
	 * @return the current strategy the ball has
	 */
	public IUpdateStrategy getStrategy() {
		return strategy;
	}

	/**
	 * @param strategy the strategy which is going to give to the ball
	 */
	public void setStrategy(IUpdateStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * update a ball when a change has occurred in the state of the BallModel.
	 */
	public void update(Observable o, Object g) {
		paint((Graphics) g);
		new_location();
		bounce();
		strategy.updateState(this);
	}

}