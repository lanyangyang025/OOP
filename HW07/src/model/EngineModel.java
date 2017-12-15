package model;

import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.function.Consumer;

import provided.compute.ICompute;
import provided.compute.ILocalTaskViewAdapter;
import provided.compute.IRemoteTaskViewAdapter;
import provided.rmiUtils.IRMI_Defs;
import provided.rmiUtils.RMIUtils;

/**
 * The model class of the client, which does almost
 * all the processing of the client side
 * @author Zihan Wang, Yiqing Lu
 *
 */

public class EngineModel {

	/**
	 * A remote view adapter that enables a task or any other part of a system to display
	 * a text message on the user interface of a remote system.
	 * 
	 * This one is used for client to output message on server's view
	 */
	private IEngineViewAdapter _iModel2View;

	/**
	 * Stub of the remote ICompute object
	 */
	IRemoteTaskViewAdapter engineAdapterstub;
	
	/**
	 * The RMI Registry
	 */
	Registry registry;
	
	/**
	 * constructor of EngineModel
	 * @param _iModel2View
	 */
	public EngineModel(IEngineViewAdapter _iModel2View) {
		this._iModel2View = _iModel2View;
	}
	
	/**
	 * The command used to output the status to the text area of the engine view
	 */
	private Consumer<String> outputCmd = (x) -> _iModel2View.outputToTextArea(x + "\n");

	/**
	 * Initialize RMI with the pre-defined command
	 */
	RMIUtils rmi = new RMIUtils(outputCmd);
	
	/**
	 * Local view adapter
	 */
	private ILocalTaskViewAdapter engineTask = new ILocalTaskViewAdapter() {
		public void append(String s) {
			_iModel2View.outputToTextArea(s);
		}
	};
	
	/**
	 * Instantiate the ICompute server
	 */
	private ComputeImpl server = new ComputeImpl(outputCmd);

	/**
	 * Start the RMI Server (ICompute engine)
	 */
	public void start() {
		
		try {
			rmi.startRMI(IRMI_Defs.CLASS_SERVER_PORT_SERVER);
			
			engineTask.append("[EngineModel.start()] " +"Instantiated new Compute engine: "+server+"\n");

			ICompute stub =(ICompute) UnicastRemoteObject.exportObject(server, IRemoteTaskViewAdapter.BOUND_PORT_SERVER);
			engineTask.append("[EngineModel.start()] " +"Looking for registry..."+"\n");

			registry = rmi.getLocalRegistry();

			engineTask.append("[EngineModel.start()] " +"Found registry: "+ registry+ "\n");
			
			registry.rebind(ICompute.BOUND_NAME, stub);
			
			engineTask.append("[EngineModel.start()] " +"ComputeEngine bound to "+ICompute.BOUND_NAME+"\n");
			engineTask.append("Waiting..."+"\n");
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

		
	
	}
	

	/**
	 * Stops the engine model by unbinding the ICompute engine from the Registry 
	 * and stopping class file server.  
	 */	
	public void stop() {
		engineTask.append("[Client]: Attempting to quit...\n");
		try {
			registry.unbind(ICompute.BOUND_NAME);
			System.out.println("Unbinding the EngineController");
			rmi.stopRMI();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	/**
	 * Send string message to connected remote client using the IRemoteTaskViewAdapter STUB 
	 * received from the client..   
	 */	
	public void sendMsg(String text) {
		server.sendMsg(text);
	}
}


