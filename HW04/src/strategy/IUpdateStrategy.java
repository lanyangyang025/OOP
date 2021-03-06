package strategy;

import ball.Ball;
import util.Dispatcher;

/**
 * a abstract strategy of changing the ball's moving behavior
 * @author Ye Wang
 * @author Yiqing Lu
 *
 */
public interface IUpdateStrategy {
	/**
	 * Update the state of the context Ball.
	 * @param context  The context (host) Ball whose state is to be updated
	 * @param dispatcher  The Dispatcher who sent the command that is calling through to here.
	 */
	public abstract void updateState(Ball context, Dispatcher dispatcher);
}