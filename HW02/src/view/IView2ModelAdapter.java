package view;

import java.awt.*;

/**
* The interface of the adapter from the view to the model that enables the view to talk to the model.
*/

public interface IView2ModelAdapter {

	public void paint(Graphics g);

	public void set_ball(String classname);

	public void get_canvas(Component canvas);

	public void clear();

	// other methods elided...
	/**
	 * No-op singleton implementation of IView2ModelAdapter
	 * See the web page on the Null Object Design Pattern at http://cnx.org/content/m17227/latest/
	 */

	public static final IView2ModelAdapter NULL_OBJECT = new IView2ModelAdapter() {

		public void paint(Graphics g) {
		}

		public void set_ball(String classname) {
		}

		public void get_canvas(Component canvas) {
		}

		public void clear() {
		}
	};

	// other methods similarly coded for no-op
};
