package strategy;

import model.Ball;
import model.IUpdateStrategy;

/**
 * SwitcherStrategy enables a ball to switch its strategy
 * @author Renqin
 * @author Yiqing Lu
 */
public class SwitcherStrategy implements IUpdateStrategy {

	private IUpdateStrategy strategy;

	/**
	 * initially construct it as straightstrategy
	 */
	public SwitcherStrategy() {
		this.strategy = new StraightStrategy();
	}

	@Override
	public void updateState(Ball the_ball) {
		strategy.updateState(the_ball);
	}

	/**
	 * @param strategy the strategy which is going to switch
	 */
	public void setStrategy(IUpdateStrategy strategy) {
		this.strategy = strategy;
	}
}
