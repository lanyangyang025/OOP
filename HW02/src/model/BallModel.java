package model;

import java.awt.*;

import javax.swing.Timer;

import ballworld.ABall;
import util.Dispatcher;
import util.Randomizer;

public class BallModel {

	private Component canvas;
	private int count = 0;

	public void set_canvas(Component canvas) {
		this.canvas = canvas;
	}

	private Dispatcher myDispatcher = new Dispatcher();

	/**
	 * model to view adapter
	 */
	private IModel2ViewAdapter _model2ViewAdpt = IModel2ViewAdapter.NULL_OBJECT; // Insures that the adapter is always valid

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
	 */
	public void update(Graphics g) {
		myDispatcher.notifyAll(g); // The Graphics object is being given to all the sprites (Observers)
	}

	public void start() {
		_timer.start();
	};

	/**
	* The following method returns an instance of an ABall, given a fully qualified class name (package.classname) of
	* a subclass of ABall.
	* The method assumes that there is only one constructor for the supplied class that has the same *number* of
	* input parameters as specified in the args array and that it conforms to a specific
	* signature, i.e. specific order and types of input parameters in the args array.
	* @param className A string that is the fully qualified class name of the desired object
	* @return An instance of the supplied class. 
	*/

	private ABall loadBall(String className) { // YOUR CODE MAY HAVE MORE/DIFFERENT INPUT PARAMETERS!
		try {

			int canvas_width = canvas.getWidth();
			int canvas_height = canvas.getHeight();

			int startRadius = Randomizer.Singleton.randomInt(8, 15);
			Rectangle rect = new Rectangle(canvas_width - startRadius, canvas_height - startRadius);
			Point startLoc = Randomizer.Singleton.randomLoc(rect);

			Rectangle rect_v = new Rectangle(0, 0, 10, 10);
			Point startVel = Randomizer.Singleton.randomVel(rect_v);

			Color startColor = Randomizer.Singleton.randomColor();

			Object[] args = new Object[] { startLoc, startColor, startRadius, startVel, canvas }; // YOUR CONSTRUCTOR MAY BE DIFFERENT!!   The supplied values here may be fields, input parameters, random values, etc.
			java.lang.reflect.Constructor<?> cs[] = Class.forName(className).getConstructors(); // get all the constructors

			java.lang.reflect.Constructor<?> c = null;
			for (int i = 0; i < cs.length; i++) { // find the first constructor with the right number of input parameters
				if (args.length == (cs[i]).getParameterTypes().length) {
					c = cs[i];
					break;
				}
			}
			return (ABall) c.newInstance(args); // Call the constructor.   Will throw a null ptr exception if no constructor with the right number of input parameters was found.
		} catch (Exception ex) {
			System.err.println("Class " + className + " failed to load. \nException = \n" + ex);
			ex.printStackTrace(); // print the stack trace to help in debugging.
			return null; // Is this really a useful thing to return here?  Is there something better that could be returned? 
		}
	}

	/**
	 * add a new ABall to the dispatcher, the specific class is determined by classname
	 * @classname The class name of the ball
	 */
	public void add_ball(String classname) {
		ABall new_ball = loadBall(classname);
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

}
