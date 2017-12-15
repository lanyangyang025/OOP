package strategy;

import java.awt.Point;

import ball.Ball;
import util.Dispatcher;
import util.Randomizer;

/**
 * a strategy of changing the ball's velocity direction
 * @author Ye Wang
 * @author Yiqing Lu
 *
 */
public class CurveStrategy implements IUpdateStrategy {

	/**
	 * the angle of the velocity direction change
	 */
	double radius;

	/**
	 * constructor of the strategy
	 */
	public CurveStrategy() {
		radius = Randomizer.singleton.randomDouble(0.2, 1);
	}

	/**
	 * change the velocity direction of the ball
	 * @param ball the ball under operation
	 */
	@Override
	public void updateState(final Ball context, Dispatcher dispatcher) {
		Point oldV = context.getVelocity();
		int oldX = oldV.x;
		int oldY = oldV.y;
		double newX = Math.round(oldX * Math.cos(radius) - oldY * Math.sin(radius));
		double newY = Math.round(oldY * Math.cos(radius) + oldX * Math.sin(radius));

		context.setVelocity(new Point((int) newX, (int) newY));

	}

}
