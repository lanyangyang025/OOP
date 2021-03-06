package model;

import java.rmi.RemoteException;
import java.util.UUID;

import javax.swing.ImageIcon;

import common.DataPacketChatRoom;
import common.IReceiver;
import common.IUser;

public class Receiver implements IReceiver {

	private IUser user;
	private UUID id = UUID.randomUUID();
	private ChatRoom chatroom;

	public Receiver(IUser userStub, ChatRoom chatroom) {
		// TODO Auto-generated constructor stub
		this.user = userStub;
		this.chatroom = chatroom;
	}

	@Override
	public <T> void receive(DataPacketChatRoom<T> data) throws RemoteException {
		// TODO Auto-generated method stub
		if (!data.getData().getClass().equals(ImageIcon.class)) {
			chatroom.append(data.execute(chatroom.getdataAlgo()), data.getSender().getUserStub().getName());
		} else {
			data.execute(chatroom.getdataAlgo());
		}
	}

	@Override
	public IUser getUserStub() throws RemoteException {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public UUID getUUID() throws RemoteException {
		// TODO Auto-generated method stub
		return id;
	}

}
