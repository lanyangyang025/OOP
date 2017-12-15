package model.strategy.update;

/**
 * The factory that makes a strategy at a time
 * @author HaoyuanYue
 * @author YiqingLu
 * @param <TDispMsg> The type of message that the supplied IDispatcher can send. 
 */
public interface IStrategyFac<TDispMsg> {

	/**
	 * Abstract method to make a strategy
	 * @return the newly made strategy
	 */
	public abstract IUpdateStrategy<TDispMsg> make();

}
