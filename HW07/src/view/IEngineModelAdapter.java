package view;

/**
 * View to Model Adapter of Engine
 * @author Zihan Wang, Yiqing Lu
 *
 */
public interface IEngineModelAdapter {
	
	/**
	 * Quit server and close RMI 
	 */
	public void quit();
	
	/**
	 * Sends a string message to the connected client using the IRemoteTaskViewAdapter STUB
	 * received from the client.   This message should also be echoed to the local user interface.
	 * @param text The message to be sent
	 */
	public void sendMsg(String s);
}
