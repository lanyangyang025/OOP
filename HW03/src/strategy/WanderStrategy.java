package strategy;

import model.Ball;
import model.IUpdateStrategy;
import util.Randomizer;

/**
 * WanderStrategy will make a ball randomly change its velocity every 15 ticks
 * @author Renqin
 * @author Yiqing Lu
 */
public class WanderStrategy implements IUpdateStrategy {

	/**
	 * The counter for next 'wander' change
	 */
	private int count = 15;

	@Override
	public void updateState(Ball ball) {
		count--;
		if (count == 0) {
			ball.velocity.x += Randomizer.Singleton.randomInt(-10, 10);
			ball.velocity.y += Randomizer.Singleton.randomInt(-10, 10);
		}
	}

}