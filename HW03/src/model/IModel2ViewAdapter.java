package model;

/**
 * The adapter helps Ballmodel to communicate with BallGUI
 * @author Renqin
 * @author Yiqing Lu
 */
public interface IModel2ViewAdapter {
	/**
	 * 
	 */
	public void update();

	/**
	 * @param count the count of the all balls on screen
	 */
	public void send_count(int count);

	/**
	 * No-op "null" adapter
	 * See the web page on the Null Object Design Pattern at http://cnx.org/content/m17227/latest/
	 */

	public static final IModel2ViewAdapter NULL_OBJECT = new IModel2ViewAdapter() {
		public void update() {
		}

		public void send_count(int count) {
		}
	};

}
