package strategy;

import java.awt.Point;

import ball.Ball;
import util.Dispatcher;
import util.Randomizer;

/**
 * a strategy of changing the ball's radius
 * @author Ye Wang
 * @author Yiqing Lu
 *
 */
public class BreathingStrategy implements IUpdateStrategy {

	/**
	 * change the radius of the ball
	 * @param ball the ball under operation
	 */
	@Override
	public void updateState(final Ball context, Dispatcher dispatcher) {
		int oldRad = context.getRadius();
		int newRad = Randomizer.singleton.randomInt(Math.max(oldRad - 10, 1), Math.min(oldRad + 10, 30));
		context.setRadius(newRad);
		Point oldLoc = context.getLoc();
		context.setLoc(new Point(oldLoc.x + (oldRad - newRad), oldLoc.y + (oldRad - newRad)));
	}

}
