
package controller;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

import model.BallModel;
import model.IModel2ViewAdapter;
import model.strategy.IPaintFac;
import strategy.IStrategyFac;
import view.BallGUI;
import view.IView2ModelAdapter;

/**
 * MVC Controller for the system
 *  @author Yiqing Lu
 *  @author Ye Wang
 */
public class Controller {
	// Fields for the adapters to close over:

	/**
	 * model of MVC system
	 */
	private BallModel model;

	/**
	 * view of MVC system
	 */
	private BallGUI view;

	/**
	 * constructor of the controller
	 */
	public Controller() {

		model = new BallModel(new IModel2ViewAdapter() {
			@Override
			public void update() {
				view.update();
			}

			@Override
			public Component getComponent() {
				return view.getCenterPanel();
			}

		});

		view = new BallGUI(new IView2ModelAdapter() {
			@Override
			public void update(Graphics g) {
				model.update(g);
			}

			@Override
			public void clearAll() {
				model.clearAll();
			}

			@Override
			public IStrategyFac addStrategyFac(String text) {
				return model.addStrategyFac(text);
			}

			@Override
			public IStrategyFac combineFac(IStrategyFac f1, IStrategyFac f2) {
				return model.combineStrategyFac(f1, f2);
			}

			@Override
			public void switchStrategy(IStrategyFac fac) {
				model.switchAll(fac);
			}

			@Override
			public IPaintFac addPaintFac(String text) {
				// TODO Auto-generated method stub
				return model.addPaintFac(text);
			}

			@Override
			public void loadBall(IStrategyFac fac, IPaintFac paint_fac, boolean switchable) {
				// TODO Auto-generated method stub
				model.addABall(fac, paint_fac, switchable);
			}

		});

	}

	/**
	 * Start the system
	 */
	public void start() {
		model.start();
		view.start();
	}

	/**
	 * Launch the application.
	 * @param args Arguments given by the system or command line.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller controller = new Controller();
					controller.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
