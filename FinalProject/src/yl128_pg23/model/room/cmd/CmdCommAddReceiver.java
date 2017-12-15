/**
 * 
 */
package yl128_pg23.model.room.cmd;

import common.DataPacketCR;
import common.DataPacketCRAlgoCmd;
import common.ICRCmd2ModelAdapter;
import common.datatype.chatroom.IAddReceiverType;
import yl128_pg23.model.ChatRoom;

/**
 * The command to deal with adding user in the lobby
 * @author Yiqing Lu, Peisheng Guo
 *
 */
public class CmdCommAddReceiver extends DataPacketCRAlgoCmd<IAddReceiverType> {

	private transient ChatRoom cr;

	public CmdCommAddReceiver(ChatRoom chatRoom) {
		this.cr = chatRoom;
	}

	private static final long serialVersionUID = -5473442460103576115L;

	@Override
	public void setCmd2ModelAdpt(ICRCmd2ModelAdapter cmd2ModelAdpt) {

	}

	@Override
	public String apply(Class<?> index, DataPacketCR<IAddReceiverType> host, String... params) {
		//cmd2ModelAdpt.appendMsg("Case IAddReceiver " + host.getData());
		//cmd2ModelAdpt.addReceiver(host.getData().getReceiverStub());
		//chatRoom.addIReceiverStubLocally(host.getData().getReceiverStub());
		//System.out.println(crMngr.getCR(host.getSender().getUUID()));
		//crMngr.getCR(host.getSender().getUUID()).addConn(host.getData().getReceiverStub());
		cr.addConn(host.getData().getReceiverStub());

		return null;
	}
}
