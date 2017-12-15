package view;

/**
* The interface of the adapter from the view to the model that enables the view to talk to the model.
 * @param <TDropListItem> the droplist Item
*/

public interface IModelControlAdapter<TDropListItem> {

	/**
	 * Take the given short strategy name and return a DropListItem to put into both drop lists.
	 * @param classname  The shortened class name of the specific strategy
	 * @return DroplistItem and put it into both the drop lists.
	 */
	public TDropListItem addStrategy(String classname);

	/**
	 * Make a ball with the selected short strategy name.
	 * @param selectedItem  A shorten class name for the desired strategy
	 */
	public void makeBall(TDropListItem selectedItem);

	/**
	 * Return a new object to put on both lists, given two items from the lists.
	 * @param selectedItem1  An object from one drop list
	 * @param selectedItem2 An object from the other drop list
	 * @return An object to put back on both lists.
	 */
	public TDropListItem combineStrategies(TDropListItem selectedItem1, TDropListItem selectedItem2);

	/**
	 * @param selectedItem the selected DropListItem
	 */
	public void switchStrategy(TDropListItem selectedItem);
}