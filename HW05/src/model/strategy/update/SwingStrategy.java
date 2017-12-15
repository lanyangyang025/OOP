package model.strategy.update;

import java.awt.Point;

import model.ball.Ball;
import util.IDispatcher;

/**
 * A strategy of changing one of the ball's x and y velocity
 * @author HaoyuanYue
 * @author YiqingLu
 * @param <TDispMsg> The type of message that the supplied IDispatcher can send. 
 */
public class SwingStrategy<TDispMsg> extends AUpdateStrategy<TDispMsg> {
	/**
	 * tick counter that counts out the delay before another ball can be spawned.
	 */
	private int cnt = 5;
	
	/**
	 * Update the state of the ball
	 * @param context The ball object
	 * @param dispatcher The dispatcher 
	 */
	public void updateState(final Ball context, IDispatcher<TDispMsg> dispatcher) {
		cnt--;
		if (cnt == 0) {
			Point oldV = context.getVelocity();
			if (Math.abs(oldV.x) > Math.abs(oldV.y)) {
				context.setVelocity(new Point(-oldV.x, oldV.y));
			} else {
				context.setVelocity(new Point(oldV.x, -oldV.y));
			}
			cnt = 5;
		}
	}

}
