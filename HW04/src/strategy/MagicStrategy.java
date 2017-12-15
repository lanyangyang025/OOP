package strategy;

import java.awt.Point;

import ball.Ball;
import util.Dispatcher;

/**
 * a strategy of magic route, spinning
 * @author Ye Wang
 * @author Yiqing Lu
 */
public class MagicStrategy implements IUpdateStrategy {
	//counter resets every 361/0.01 time slice
	private double count = 0;

	/**
	 * Update the ball's velocity in a magical way
	 */
	@Override
	public void updateState(final Ball context, Dispatcher dispatcher) {
		// TODO Auto-generated method stub
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
