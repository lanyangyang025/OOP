package model.strategy.update;

import model.ball.Ball;
import util.IDispatcher;

/**
 * The update state strategy provides basic implementation for its subclass using
 * @author HaoyuanYue
 * @author YiqingLu
 * @param <TDispMsg> The type of message that the supplied IDispatcher can send. 
 */
public class AUpdateStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {
	
	/**
	 * Init the strategy
	 */
	public void init(Ball context) { }
	
	/**
	 * Update the state of the ball
	 * @param context The ball object
	 * @param dispatcher The dispatcher 
	 */
	public void updateState(Ball context, IDispatcher<TDispMsg> dispatcher) { }
	
	/**
	 * Return the string of the class
	 */
	public String toString() {
		return this.toString();
	}
}
