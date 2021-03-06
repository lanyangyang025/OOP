package ballworld;

import java.awt.*;

import java.util.Observer;
import java.util.Observable;

public abstract class ABall implements Observer {
	/*
	 * The location of a ball
	 */
	protected Point origin = new Point(50, 50);
	/*
	 * The velocity of a ball
	 */
	protected Point velocity = new Point(5, 5);
	/*
	 * The color of a ball
	 */
	protected Color color = Color.BLUE;
	/*
	 * The radius of a ball
	 */
	protected int radius = 10;
	/*
	 * The canvas of the view
	 */
	protected Component canvas;

	/**
	 * Constructor of ABall
	 * @param origin Location
	 * @param color Color
	 * @param radius Radius
	 * @param velocity Velocity
	 * @param canvas The canvas of the view
	 */
	public ABall(Point origin, Color color, int radius, Point velocity, Component canvas) {
		this.origin = origin;
		this.color = color;
		this.radius = radius;
		this.velocity = velocity;
		this.canvas = canvas;
	}

	/*
	 * paint a ball
	 */
	public void paint(Graphics g) {
		g.setColor(get_color()); // Set the color to use when drawing
		g.fillOval(get_x() - radius, get_y() - radius, 2*radius, 2*radius); // paint a filled 20x40 red ellipse whose upper left corner is at (75, 100)
	};

	public int get_x() {
		return origin.x;
	}

	public int get_y() {
		return origin.y;
	}

	public Color get_color() {
		return this.color;
	}

	public int get_radius() {
		return this.radius;
	}

	public int get_x_velocity() {
		return velocity.x;
	}

	public int get_y_velocity() {
		return velocity.x;
	}

	public Point canvas_getSize() {
		int width = canvas.getWidth();
		int height = canvas.getHeight();
		return new Point(width, height);
	}

	public void new_location() {
		origin.translate(velocity.x, velocity.y);
		//		origin.x +=  velocity.x;
		//		origin.y +=  velocity.y;
	}

	/*
	 * the difference of motion between different balls
	 */
	public abstract void trace_ball();

	/*
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

	/*
	 * update a ball when a change has occurred in the state of the BallModel.
	 */
	public void update(Observable o, Object g) {
		paint((Graphics) g);
		new_location();
		trace_ball();
		bounce();
	}

}