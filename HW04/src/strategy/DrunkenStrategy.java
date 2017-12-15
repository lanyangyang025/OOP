package strategy;

import java.awt.Point;

import ball.Ball;
import util.Dispatcher;
import util.Randomizer;

/**
 * a strategy of changing the ball's velocity randomly
 * @author Ye Wang
 * @author Yiqing Lu
 *
 */
public class DrunkenStrategy implements IUpdateStrategy {

	/**
	 * the time slot between speed changing
	 */
	int cnt = 10;

	/**
	 * change the ball's velocity randomly
	 * @param ball the ball under operationx
	 */
	@Override
	public void updateState(final Ball context, Dispatcher dispatcher) {
		cnt--;
		if (cnt == 0) {
			int newX = Randomizer.singleton.randomInt(0, 30);
			int newY = Randomizer.singleton.randomInt(0, 30);
			context.setVelocity(new Point(newX, newY));
			cnt = 10;
		}
	}

}
