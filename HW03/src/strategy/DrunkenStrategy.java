package strategy;

import java.awt.Rectangle;

import model.Ball;
import model.IUpdateStrategy;
import util.Randomizer;

/**
 * The DrunkenStrategy will make a ball randomly  change its velocity at a random time interval
 * @author Renqin
 * @author Yiqing Lu
 */
public class DrunkenStrategy implements IUpdateStrategy {
	private int Interval = Randomizer.Singleton.randomInt(5, 30);

	public void updateState(Ball ball) {
		Interval--;
		if (Interval == 0) {
			ball.set_velocity(Randomizer.Singleton.randomVel(new Rectangle(0, 0, 10, 10)));
			Interval = Randomizer.Singleton.randomInt(5, 30);
		}
	}
}
