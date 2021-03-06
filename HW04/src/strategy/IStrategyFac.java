package strategy;

/**
 * the factory that makes a strategy at a time
 * @author Ye Wang
 * @author Yiqing Lu
 *
 */
public abstract class IStrategyFac {

	/**
	 * abstract method to make a strategy
	 * @return the newly made strategy
	 */
	public abstract IUpdateStrategy make();

}
