package model.strategy.update;

import model.ball.Ball;
import util.IDispatcher;

/**
 * A multi strategy combining two strategies
 * @author HaoyuanYue
 * @author YiqingLu
 */
public class MultiStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {

	/**
	 * The first strategy
	 */
	IUpdateStrategy<TDispMsg> strategy1;
	
	/**
	 * The second strategy
	 */
	IUpdateStrategy<TDispMsg> strategy2;
	
	/**
	 * Constructor for the multiple strategy
	 * @param s1 One strategy
	 * @param s2 One strategy
	 */
	public MultiStrategy(IUpdateStrategy<TDispMsg> s1, IUpdateStrategy<TDispMsg> s2) {
		this.strategy1 = s1;
		this.strategy2 = s2;
	}
	/**
	 * Update the state of the ball
	 * @param context The ball object
	 * @param dispatcher The dispatcher 
	 */
	@Override
	public void updateState(final Ball context, IDispatcher<TDispMsg> dispatcher) {
		strategy1.updateState(context, dispatcher);
		strategy2.updateState(context, dispatcher);
	}
	
	/**
	 * Init the strategy for the ball
	 */
	public void init(Ball context) {
		strategy1.init(context);
		strategy2.init(context);
	}

}
