package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.function.Consumer;

import provided.compute.IRemoteTaskViewAdapter;
import provided.compute.ITask;
import provided.compute.ICompute;
import provided.compute.ILocalTaskViewAdapter;


/**
 * The model class of the client, which does almost
 * all the processing of the client side
 * @author Zihan Wang, Yiqing Lu
 *
 */

/**
 * Implementation of an ICompute engine
 */
public class ComputeImpl implements ICompute{
	
	/**
	 * The command used to output the status to the text area of the engine view
	 */
	private Consumer<String> outputCmd;

	/**
	 * stub of remote ICompute object
	 */
	IRemoteTaskViewAdapter engineAdapterstub;

	
	/**
	 * constructor of ComputeImpl
	 * @param outputCmd
	 */
	public ComputeImpl(Consumer<String> outputCmd) {
		this.outputCmd = outputCmd;
		System.out.println(outputCmd);
	}
	
	
	/**
	 * local task view adapter
	 */
	private ILocalTaskViewAdapter engineTask = new ILocalTaskViewAdapter() {
		public void append(String s) {
			outputCmd.accept(s);
		}
	};

	private IRemoteTaskViewAdapter clientTVAStub;
	
	/**
	 * execute the task and print the result
	 * @param t task
	 * @return The result of the task
	 * @throws RemoteException
	 */
	
	@Override
	public <T> T executeTask(ITask<T> t) throws RemoteException {
		// TODO Auto-generated method stub
		T res = null;
		try {
			t.setTaskViewAdapter(engineTask);
			outputCmd.accept("[ComputeEngine.executeTask()] " +"Executing task:" + t);
			res = t.execute();
			outputCmd.accept("[ComputeEngine.executeTask()] " +"Task result =" + res);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * display info of the engine on client's view
	 * @param clientTVAStub
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public IRemoteTaskViewAdapter setTextAdapter(IRemoteTaskViewAdapter clientTVAStub) throws RemoteException {
		this.clientTVAStub = clientTVAStub;
		
		engineTask.append("[ComputerEngine.setTextAdapter()] "+"Got text adapter: " + clientTVAStub);

		IRemoteTaskViewAdapter engineAdapter = new IRemoteTaskViewAdapter() {
			public void append(String s) {
				engineTask.append("[Client] " + s);
			}
		};

		
		try {
			engineAdapterstub = (IRemoteTaskViewAdapter) UnicastRemoteObject
					.exportObject(engineAdapter, IRemoteTaskViewAdapter.BOUND_PORT_SERVER);
			return engineAdapterstub;   // return the remote view adapter
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	
	
	/**
	 * Send string message to connected remote client using the IRemoteTaskViewAdapter STUB 
	 * received from the client..   
	 */	
	
	public void sendMsg(String text) {
		engineTask.append("[Sending msg to connected remote client]" +" Sending msg to connected remote client." 
				+" (msg =" +text +")");
		try {
			clientTVAStub.append(text);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
