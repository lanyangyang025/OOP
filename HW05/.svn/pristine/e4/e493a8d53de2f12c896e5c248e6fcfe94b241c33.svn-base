package model.strategy.update;

import java.awt.Point;
import model.ball.Ball;
import util.IDispatcher;
import util.Randomizer;

/**
 * A strategy of wandering about
 * @author HaoyuanYue
 * @author YiqingLu
 * @param <TDispMsg> The type of message that the supplied IDispatcher can send. 
 */
public class WanderStrategy<TDispMsg> extends AUpdateStrategy<TDispMsg> {
	/**
	 * Update the state of the ball
	 * @param context The ball object
	 * @param dispatcher The dispatcher 
	 */
	@Override
	public void updateState(final Ball context, IDispatcher<TDispMsg> dispatcher) {
		Point oldV = context.getVelocity();
		oldV.x = Randomizer.singleton.randomInt(-50, 50);
		oldV.y = Randomizer.singleton.randomInt(-50, 50);
		context.setVelocity(oldV);
	}
	

}
