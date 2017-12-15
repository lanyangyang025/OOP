package strategy;

import ball.Ball;
import util.Dispatcher;

/**
 * a strategy of the ball that could be changed to another strategy
 * @author Ye Wang
 * @author Yiqing Lu
 *
 */
public class SwitchStrategy implements IUpdateStrategy {

	/**
	 * the current strategy of the switcher
	 */
	static IUpdateStrategy strategy;

	public SwitchStrategy() {
		strategy = new StraightStrategy();
	}

	/**
	 * update the ball using the current strategy
	 */
	public void updateState(final Ball context, Dispatcher dispatcher) {
		strategy.updateState(context, dispatcher);
	}

	/**
	 * switch the current strategy
	 * @param newS the new strategy
	 */
	public static void switchStrategy(IUpdateStrategy newS) {
		strategy = newS;
	}

}
