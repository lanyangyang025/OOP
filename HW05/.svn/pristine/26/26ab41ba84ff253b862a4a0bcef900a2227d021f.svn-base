package model.strategy.update;

import java.awt.Color;

import model.ball.Ball;
import util.IDispatcher;
import util.Randomizer;

/**
 * A strategy of changing the ball's color
 * @author HaoyuanYue
 * @author YiqingLu
 * @param <TDispMsg> The type of message that the supplied IDispatcher can send. 
 */
public class ColorStrategy<TDispMsg> extends AUpdateStrategy<TDispMsg> {
	
	/**
	 * Update the state of the ball
	 * @param context The ball object
	 * @param dispatcher The dispatcher 
	 */
	@Override
	public void updateState(final Ball context, IDispatcher<TDispMsg> dispatcher) {
		Color newColor = Randomizer.singleton.randomColor();
		context.setColor(newColor);
	}

}
