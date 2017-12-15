package ballworld;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import util.Randomizer;

public class ColorChangingBall extends ABall {

	/**
	 * inherited form ABall
	 * @param origin Location
	 * @param color Color
	 * @param radius Radius
	 * @param velocity Velocity
	 * @param canvas The canvas of the view
	 */
	public ColorChangingBall(Point origin, Color color, int radius, Point velocity, Component canvas) {
		super(origin, color, radius, velocity, canvas);
	}

	/**
	 * change the color of the ball randomly
	 */
	public void trace_ball() {
		this.color = Randomizer.Singleton.randomColor();
	}
}
