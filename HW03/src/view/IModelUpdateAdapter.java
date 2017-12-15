package view;

import java.awt.Component;
import java.awt.Graphics;

/**
 * The adapter that helps the BallGUI to pass the update request to the model
 * @author Renqin Yang
 * @author Yiqing Lu
 */
public interface IModelUpdateAdapter {

	/**
	 * @param g system Graphics object
	 */
	public void paint(Graphics g);

	/**
	 * @param canvas the panel where all created balls will appear on
	 */
	public void get_canvas(Component canvas);

	/**
	 * to clear all the balls on screen
	 */
	public void clear();

	/**
	 * to create a new Ball with straight strategy, it's the the first initial state of the MakeSwithcer
	 */
	public void get_Straight();

	/**
	 * No-op singleton implementation of IModelUpdateAdapter.
	 */
	public static final IModelUpdateAdapter NULL_OBJECT = new IModelUpdateAdapter() {

		public void paint(Graphics g) {
		}

		public void get_canvas(Component canvas) {
		}

		public void clear() {
		}

		public void get_Straight() {
		}
	};

}