package model;

/**
 * Update the state of the ball with the desired strategy
 * @author Renqin Yang
 * @author Yiqing Lu
 */
public interface IUpdateStrategy {
	/**
	 * @param ball the ball which is going to update its state
	 */
	public void updateState(Ball ball);

}
