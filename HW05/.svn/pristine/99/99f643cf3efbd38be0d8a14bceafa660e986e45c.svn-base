package model.strategy.update;

import java.awt.Point;

import model.ball.Ball;
import util.IDispatcher;
import util.Randomizer;

/**
 * A strategy of changing the ball's velocity direction
 * @author HaoyuanYue
 * @author YiqingLu
 * @param <TDispMsg> The type of message that the supplied IDispatcher can send. 
 */
public class CurveStrategy<TDispMsg> extends AUpdateStrategy<TDispMsg> {

	/**
	 * The angle of the velocity direction change
	 */
	private double radius;

	/**
	 * Constructor of the strategy
	 */
	public CurveStrategy() {
		radius = Randomizer.singleton.randomDouble(0.2, 1);
	}

	/**
	 * Update the state of the ball
	 * @param context The ball object
	 * @param dispatcher The dispatcher 
	 */
	@Override
	public void updateState(final Ball context, IDispatcher<TDispMsg> dispatcher) {
		Point oldV = context.getVelocity();
		int oldX = oldV.x;
		int oldY = oldV.y;
		double newX = Math.round(oldX * Math.cos(radius) - oldY * Math.sin(radius));
		double newY = Math.round(oldY * Math.cos(radius) + oldX * Math.sin(radius));
		context.setVelocity(new Point((int) newX, (int) newY));
	}

}
