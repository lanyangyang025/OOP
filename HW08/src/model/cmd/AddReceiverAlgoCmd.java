/**
 * 
 */
package model.cmd;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.IAddReceiverType;
import common.ICmd2ModelAdapter;
import model.ChatRoom;

public class AddReceiverAlgoCmd extends DataPacketAlgoCmd<IAddReceiverType> {

	/**
	 * generate serial id
	 */
	private static final long serialVersionUID = -2458927395461358186L;
	private ChatRoom chatroom;
	ICmd2ModelAdapter cmd2ModelAdpt;

	public AddReceiverAlgoCmd(ChatRoom chatroom) {
		this.chatroom = chatroom;
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}

	@Override
	public String apply(Class<?> index, DataPacketChatRoom<IAddReceiverType> host, String... params) {

		ChatRoom room = chatroom;
		room.addIReceiverStubLocally(host.getData().getReceiverStub());

		return "New user joins the chat room.";

	}
}
