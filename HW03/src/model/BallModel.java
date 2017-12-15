package model;

import java.awt.*;

import javax.swing.Timer;

import util.Dispatcher;
import util.Randomizer;
import strategy.MultiStrategy;
import strategy.SwitcherStrategy;

/**
 * the BallModel part of the whole application
 * @author Renqin Yang
 * @author Yiqing Lu
 */
public class BallModel {

	/**
	 * the SwitcherStrategy which enables a ball to switch its strategy
	 */
	public SwitcherStrategy switch_strategy;
	private Component canvas;
	private int count = 0;

	/**
	 * @param canvas the panel where all the ball appear
	 */
	public void set_canvas(Component canvas) {
		this.canvas = canvas;
	}

	private Dispatcher myDispatcher = new Dispatcher();

	/**
	 * model to view adapter
	 */
	private IModel2ViewAdapter _model2ViewAdpt = IModel2ViewAdapter.NULL_OBJECT; // Insures that the adapter is always valid

	/**
	 * @param model2ViewAdpt the adapter enables model to communicate with BallGUI part
	 */
	public BallModel(IModel2ViewAdapter model2ViewAdpt) {
		this._model2ViewAdpt = model2ViewAdpt;
	}

	private int _timeSlice = 50; // update every 50 milliseconds
	private Timer _timer = new Timer(_timeSlice, (e) -> {
		_model2ViewAdpt.update();
		_model2ViewAdpt.send_count(count);
	});

	/**
	 * add or remove balls, and tell balls when to move
	 * @param g systems Graphics object
	 */
	public void update(Graphics g) {
		myDispatcher.notifyAll(g); // The Graphics object is being given to all the sprites (Observers)
	}

	/**
	 * Start the whole application
	 */
	public void start() {
		_timer.start();
	}

	/**
	* The following method returns an instance of an ABall, given a fully qualified class name (package.classname) of
	* a subclass of ABall.
	* The method assumes that there is only one constructor for the supplied class that has the same *number* of
	* input parameters as specified in the args array and that it conforms to a specific
	* signature, i.e. specific order and types of input parameters in the args array.
	* @param className A string that is the fully qualified class name of the desired object
	* @return An instance of the supplied class. 
	*/

	private IUpdateStrategy loadStrategy(String strategy) { // YOUR CODE MAY HAVE MORE/DIFFERENT INPUT PARAMETERS!
		try {
			Object[] args = new Object[] {}; // YOUR CONSTRUCTOR MAY BE DIFFERENT!!   The supplied values here may be fields, input parameters, random values, etc.
			java.lang.reflect.Constructor<?> cs[] = Class.forName(fixName(strategy)).getConstructors(); // get all the constructors

			java.lang.reflect.Constructor<?> c = null;
			for (int i = 0; i < cs.length; i++) { // find the first constructor with the right number of input parameters
				if (args.length == (cs[i]).getParameterTypes().length) {
					c = cs[i];
					break;
				}
			}
			return (IUpdateStrategy) c.newInstance(args); // Call the constructor.   Will throw a null ptr exception if no constructor with the right number of input parameters was found.
		} catch (Exception ex) {
			System.err.println("Class " + strategy + " failed to load. \nException = \n" + ex);
			ex.printStackTrace(); // print the stack trace to help in debugging.
			return null; // Is this really a useful thing to return here?  Is there something better that could be returned? 
		}
	}

	/**
	 * Returns an IStrategyFac that can instantiate the strategy specified by
	 * classname. Returns a factory for a beeping error strategy if classname is null. 
	 * The toString() of the returned factory is the classname.
	 * 
	 * @param classname  Shortened name of desired strategy
	 * @return A factory to make that strategy
	 */

	public String fixName(String classname) {
		return "strategy." + classname + "Strategy";
	}

