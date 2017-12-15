package util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;

import provided.client.model.taskUtils.ITaskFactory;
import provided.compute.ILocalTaskViewAdapter;
import provided.compute.ITask;
import provided.compute.ITaskResultFormatter;

public class GetReverseString implements ITask<String> {
	
	/**
	 * UID for well-defined serialization
	 */
	private static final long serialVersionUID = 330L;
	
	/**
     * Adapter to the local view.  Marked "transient" so that it is not serialized
     * and instead is re-attached at the destination (the server).  
     */
	private transient ILocalTaskViewAdapter taskView = ILocalTaskViewAdapter.DEFAULT_ADAPTER;
	
	/**
	 * Input string given to the constructor
	 */
	private String input = "";
	
	/**
	 * Construct a task to get the reverse format of the input string
	 * @param input
	 */
	public GetReverseString(String input) {
		taskView.append("GetReverseString task constructing...\n");
		this.input = input;
	}
	

	/**
	   * Executes the task and returns the reverse format of the current input string
	   * @return The reverse format.
	   * @throws RemoteException  thrown when a network error occurs.
	   */
	@Override
	public String execute() throws RemoteException {
		// TODO Auto-generated method stub
		taskView.append("Excuting GetReverseString task with " + input);
		
		return new StringBuilder(input).reverse().toString();
	}
	
	/**
	 * Reinitializes transient fields upon deserialization. See the <a href=
	 * "http://download.oracle.com/javase/6/docs/api/java/io/Serializable.html">
	 * Serializable</a> marker interface docs.
	 * taskView is set to a default value for now (ILocalTaskViewAdapter.DEFAULT_ADAPTER).
	 * 
	 * @param stream
	 *            The object stream with the serialized data
     * @throws IOException if the input stream cannot be read correctly
     * @throws ClassNotFoundException if the class file associated with the input stream cannot be located.
	 */
	private void readObject(ObjectInputStream stream) throws IOException,
			ClassNotFoundException {
		stream.defaultReadObject(); // Deserialize the non-transient data
		taskView = ILocalTaskViewAdapter.DEFAULT_ADAPTER; // re-initialize the transient field
	}
	
	/**
	   * Sets the adapter to the view properly for this object.
	   * Note that this setter must be separate from the an ITask implementation's 
	   * constructor because the compute engine needs to set this adapter when
	   * it receives an ITask from a remote client. 
	   * @param viewAdapter an adapter to the view.
	   */
	@Override
	public void setTaskViewAdapter(ILocalTaskViewAdapter viewAdapter) {
		// TODO Auto-generated method stub
		this.taskView = viewAdapter;
		taskView.append("GetReverseString installed");
	}

	/**
	   * Get an instance of the matched ITaskResultFormatter for this task.
	   * Return a string of the form:
	   * "Reversed string is [result] (input = [input])"
	   * @return A formatter customized for this task object.
	   */
	@Override
	public ITaskResultFormatter<String> getFormatter() {
		// TODO Auto-generated method stub
		return new ITaskResultFormatter<String>() {

			@Override
			public String format(String result) {
				// TODO Auto-generated method stub
				return "Reversed string is " + result + " (input = " + input + ")";
			}

		};
	}

	/**
	 * An ITaskFactory for this task
	 */
	public static final ITaskFactory<String> FACTORY = new ITaskFactory<String>() {

		@Override
		public ITask<String> make(String param) {
			// TODO Auto-generated method stub
			return new GetReverseString(param);
		}
		
		@Override
		public String toString() {
			return GetReverseString.class.getName();
		}
	};
}
