package view;

import java.awt.Graphics;

/**
 * An interface that talks to model to paint
 * @author HaoyuanYue
 * @author YiqingLu
 */
public interface IModelPaintAdapter {
	/**
	 * Tell the model to update
	 * @param g graphics
	 */
	public void update(Graphics g);
	
	/**
	 * Null factory to make a no-op IModelPaintAdatper
	 * @author HaoyuanYue
	 *
	 */
	public static class NullFactory {
		/**
		 * Make a no-op IModelPaintAdapter
		 * @return A no-op IModelPaintAdapter
		 */
		public IModelPaintAdapter make() {
			return new IModelPaintAdapter() {
				public void update(Graphics g) { }
			};
		}
	}
}
