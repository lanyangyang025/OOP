package controller;

import java.awt.EventQueue;

import model.ClientModel;
import model.IClientViewAdapter;
import provided.client.model.taskUtils.ITaskFactory;
import provided.compute.ITask;
import view.ClientView;
import view.IClientModelAdapter;

/**
 * Controller of Client
 * @author Zihan Wang, Yiqing Lu
 *
 */
public class ClientControl {
	/**
	 * Client View
	 */
	private ClientView clientView;
	
	/**
	 * Client Model
	 */
	private ClientModel clientModel;
	
	/**
	 * Client Controller construction
	 * Called when is being run
	 */
	public ClientControl() {
		clientView = new ClientView(new IClientModelAdapter() {

			@Override
			public void quit() {
				// TODO Auto-generated method stub
				clientModel.stop();
			}

			@Override
			public void init() {
				// TODO Auto-generated method stub
				clientModel.start();
			}

			@Override
			public String connect(String remoteIP) {
				// TODO Auto-generated method stub
				return clientModel.connectTo(remoteIP);
			}

			@Override
			public void sendMsgToComputeEngine(String text) {
				// TODO Auto-generated method stub
				clientModel.sendMsgToComputeEngine(text);
			}

			@Override
			public ITaskFactory<?> addTask(String task) {
				// TODO Auto-generated method stub
				return clientModel.addTask(task);
			}

			@Override
			public <T> String runTask(ITask<T> task) {
				// TODO Auto-generated method stub
				return clientModel.runTask(task);
			}

			@Override
			public ITaskFactory<?> combineTask(ITaskFactory<?> task1, ITaskFactory<?> task2, String param) {
				// TODO Auto-generated method stub
				return clientModel.combineTask(task1, task2, param);
			}
			
		});
		
		clientModel = new ClientModel(new IClientViewAdapter() {

			@Override
			public void outputToTextArea(String string) {
				// TODO Auto-generated method stub
				clientView.outputToTextArea(string);
			}

			@Override
			public void setRemoteAdress(String address) {
				// TODO Auto-generated method stub
				clientView.setRemoteAdress(address);
			}
			
		});
	}
	
	
	/**
	 * start the client application by starting the model and view
	 */
	public void start() {
		clientView.start();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					ClientControl controller = new ClientControl();
					controller.start(); // start the system
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
