/**
 * 
 */
package yl128_pg23.model.room.cmd;

import common.DataPacketCR;
import common.DataPacketCRAlgoCmd;
import common.ICRCmd2ModelAdapter;
import common.IReceiver;
import common.datatype.chatroom.ICRInstallCmdType;
import provided.datapacket.DataPacketAlgo;

/**
 * The command to deal with installing command
 * @author Yiqing Lu
 *
 */
public class CmdCommInstallCmd extends DataPacketCRAlgoCmd<ICRInstallCmdType> {

	private DataPacketAlgo<String, String> cmdMngr;
	private transient ICRCmd2ModelAdapter adpt;

	public CmdCommInstallCmd(DataPacketAlgo<String, String> cmdMngr, IReceiver recv, ICRCmd2ModelAdapter c2madpt) {
		//this.recv = recv;
		this.cmdMngr = cmdMngr;
		this.adpt = c2madpt;
	}

	private static final long serialVersionUID = -5473442460103576115L;

	@Override
	public void setCmd2ModelAdpt(ICRCmd2ModelAdapter cmd2ModelAdpt) {

	}

	/* (non-Javadoc)
	 * @see provided.datapacket.ADataPacketAlgoCmd#apply(java.lang.Class, provided.datapacket.ADataPacket, java.lang.Object[])
	 */
	@Override
	public String apply(Class<?> index, DataPacketCR<ICRInstallCmdType> host, String... params) {
		//		DataPacketAlgoCmd<?> cmd = (DataPacketAlgoCmd<?>)cmdMngr.getCmd(host.getData().getCmdId());
		DataPacketCRAlgoCmd<?> cmd = host.getData().getCmd();
		cmd.setCmd2ModelAdpt(adpt);
		cmdMngr.setCmd(host.getData().getCmdId(), cmd);
		return null;
	}

}
