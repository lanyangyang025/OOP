/**
 * 
 */
package yl128_pg23.model.room.cmd;

import java.rmi.RemoteException;

import common.DataPacketCR;
import common.DataPacketCRAlgoCmd;
import common.ICRCmd2ModelAdapter;
import common.datatype.chatroom.IRemoveReceiverType;
import yl128_pg23.model.ChatRoom;

/**
 * The command to deal with removing receiver in the lobby
 * @author Yiqing Lu, Peisheng Guo
 *
 */
public class CmdCommRemoveReceiver extends DataPacketCRAlgoCmd<IRemoveReceiverType> {

	private transient ChatRoom cr;

	public CmdCommRemoveReceiver(ChatRoom chatRoom) {
		this.cr = chatRoom;
	}

	private static final long serialVersionUID = -5473442460103576115L;

	@Override
	public void setCmd2ModelAdpt(ICRCmd2ModelAdapter cmd2ModelAdpt) {

	}

	@Override
	public String apply(Class<?> index, DataPacketCR<IRemoveReceiverType> host, String... params) {
		//cmd2ModelAdpt.appendMsg("Case IAddReceiver " + host.getData());
		//cmd2ModelAdpt.addReceiver(host.getData().getReceiverStub());
		//chatRoom.addIReceiverStubLocally(host.getData().getReceiverStub());
		try {
			//crMngr.getCR(host.getSender().getUUID()).removeConn(host.getData().getReceiverStub().getUUID());

			cr.removeConn(host.getData().getReceiverStub().getUUID());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
