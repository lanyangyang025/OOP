package view;

import model.strategy.paint.IPaintFac;
import model.strategy.update.IStrategyFac;


/**
 * The interface of the adapter from the view to the model that enables the view to talk to the model.
 * @author YiqingLu
 * @author HaoyuanYue
 */
public interface IView2ModelAdapter<T> {

	/**
	 * Load a ball from the model
	 * @param fac the factory that will create the ball's strategy
	 * @param paint_fac the factory that will create the ball's paint strategy
	 * @param switchable if the bal's strategy can be switched
	 */
	public void loadBall(IStrategyFac<T> fac, IPaintFac paint_fac, boolean switchable);


	/**
	 * Tell model to clear all ball instance from its dispatcher
	 */
	public void clearAll();
	
	/**
	 * Add a paint factory
	 * @param text The name of the paint strategy
	 * @return A paint Factory
	 */
	public IPaintFac addPaintFac(String text);
	
	/**
	 * Add a strategy factory
	 * @param text The name of the strategy
	 * @return A strategy factory
	 */
	public IStrategyFac<T> addStrategyFac(String text);
	
	/**
	 * Add a combined factory
	 * @param selectedItem A strategy factory
	 * @param selectedItem2 A strategy factory
	 * @return A strategy factory
	 */
	public IStrategyFac<T> combineFac(IStrategyFac<T> selectedItem, IStrategyFac<T> selectedItem2);
	
	/**
	 * Switch strategy
	 * @param itemAt A strategy factory
	 */
	public void switchStrategy(IStrategyFac<T> itemAt);

	/**
	 * No-op factory implementation of IView2ModelAdapter
	 * See the web page on the Null Object Design Pattern at http://cnx.org/content/m17227/latest/
	 */
	public static final class NullFactory<T>  {

		/**
		 * Returns a no-op null strategy
		 * @return a no-op null strategy
		 */
		public IView2ModelAdapter<T> make() {
			return new IView2ModelAdapter<T>() {

				public void clearAll() { }

				public IStrategyFac<T> addStrategyFac(String text) {
					return null;
				}

				public IPaintFac addPaintFac(String text) {
					return null;
				}

				public IStrategyFac<T> combineFac(IStrategyFac<T> selectedItem, IStrategyFac<T> selectedItem2) {
					return null;
				}

				public void loadBall(IStrategyFac<T> fac, IPaintFac paint_fac, boolean switchable) { }

				public void switchStrategy(IStrategyFac<T> itemAt) { }
			};
		}
		
	}

}
