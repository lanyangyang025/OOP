package model.strategy.update;

import model.IBallCmd;
import model.ball.Ball;
import model.strategy.interact.IInteractStrategy;
import model.strategy.interact.MultipleInteractStrategy;
import util.IDispatcher;

/**
 * The strategy that the ball will kill any ball that has an interaction with it.
 * @author HaoyuanYue
 * @author YiqingLu
 * @param <TDispMsg> The type of message that the supplied IDispatcher can send. 
 */
public class KillStrategy<TDispMsg> extends AUpdateStrategy<IBallCmd>{
	/**
	 * Init the strategy for the ball
	 */
	public void init(Ball context) {
		context.setInteractStrategy(new MultipleInteractStrategy(context.getInteractStrategy(), new IInteractStrategy(){
			@Override
			public void interact(Ball context, Ball target, IDispatcher<IBallCmd> disp) {
				disp.deleteObserver(target);		
			}
		}));
	}
	
}
