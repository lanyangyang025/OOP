package model.strategy.update;

import java.awt.Point;

import model.ball.Ball;
import util.IDispatcher;

/**
 * A strategy of magic route, spinning
 * @author HaoyuanYue
 * @author YiqingLu
 * @param <TDispMsg> The type of message that the supplied IDispatcher can send. 
 */
public class MagicStrategy<TDispMsg> extends AUpdateStrategy<TDispMsg> {
	/**
	 * Counter resets every 361/0.01 time slice
	 */
	private double count = 0;
	
	/**
	 * Update the state of the ball
	 * @param context The ball object
	 * @param dispatcher The dispatcher 
	 */
	@Override
	public void updateState(final Ball context, IDispatcher<TDispMsg> dispatcher) {
		double angle = (double) ((count += 0.01) % 361);
		Point velocity = context.getVelocity();
		double x = velocity.x, y = velocity.y;
		velocity.x = (int) (Math.round(x * Math.cos(angle)) - Math.round(y * Math.sin(angle)));
		velocity.y = (int) (Math.round(y * Math.cos(angle)) + Math.round(x * Math.sin(angle)));
		context.setVelocity(velocity);
		context.setLoc(
				new Point(context.getLoc().x + context.getVelocity().x, context.getLoc().y + context.getVelocity().y));
	}

}
