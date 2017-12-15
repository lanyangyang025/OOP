/**
 * 
 */
package yl128_pg23.model;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JPanel;
import common.IChatRoom;
import common.IUser;
import provided.rmiUtils.IRMI_Defs;
import provided.rmiUtils.RMIUtils;

/**
 * @author Yiqing Lu, Peisheng Guo
 *  *
 */

/**
 * Chatroom Model
 *
 */
public class ChatModel {

	private RMIUtils _rmiUtil;
	private IViewAdapter adpt;
	private IUser selfStub;
	private User selfRemote;
	private String localIP;

	public ChatModel(IViewAdapter adpt) {
		this.adpt = adpt;
	}

	/**
	 * start the application
	 */
	public void start() {

		try {
			Consumer<String> welcomeMsg = new Consumer<String>() {

				@Override
				public void accept(String t) {
				}

			};
			_rmiUtil = new RMIUtils(welcomeMsg);
			_rmiUtil.startRMI(IRMI_Defs.CLASS_SERVER_PORT_CLIENT);

			localIP = _rmiUtil.getLocalAddress();
			selfRemote = new User(localIP, adpt);
			selfStub = (IUser) UnicastRemoteObject.exportObject(selfRemote, 0);
			Registry registry = _rmiUtil.getLocalRegistry();
			registry.rebind(IUser.BOUND_NAME, selfStub);
		} catch (Exception e) {
			System.err.println("start exception:");
			e.printStackTrace();
		}
	}

	/**
	 * connect the user by ip address
	 * @param addr ip address
	 */
	public void connectPeer(String addr) {
		if (addr.equals(localIP)) {
			return;
		}

		try {
			Registry registry = _rmiUtil.getRemoteRegistry(addr);
			IUser remoteStub = (IUser) registry.lookup(IUser.BOUND_NAME);
			if (selfRemote.exists(remoteStub)) {
				return;
			}
			remoteStub.connect(selfStub);
			selfRemote.connect(remoteStub);

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}

	/**
	 * set the user name
	 * @param name user name
	 */
	public void setSelfName(String name) {
		selfRemote.setUserName(name);
	}

	/**
	 * create a chatroom window
	 * @return chatroom window
	 */
	public ChatWindow createCR() {
		return selfRemote.createCR(this);

	}

	/**
	 * join the chatroom and create the window
	 * @param iPeer the owner of the chatroom
	 * @param cr the chatroom
	 * @return chatroom window
	 */
	public ChatWindow joinCR(IUser iPeer, IChatRoom cr) {
		return selfRemote.joinCR(iPeer, cr, this);
	}

	/**
	 * get the room list of the connected user
	 * @param iPeer the connected user
	 * @return room list
	 */
	public List<IChatRoom> fetchCRList(IUser iPeer) {
		List<IChatRoom> list = new ArrayList<IChatRoom>();
		try {
			Iterable<IChatRoom> rooms = iPeer.getChatRooms();
			for (IChatRoom cr : rooms) {
				list.add(cr);
			}
			return list;
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ArrayList<IChatRoom>();
		}
	}

	/**
	 * get local ip address
	 * @return ip address
	 */
	public String getIP() {
		try {
			return _rmiUtil.getLocalAddress();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return "N/A";
	}

	/**
	 * get user name
	 * @return user name
	 */
	public String getUserName() {
		return selfRemote.getName();
	}

	/**
	 * leave the chatroom
	 * @param icr the chatroom to leave
	 */
	public void leaveCR(JPanel icr) {
		selfRemote.leaveCR((ChatWindow) icr);
	}

	/*
	public void shutdown() {
		selfRemote.shutdown();
		
	}
	*/
	/**
	 * @param icr
	* 	 * @param i
	* 	 * @param text
	 */
	public void sendDataPacket(IChatRoom icr, String dpType, String text) {
		((ChatRoom) icr).sendDataPacket(dpType, text);

	}

	/**
	 * add new user by ip address
	 * @param text the ip address of the added user
	 * @return the user we get
	 */
	public IUser addUser(String text) {
		// TODO Auto-generated method stub
		if (text.equals(localIP)) {
			return null;
		}

		try {
			Registry registry = _rmiUtil.getRemoteRegistry(text);
			IUser remoteStub = (IUser) registry.lookup(IUser.BOUND_NAME);
			remoteStub.connect(selfStub);
			selfRemote.connect(remoteStub);
			return remoteStub;
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
		return null;
	}

}
