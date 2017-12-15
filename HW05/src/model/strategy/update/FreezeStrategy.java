package model.strategy.update;

import java.awt.Point;
import java.util.HashMap;

import model.IBallCmd;
import model.ball.Ball;
import util.IDispatcher;

/**
 * The strategy that the ball will freeze the other balls within an area
 * @author HaoyuanYue
 * @author YiqingLu
 * @param <TDispMsg> The type of message that the supplied IDispatcher can send. 
 */
public class FreezeStrategy<TDispMsg> extends AUpdateStrategy<IBallCmd>{
	/**
	 * HashMap to store the speed of each ball
	 */
	private HashMap<Ball, Point> targetVelocity = new HashMap<Ball, Point>();
	
	/**
	 * Update the state of the ball
	 * @param context The ball object
	 * @param disp The dispatcher 
	 */
	@Override
	public void updateState(Ball context, IDispatcher<IBallCmd> disp){
		disp.dispatch(new IBallCmd() {
			@Override
			public void apply(Ball other, IDispatcher<IBallCmd> disp) {
				if (context != other) {
					double distance = context.getLoc().distance(other.getLoc());
					if ((context.getRadius() + other.getRadius()) > distance) {
						if (targetVelocity.get(other) == null) {
							targetVelocity.put(other, new Point(other.getVelocity().x, other.getVelocity().y));
							other.setVelocity(new Point((int)(targetVelocity.get(other).x * 0.5), (int)(targetVelocity.get(other).y * 0.5)));
						} else {
							other.setVelocity(new Point((int)(targetVelocity.get(other).x * 0.5), (int)(targetVelocity.get(other).y * 0.5)));
						}
					} else {
						if (targetVelocity.get(other) != null) {
							other.setVelocity(targetVelocity.get(other));
						}
					}
				}
			}
		});
	}
}