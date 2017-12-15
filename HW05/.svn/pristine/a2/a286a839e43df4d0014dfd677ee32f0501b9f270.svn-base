package model.strategy.interact;

import model.IBallCmd;
import model.ball.Ball;
import util.IDispatcher;
/**
 * Interact Strategy to handle the interaction with different balls
 * @author HaoyuanYue
 * @author YiqingLu
 */
public interface IInteractStrategy {
	/**
	 * Performs a directed interaction between the context ball and the target Ball from the 
	 * perspective of the context Ball.
	 * @param context  The Ball from whose perspective the interaction 
	 * processing takes place.
	 * @param target  The Ball that is the "other ball" in the perspective of this processing.
	 * @param disp  The Dispatcher that is to be used if desired.
	 */
	public void interact(Ball context, Ball target, IDispatcher<IBallCmd> disp);

	/**
	 * Null strategy with no-op behavior.
	 */
	public static final IInteractStrategy NULL_STRATEGY = (context, target, disp)->{};
}
