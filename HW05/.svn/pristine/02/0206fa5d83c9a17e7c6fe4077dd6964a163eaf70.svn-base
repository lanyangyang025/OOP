package model.strategy.update;

import java.awt.Point;

import model.ball.Ball;
import util.IDispatcher;
import util.Randomizer;

/**
 * A strategy of changing the ball's velocity randomly
 * @author HaoyuanYue
 * @author YiqingLu
 * @param <TDispMsg> The type of message that the supplied IDispatcher can send. 
 */
public class DrunkenStrategy<TDispMsg> extends AUpdateStrategy<TDispMsg> {

	/**
	 * The time slot between speed changing
	 */
	private int cnt = 10;

	/**
	 * Update the state of the ball
	 * @param context The ball object
	 * @param dispatcher The dispatcher 
	 */
	@Override
	public void updateState(final Ball context, IDispatcher<TDispMsg> dispatcher) {
		cnt--;
		if (cnt == 0) {
			int newX = Randomizer.singleton.randomInt(0, 30);
			int newY = Randomizer.singleton.randomInt(0, 30);
			context.setVelocity(new Point(newX, newY));
			cnt = 10;
		}
	}
	

}
