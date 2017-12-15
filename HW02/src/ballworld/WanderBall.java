package ballworld;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import util.Randomizer;

public class WanderBall extends ABall {

	/**
	 * inherited from ABall
	 * @param origin Location
	 * @param color Color
	 * @param radius Radius
	 * @param velocity Velocity
	 * @param canvas The canvas of the view
	 */
	public WanderBall(Point origin, Color color, int radius, Point velocity, Component canvas) {
		super(origin, color, radius, velocity, canvas);
	}

	/**
	 * change the location of the ball randomly
	 */
	public void trace_ball() {
		// TODO Auto-generated method stub
		origin.x += Randomizer.Singleton.randomInt(-10, 10);
		origin.y += Randomizer.Singleton.randomInt(-10, 10);
	}
}
