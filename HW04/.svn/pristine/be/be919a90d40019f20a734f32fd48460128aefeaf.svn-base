package strategy;

import ball.Ball;
import util.Dispatcher;

/**
 * a multi strategy combining two strategies
 * @author Ye Wang
 * @author Yiqing Lu
 */
public class MultiStrategy implements IUpdateStrategy {

	/**
	 * the first strategy
	 */
	IUpdateStrategy strategy1;
	IUpdateStrategy strategy2;

	public MultiStrategy(IUpdateStrategy s1, IUpdateStrategy s2) {
		this.strategy1 = s1;
		this.strategy2 = s2;
	}

	@Override
	public void updateState(final Ball context, Dispatcher dispatcher) {
		strategy1.updateState(context, dispatcher);
		strategy2.updateState(context, dispatcher);
	}

}
