package model;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.function.Consumer;

import common.IChatRoom;
import common.IFailureStatusType;
import common.IUser;
import provided.rmiUtils.IRMIUtils;
import provided.rmiUtils.RMIUtils;
import view.ChatroomView;

/**
 * Model for the chat application
 *
 */
public class MainModel {
	/**
	 * Adapter to the view
	 */
	IModel2ViewAdapter adapter;

	/**
	 * Registry entries
	 */
	Registry registry;

	String remoteHost;
	IFailureStatusType failure;

	private Consumer<String> outputCmd = (x) -> adapter.outputToTextArea(x + "\n");

	private IRMIUtils rmi = new RMIUtils(outputCmd);

	public MainModel(IModel2ViewAdapter adapter) {
		this.adapter = adapter;
	}

	private IUser userStub;
	private User user;
	private String ip;

	private int USER_BOUND_PORT = 2101;
	private int SERVER_BOUND_PORT = 2000;

	public void initUser(String name) {

		USER_BOUND_PORT = adapter.getUserPort();
		SERVER_BOUND_PORT = adapter.getServerPort();
		rmi.startRMI(SERVER_BOUND_PORT);

		try {
			user = new User(name + "@" + rmi.getLocalAddress(), adapter);
			ip = rmi.getLocalAddress();
			adapter.setRemoteAdress(ip);
			userStub = (IUser) UnicastRemoteObject.exportObject(user, USER_BOUND_PORT);
			registry = rmi.getLocalRegistry();

			registry.rebind(IUser.BOUND_NAME + name + "@" + rmi.getLocalAddress(), userStub);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public IUser getUser(String remoteHost, String name) {
		try {
			this.remoteHost = remoteHost;
			registry = rmi.getRemoteRegistry(remoteHost);
			IUser newUser = (IUser) registry.lookup(IUser.BOUND_NAME + name + "@" + remoteHost);
			if (user.containUser(newUser)) {
				return null;
			}
			userStub.connect(newUser);
			newUser.connect(user);
			return newUser;
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void createChatRoom(String s) {
		ChatroomView temp_room = user.createChatRoom(s, USER_BOUND_PORT);
		if (temp_room == null) {

		} else {
			adapter.addTab(temp_room);
		}
	}

	public Collection<IChatRoom> getChatRoom(IUser iUser) {
		// TODO Auto-generated method stub
		try {
			return iUser.getChatRooms();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void joinChatRoom(IChatRoom request_room) {
		// TODO Auto-generated method stub
		ChatroomView temp_room = user.joinChatRoom(request_room, USER_BOUND_PORT);

		if (temp_room == null) {

		} else {
			adapter.addTab(temp_room);
		}

	}

	public void leaveChatRoom(IChatRoom chatroom) {
		// TODO Auto-generated method stub
		user.leaveChatRoom(chatroom);
	}

}
