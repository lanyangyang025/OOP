package strategy;

import model.Ball;
import model.IUpdateStrategy;

/**
 * MultiStrategy is a combination of two different strategy
 * @author Renqin
 * @author Yiqing Lu
 */
public class MultiStrategy implements IUpdateStrategy {
	/**
	 * the first strategy to combine
	 */
	public IUpdateStrategy s1;
	/**
	 * the second strategy to combine
	 */
	public IUpdateStrategy s2;

	/**
	 * @param s1 the first strategy to combine
	 * @param s2 the second strategy to combine
	 */
	public MultiStrategy(IUpdateStrategy s1, IUpdateStrategy s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public void updateState(Ball ball) {
		s1.updateState(ball);
		s2.updateState(ball);
	}
}
