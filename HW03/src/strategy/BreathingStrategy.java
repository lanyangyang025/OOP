package strategy;

import model.Ball;
import model.IUpdateStrategy;
import util.Randomizer;
import util.SineMaker;

/**
 * BreathingStrategy will make a ball change its radius back and forth
 * @author Renqin Yang
 * @author Yiqing Lu
 *
 */
public class BreathingStrategy implements IUpdateStrategy {
	double min = -Randomizer.Singleton.randomDouble(3, 6);
	double max = -min;
	double delta = Randomizer.Singleton.randomDouble(Math.PI / 10, Math.PI / 5);
	SineMaker sine = new SineMaker(min, max, delta);

	@Override
	public void updateState(Ball ball) {
		ball.radius += sine.getIntVal();
	}

}
