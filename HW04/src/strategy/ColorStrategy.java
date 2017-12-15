package strategy;

import java.awt.Color;

import ball.Ball;
import util.Dispatcher;
import util.Randomizer;

/**
 * a strategy of changing the ball's color
 * @author Ye Wang
 * @author Yiqing Lu
 *
 */
public class ColorStrategy implements IUpdateStrategy {

	/**
	 * change the color of the ball
	 * @param ball the ball under operation
	 */
	@Override
	public void updateState(final Ball context, Dispatcher dispatcher) {
		Color newColor = Randomizer.singleton.randomColor();
		context.setColor(newColor);
	}

}
