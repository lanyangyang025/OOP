package model.strategy.update;

import java.awt.Point;

import model.IBallCmd;
import model.ball.Ball;
import model.strategy.interact.IInteractStrategy;
import model.strategy.interact.MultipleInteractStrategy;
import util.IDispatcher;

/**
 * The split strategy enables the ball to split other balls into two pieces.
 * @author HaoyuanYue
 * @author YiqingLu
 * @param <TDispMsg> The type of message that the supplied IDispatcher can send. 
 */
public class SplitStrategy<TDispMsg> extends AUpdateStrategy<IBallCmd>{
	/**
	 * tick counter that counts out the delay before another ball can be spawned.
	 */
	private int count = 0; 
	
	/**
	 * tick delay which increases at each spawn to keep total spawn rate from exponentially exploding.
	 */
	private int delay = 5; 
	
	/**
	 * Init the strategy for the ball
	 */
	public void init(Ball context) {
		context.setInteractStrategy(new MultipleInteractStrategy(context.getInteractStrategy(), new IInteractStrategy(){
			@Override
			public void interact(Ball context, Ball target, IDispatcher<IBallCmd> disp) {
				if (count++ > delay) {
					disp.deleteObserver(target);
					if (target.getRadius() / 2 > 0) {
						disp.addObserver(new Ball(
								new Point(target.getLoc()), 
								new Point(-target.getVelocity().x+1,-target.getVelocity().y+1),
								target.getRadius() / 2,
								target.getColor(),
								target.getCanvas(), 
								target.getUpdateStrategy(),
								target.getPaintStrategy()));
						
						disp.addObserver(new Ball(
								new Point(target.getLoc()), 
								new Point(target.getVelocity().x+1,target.getVelocity().y+1),
								target.getRadius() / 2,
								target.getColor(),
								target.getCanvas(), 
								target.getUpdateStrategy(),
								target.getPaintStrategy()));
					}
					count = 0;
				}
			}
		}));
	}
}
