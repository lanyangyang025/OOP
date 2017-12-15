package strategy;

import java.awt.Point;

import ball.Ball;
import util.Dispatcher;

/**
 * a strategy of changing one of the ball's x and y velocity
 * @author Ye Wang
 * @author Yiqing Lu
 *
 */
public class SwingStrategy implements IUpdateStrategy {

	int cnt = 5;

	public void updateState(final Ball context, Dispatcher dispatcher) {
		cnt--;
		if (cnt == 0) {
			Point oldV = context.getVelocity();
			if (Math.abs(oldV.x) > Math.abs(oldV.y)) {
				context.setVelocity(new Point(-oldV.x, oldV.y));
			} else {
				context.setVelocity(new Point(oldV.x, -oldV.y));
			}
			cnt = 5;
		}
	}

}
