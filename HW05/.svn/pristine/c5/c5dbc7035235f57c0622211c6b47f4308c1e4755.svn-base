package model.strategy.update;

import java.awt.Point;

import model.ball.Ball;
import util.IDispatcher;
import util.Randomizer;

/**
 * A strategy of changing the ball's radius
 * @author HaoyuanYue
 * @author YiqingLu
 * @param <TDispMsg> The type of message that the supplied IDispatcher can send. 
 */
public class BreathingStrategy<TDispMsg> extends AUpdateStrategy<TDispMsg> {
	
	/**
	 * Update the state of the ball
	 * @param context The ball object
	 * @param dispatcher The dispatcher 
	 */
	@Override
	public void updateState(Ball context, IDispatcher<TDispMsg> dispatcher) {
		int oldRad = context.getRadius();
		int newRad = Randomizer.singleton.randomInt(Math.max(oldRad - 10, 1), Math.min(oldRad + 10, 30));
		context.setRadius(newRad);
		Point oldLoc = context.getLoc();
		context.setLoc(new Point(oldLoc.x + (oldRad - newRad), oldLoc.y + (oldRad - newRad)));
	}

}
