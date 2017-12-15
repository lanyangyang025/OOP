/**
 * 
 */
package yl128_pg23.model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import common.IChatRoom;
import common.IReceiver;
import provided.mixedData.IMixedDataDictionary;

/**
 * @author Yiqing Lu, Peisheng Guo
 *
 */
public class ChatRoomManager {

	private transient List<ChatRoom> connCRs;
	private IViewAdapter adpt;
	private User user;
	private Set<Connect> selfReceiverHolder;
	private transient IMixedDataDictionary mixDict;

	public ChatRoomManager(IViewAdapter adpt, User user, IMixedDataDictionary mixDict) {
		connCRs = new ArrayList<ChatRoom>();
		this.adpt = adpt;
		this.user = user;
		selfReceiverHolder = new HashSet<Connect>();
		this.mixDict = mixDict;
	}

	/**
	 * @return
	 */
	public List<ChatRoom> getCRList() {
		return connCRs;
	}

	/**
	 * leave the chatroom and close the chatroom window
	 * @param cw
	 */
	public void leaveCR(ChatWindow cw) {
		ChatRoom target = null;
		for (ChatRoom cr : connCRs) {
			if (cr.getUUID().equals(cw.getUUID())) {
				target = cr;
			}
		}
		if (target != null) {
			target.leave();
			connCRs.remove(target);
		}
	}

	/**
	 * create the chatroom by the existed chatroom info
	 * @param chatModel 
	 * @param chatRoom 
	 * 
	 */
	public ChatWindow createCR(IChatRoom cr, ChatModel chatModel) {
		for (ChatRoom c : connCRs) {
			if (c.getUUID().equals(cr.getUUID()))
				return null;
		}
		return initCR(new ChatRoom(cr, mixDict), chatModel);
	}

	/**
	 * create the chatroom by string
	 * @param userName
	 * @param chatModel
	 * @return
	 */
	public ChatWindow createCR(String userName, ChatModel chatModel) {
		ChatRoom new_room = new ChatRoom(userName + ":" + connCRs.size(), mixDict);
		return initCR(new_room, chatModel);
	}

	private ChatWindow initCR(ChatRoom cr, ChatModel chatModel) {
		IReceiver conn = null;
		try {
			Connect new_conn = new Connect(cr, adpt, user);
			selfReceiverHolder.add(new_conn);
			conn = (IReceiver) UnicastRemoteObject.exportObject(new_conn, 0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if (conn != null) {
			ChatRoomControl crc = new ChatRoomControl(cr, chatModel);
			cr.setSelf(conn);
			connCRs.add(cr);
			return crc.getChatWindow();
			//adpt.addConnCR(cr);
		} else {
			return null;
		}
	}

	/**
	 * shutdown the chat app
	 */
	public void shutdown() {
		for (ChatRoom cr : connCRs) {
			cr.leave();
		}

	}

	/**
	 * get chatroom from uuid
	 * @param uuid uuid of the targeted chatroom
	 * @return
	 */
	public ChatRoom getCR(UUID uuid) {
		for (ChatRoom cr : connCRs) {
			if (cr.getUUID().equals(uuid))
				return cr;
		}
		return null;
	}

}
