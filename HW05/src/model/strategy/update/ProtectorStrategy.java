package model.strategy.update;

import java.awt.geom.Point2D;
import model.IBallCmd;
import model.ball.Ball;
import util.IDispatcher;

/**
 * The protector strategy protect the ball from split or killing
 * @author HaoyuanYue
 * @author YiqingLu
 * @param <TDispMsg> The type of message that the supplied IDispatcher can send. 
 */
public class ProtectorStrategy<TDispMsg> extends CollideStrategy<IBallCmd> {

	/**
	 * Update the state of the ball
	 * @param context The ball object
	 * @param dispatcher The dispatcher 
	 */
	@Override
	public void updateState(final Ball context, IDispatcher<IBallCmd> dispatcher) {
		double protector = Math.random() * 20 + 5;
		dispatcher.dispatch(new IBallCmd() {
			@Override
			public void apply(Ball other, IDispatcher<IBallCmd> disp) {
				if (context != other) {
					double distance = context.getLoc().distance(other.getLoc());
					if ((context.getRadius() + other.getRadius() + protector) > distance) {
						double _reducedMass = reducedMass((double)(Math.pow((double)context.getRadius(), 2.0)), (double)(Math.pow((double)other.getRadius(), 2.0)));
						Point2D _impulse = impulse(context.getLoc(), context.getVelocity(), other.getLoc(), other.getVelocity(), _reducedMass, distance, 1);
						updateCollision(context, other, _impulse.getX(), _impulse.getY(), disp);
					}
				}
			}

		});
	}

}
