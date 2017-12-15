package ballworld;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import util.Randomizer;
import util.SineMaker;

public class BreathingBall extends ABall {
	double min = -Randomizer.Singleton.randomDouble(3, 6);
	double max = -min;
	double delta = Randomizer.Singleton.randomDouble(Math.PI / 10, Math.PI / 5);
	SineMaker sine = new SineMaker(min, max, delta);

	/**
	 * inherited from ABall
	 * @param origin Location
	 * @param color Color
	 * @param radius Radius
	 * @param velocity Velocity
	 * @param canvas The canvas of the view
	 */
	public BreathingBall(Point origin, Color color, int radius, Point velocity, Component canvas) {
		super(origin, color, radius, velocity, canvas);
	}

	/**
	 * change the radius of the ball, the radius is determined by the method 'SineMaker'
	 */
	public void trace_ball() {
		radius += sine.getIntVal();
	};
}
