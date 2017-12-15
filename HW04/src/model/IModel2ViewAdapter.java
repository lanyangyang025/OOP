
package model;

import java.awt.Component;

/**
 * Interface that from Ball Model to View that enables model to talk to view
 * @author Yiqing Lu
 * @author Ye Wang
 */
public interface IModel2ViewAdapter {
	/**
	 * method that tell view to update
	 */
	public void update();

	/**
	 * get Canvas from view
	 * @return canvas
	 */
	public Component getComponent();

	/**
	 * No-op "null" adapter
	 * See the web page on the Null Object Design Pattern at http://cnx.org/content/m17227/latest/
	 */
	public static final IModel2ViewAdapter NULL_OBJECT = new IModel2ViewAdapter() {
		/**
		 * method that tell view to update
		 */
		public void update() {

		}

		/**
		 * get Canvas from view
		 * @return canvas
		 */
		public Component getComponent() {
			return null;
		}

	};

}
