package util;

/**
 * A CopyOnWriteArraySet-based IDispatcher that dispatches to its IObservers in parallel.
 * 
 * @author Stephen Wong
 * @author Derek Peirce
 *
 * @param <TDispMsg> The type of message sent to the registered IObservers
 */
public class SetDispatcherParallel<TDispMsg> extends ASetDispatcher<TDispMsg> {

	/**
	 * Attempts to perform parallel dispatching of the message to the collection of IObservers.  
	 * Note that parallel execution is not guaranteed.
	 * @param msg The message to be dispatcher
	 */
	@Override
	public void dispatch(TDispMsg msg) {
		getCollection().parallelStream().forEach(o -> {
			o.update(this, msg);
		});
	}
}