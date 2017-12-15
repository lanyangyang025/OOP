package model.strategy.update;

import model.IBallCmd;
import model.ball.Ball;
import util.IDispatcher;

/**
 * A strategy of the ball that could be changed to another strategy
 * @author HaoyuanYue
 * @author YiqingLu
 * @param <TDispMsg> The type of message that the supplied IDispatcher can send. 
 */
public class SwitchStrategy<TDispMsg> extends AUpdateStrategy<IBallCmd> {
	
	/**
	 * The current strategy of the switcher
	 */
	private IUpdateStrategy<IBallCmd> strategy;
	
	/**
	 * Constructor for the switch strategy
	 */
	public SwitchStrategy() {
		strategy = new StraightStrategy<IBallCmd>();
	}

	/**
	 * Update the state of the ball
	 * @param context The ball object
	 * @param dispatcher The dispatcher 
	 */
	public void updateState(final Ball context, IDispatcher<IBallCmd> dispatcher) {
		strategy.updateState(context, dispatcher);
	}

	/**
	 * switch the current strategy
	 * @param newS the new strategy
	 */
	public void switchStrategy(IUpdateStrategy<IBallCmd> newS) {
		strategy = newS;
	}

}
