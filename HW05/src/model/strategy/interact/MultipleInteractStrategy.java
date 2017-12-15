package model.strategy.interact;

import model.IBallCmd;
import model.ball.Ball;
import util.IDispatcher;

/**
 * Interact Strategy to handle the interaction with different balls
 * @author HaoyuanYue
 * @author YiqingLu
 */
public class MultipleInteractStrategy implements IInteractStrategy{
	/**
	 * An interact strategy
	 */
	private IInteractStrategy i1;
	
	/**
	 * An interact strategy
	 */
	private IInteractStrategy i2;
	
	/**
	 * Constructor for multipleInteractStrategy 
	 * @param _i1 An interact strategy
	 * @param _i2 An interact strategy
	 */
	public MultipleInteractStrategy(IInteractStrategy _i1, IInteractStrategy _i2) {
		i1 = _i1;
		i2 = _i2;
	}
	
	/**
	 * Interact with other ball
	 * @param context A ball
	 * @param target A ball
	 * @param disp A dispatcher
	 */
	public void interact(Ball context, Ball target, IDispatcher<IBallCmd> disp) {
		if (context == null) {
			context = Ball.NULL_OBJECT;
		}
		
		if (target == null) {
			target = Ball.NULL_OBJECT;
		}
		
		if (i1 != null) {
			i1.interact(context, target, disp);
		}
		if (i2 != null) {
			i2.interact(context, target, disp);
		}
		
	}
}
