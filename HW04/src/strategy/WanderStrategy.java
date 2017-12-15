package strategy;

import java.awt.Point;
import ball.Ball;
import util.Dispatcher;
import util.Randomizer;

/**
 * a strategy of wandering about
 * @author Ye Wang
 * @author Yiqing Lu
 *
 */
public class WanderStrategy implements IUpdateStrategy {

	/**
	 * change the speed of ball by a random number ranges from -10 to 10
	 */
	@Override
	public void updateState(final Ball context, Dispatcher dispatcher) {

		Point oldV = context.getVelocity();
		oldV.x = Randomizer.singleton.randomInt(-50, 50);
		oldV.y = Randomizer.singleton.randomInt(-50, 50);
		context.setVelocity(oldV);
	}

}
