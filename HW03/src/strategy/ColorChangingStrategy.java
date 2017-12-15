package strategy;

import model.Ball;
import model.IUpdateStrategy;
import util.Randomizer;

/**
 * ColorChangingStrategy will make a ball randomly change its color every tick
 * @author Renqin
 * @author Yiqing Lu
 */
public class ColorChangingStrategy implements IUpdateStrategy {

	@Override
	public void updateState(Ball ball) {
		// TODO Auto-generated method stub
		ball.color = Randomizer.Singleton.randomColor();
	}

}
