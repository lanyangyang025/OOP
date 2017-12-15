/**
 * 
 */
package model.cmd;

//import java.rmi.RemoteException;
//import java.util.Collection;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.IRemoveReceiverType;
//import common.IChatRoom;
import common.ICmd2ModelAdapter;
import model.ChatRoom;
//import model.ChatRoomImpl;

public class RemoveReceiverAlgoCmd extends DataPacketAlgoCmd<IRemoveReceiverType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3372898227453975201L;
	private ChatRoom chatroom;
	ICmd2ModelAdapter cmd2ModelAdpt;

	public RemoveReceiverAlgoCmd(ChatRoom chatroom) {
		this.chatroom = chatroom;
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}

	@Override
	public String apply(Class<?> index, DataPacketChatRoom<IRemoveReceiverType> host, String... params) {

		chatroom.removeIReceiverStubLocally(host.getData().getReceiverStub());

		return "The user leaves the chat room.";

	}
}
