
package controller;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

import model.BallModel;
import model.IBallCmd;
import model.IModel2ViewAdapter;
import model.strategy.paint.IPaintFac;
import model.strategy.update.IStrategyFac;
import view.BallGUI;
import view.IModelPaintAdapter;
import view.IView2ModelAdapter;

/**
 * MVC Controller for the system
 *  @author YiqingLu
 *  @author HaoyuanYue
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
	private BallGUI<IBallCmd> view;

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

		view = new BallGUI<IBallCmd>(new IView2ModelAdapter<IBallCmd>() {
			
			@Override
			public void clearAll() {
				model.clearAll();
			}

			@Override
			public IStrategyFac<IBallCmd> addStrategyFac(String text) {
				return model.addStrategyFac(text);
			}

			@Override
			public IStrategyFac<IBallCmd> combineFac(IStrategyFac<IBallCmd> f1, IStrategyFac<IBallCmd> f2) {
				return model.combineStrategyFac(f1, f2);
			}

			@Override
			public void switchStrategy(IStrategyFac<IBallCmd> fac) {
				model.switchAll(fac);
			}

			@Override
			public IPaintFac addPaintFac(String text) {
				// TODO Auto-generated method stub
				return model.addPaintFac(text);
			}

			@Override
			public void loadBall(IStrategyFac<IBallCmd> fac, IPaintFac paint_fac, boolean switchable) {
				// TODO Auto-generated method stub
				model.addABall(fac, paint_fac, switchable);
			}

		}, new IModelPaintAdapter() {
			@Override
			public void update(Graphics g) {
				model.update(g);
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
