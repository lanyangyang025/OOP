package model;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import common.IChatRoom;
import common.IUser;
import view.ChatroomView;

public class User implements IUser {

	Set<IUser> user_list = new HashSet<>();

	String username;

	UUID id = UUID.randomUUID();
	transient IModel2ViewAdapter adapter;
	transient ChatRoomImpl roomImpl;

	public User(String name, IModel2ViewAdapter adapter) {
		// TODO Auto-generated constructor stub
		this.username = name;
		this.adapter = adapter;
		roomImpl = new ChatRoomImpl(adapter, this);

	}

	@Override
	public String getName() throws RemoteException {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public UUID getUUID() throws RemoteException {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public Collection<IChatRoom> getChatRooms() throws RemoteException {
		// TODO Auto-generated method stub
		return new ArrayList<IChatRoom>(roomImpl.getChatRoomList());
	}

	@Override
	public void connect(IUser userStub) throws RemoteException {
		// TODO Auto-generated method stub
		user_list.add(userStub);
		adapter.addtoConnectUser(userStub);

	}

	public boolean containUser(IUser user) {

		try {
			if (id.equals(user.getUUID())) {
				return true;
			}
			for (IUser user_temp : user_list) {

				if (user.getUUID().equals(user_temp.getUUID())) {
					return true;
				}

			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public ChatroomView createChatRoom(String s, int USER_BOUND_PORT) {
		// TODO Auto-generated method stub
		ChatRoom new_chatroom = new ChatRoom(username + ":" + s);
		return roomImpl.createChatRoom(new_chatroom, USER_BOUND_PORT);
	}

	public ChatroomView joinChatRoom(IChatRoom request_room, int USER_BOUND_PORT) {
		// TODO Auto-generated method stub
		return roomImpl.joinChatRoom(request_room, USER_BOUND_PORT);
	}

	/**
	 * Leave the chat room
	 * Call the leaveChatRoom() method in chatroom model. 
	 */
	public void leaveChatRoom(IChatRoom chatroom) {
		// TODO Auto-generated method stub
		roomImpl.leaveRoom(chatroom);
	}

}
