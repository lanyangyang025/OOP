package ballworld;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import util.Randomizer;

public class CurveBall extends ABall {

	double theta = Randomizer.Singleton.randomDouble(-Math.PI / 3, Math.PI / 3);

	/**
	 * inherited from ABall
	 * @param origin Location
	 * @param color Color
	 * @param radius Radius
	 * @param velocity Velocity
	 * @param canvas The canvas of the view
	 */
	public CurveBall(Point origin, Color color, int radius, Point velocity, Component canvas) {
		super(origin, color, radius, velocity, canvas);
	}

	/**
	 * change the velocity of the ball
	 */
	public void trace_ball() {
		this.velocity.x = (int) Math.ceil(Math.cos(theta) * this.velocity.x - Math.sin(theta) * this.velocity.y);
		this.velocity.y = (int) Math.ceil(Math.cos(theta) * this.velocity.y + Math.sin(theta) * this.velocity.x);
		if (this.velocity.x == 0 && this.velocity.y == 0) {
			this.velocity.x = Randomizer.Singleton.randomInt(5, 15);
		}
	}
}
