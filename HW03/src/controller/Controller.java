package controller;

import view.BallGUI;
import view.IModelControlAdapter;
import view.IModelUpdateAdapter;

import java.awt.*;

import model.BallModel;
import model.IModel2ViewAdapter;
import model.IStrategyFac;

/**
 * MVC Controller for the system
 * @author Renqin Yang
 * @author Yiqing Lu
 */

public class Controller {

	// Fields for the adapters to close over:
	private BallModel model; // starts off null but will be fine when the constructor is finished.
	private BallGUI<IStrategyFac> view; // starts off null but will be fine when the constructor is finished.

	/**
	 * Controller constructor builds the system
	 */

	public Controller() {

		// Here the model is shown being constructed first then the view but it could easily be the other way around if needs dictated it.
		/**
		 *  set the model field
		 */

		model = new BallModel(new IModel2ViewAdapter() {

			@Override
			public void update() {
				view.update();
			}

			public void send_count(int count) {
				view.get_count(count);

			}

			// In the adapter code, one can reference the view field above because it is in scope.
			// It's ok that the view field is currently null because it will be set below.  Just don't start the model yet!
			// adapter methods elided
		});

		/**
		 *  set the view field
		 */
		view = new BallGUI<IStrategyFac>(new IModelControlAdapter<IStrategyFac>() {

			@Override
			public IStrategyFac addStrategy(String classname) {
				return model.makeStrategyFac(classname);
			}

			@Override
			public void makeBall(IStrategyFac selectedItem) {
				model.loadBall(selectedItem.make());
			}

			@Override
			public IStrategyFac combineStrategies(IStrategyFac selectedItem1, IStrategyFac selectedItem2) {
				return model.combineStrategyFacs(selectedItem1, selectedItem2);
			}

			@Override
			public void switchStrategy(IStrategyFac selectedItem) {
				System.out.println(selectedItem);
				model.switchSwitcherStrategy(selectedItem.make());

			}

		}, new IModelUpdateAdapter() {

			@Override
			public void paint(Graphics g) {
				model.update(g);
			}

			@Override
			public void get_canvas(Component canvas) {
				model.set_canvas(canvas);
			}

			@Override
			public void clear() {
				model.clearGUI();
			}

			@Override
			public void get_Straight() {
				model.loadBall(model.getSwitcherStrategy());
			}
		});

		// At this point, both the model and view are instantiated as well as both adapters and both adapters reference non-null model and view fields.
		// NEITHER MODEL NOR VIEW SHOULD BE STARTED YET!

	}

	/**
	 * Start the system
	 */

	public void start() {

		model.start(); // It is usually better to start the model first but not always.
		view.start();

	}

	/**
	 * Launch the application.
	 * @param args Arguments given by the system or command line.
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() { // Java specs say that the system must be constructed on the GUI event thread.
			public void run() {
				try {
					Controller controller = new Controller(); // instantiate the system
					controller.start(); // start the system
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}