	/**
	 * @param classname the shorten strategy name of the desired strategy
	 * @return a specific strategy factory object which is able to produce the desired strategy
	 */
	public IStrategyFac makeStrategyFac(final String classname) {
		if (null == classname) {
			System.out.println("haha");
			return _errorStrategyFac;
		}

		return new IStrategyFac() {
			/**
			 * Instantiate a strategy corresponding to the given class name.
			 * @return An IUpdateStrategy instance
			 */
			public IUpdateStrategy make() {
				return loadStrategy(classname);
			}

			/**
			 * Return the given class name string
			 */
			public String toString() {
				return classname;
			}
		};
	}

	/**
	 * Returns an IStrategyFac that can instantiate a MultiStrategy with the two
	 * strategies made by the two given IStrategyFac objects. Returns null if
	 * either supplied factory is null. The toString() of the returned factory
	 * is the toString()'s of the two given factories, concatenated with "-". 
	 * If either factory is null, then a factory for a beeping error strategy is returned.
	 * 
	 * @param stratFac1 An IStrategyFac for a strategy
	 * @param stratFac2 An IStrategyFac for a strategy
	 * @return An IStrategyFac for the composition of the two strategies
	 */
	public IStrategyFac combineStrategyFacs(final IStrategyFac stratFac1, final IStrategyFac stratFac2) {
		System.out.println(stratFac1);
		if (null == stratFac1 || null == stratFac2)
			return _errorStrategyFac;
		return new IStrategyFac() {
			/**
			 * Instantiate a new MultiStrategy with the strategies from the given strategy factories
			 * @return A MultiStrategy instance
			 */
			public IUpdateStrategy make() {
				return new MultiStrategy(stratFac1.make(), stratFac2.make());
			}

			/**
			 * Return a string that is the toString()'s of the given strategy factories concatenated with a "-"
			 */
			public String toString() {
				return stratFac1.toString() + "-" + stratFac2.toString();
			}
		};
	}

	/**
	 * @return the strategy of the switcher
	 */
	public IUpdateStrategy getSwitcherStrategy() {
		if (switch_strategy == null) {
			switch_strategy = new SwitcherStrategy();
		}
		return switch_strategy;
	}

	/**
	 * @param strat the strategy which all switcher are going to switch on
	 */
	public void switchSwitcherStrategy(IUpdateStrategy strat) {
		switch_strategy.setStrategy(strat);
	}

	/**
	 * add a new ABall to the dispatcher, the specific class is determined by strategy
	 * @param strategy the strategy of the ball which is going to be load
	 */
	public void loadBall(IUpdateStrategy strategy) {

		int canvas_width = canvas.getWidth();
		int canvas_height = canvas.getHeight();

		int startRadius = Randomizer.Singleton.randomInt(8, 15);
		Rectangle rect = new Rectangle(canvas_width - startRadius, canvas_height - startRadius);
		Point startLoc = Randomizer.Singleton.randomLoc(rect);

		Rectangle rect_v = new Rectangle(0, 0, 10, 10);
		Point startVel = Randomizer.Singleton.randomVel(rect_v);

		Color startColor = Randomizer.Singleton.randomColor();
		Ball new_ball = new Ball(startLoc, startColor, startRadius, startVel, canvas);

		new_ball.setStrategy(strategy);

		myDispatcher.addObserver(new_ball);
		count = myDispatcher.countObservers();
	}

	/**
	 * delete all the observers in the dispatcher
	 */
	public void clearGUI() {
		myDispatcher.deleteObservers();
		count = myDispatcher.countObservers();
	}

	private IStrategyFac _errorStrategyFac = new IStrategyFac() {
		@Override
		/**
		 * Make the beeping error strategy
		 * @return  An instance of a beeping error strategy
		 */
		public IUpdateStrategy make() {
			return new IUpdateStrategy() {
				private int count = 0; // update counter

				@Override
				/**
				 * Beep the speaker every 25 updates
				 */
				public void updateState(Ball context) {
					if (25 < count++) {
						java.awt.Toolkit.getDefaultToolkit().beep();
						count = 0;
					}
				}
			};
		}
	};

}