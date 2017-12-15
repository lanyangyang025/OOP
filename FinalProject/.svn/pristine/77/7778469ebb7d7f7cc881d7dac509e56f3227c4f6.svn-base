/**
 * 
 */
package yl128_pg23.model.user.cmd;

import common.DataPacketUser;
import common.DataPacketUserAlgoCmd;
import common.IUserCmd2ModelAdapter;
import common.datatype.user.IUserInstallCmdType;
import provided.datapacket.DataPacketAlgo;

/**
 * The command to deal with installing command
 * @author Yiqing Lu
 *
 */
public class CmdCommUserInstallCmd extends DataPacketUserAlgoCmd<IUserInstallCmdType> {

	private DataPacketAlgo<String, String> cmdMngr;
	private transient IUserCmd2ModelAdapter adpt;

	public CmdCommUserInstallCmd(DataPacketAlgo<String, String> cmdMngr, IUserCmd2ModelAdapter c2madpt) {
		this.cmdMngr = cmdMngr;
		this.adpt = c2madpt;
	}

	private static final long serialVersionUID = -5473442460103576115L;

	@Override
	public void setCmd2ModelAdpt(IUserCmd2ModelAdapter cmd2ModelAdpt) {
		this.adpt = cmd2ModelAdpt;
	}

	/* (non-Javadoc)
	 * @see provided.datapacket.ADataPacketAlgoCmd#apply(java.lang.Class, provided.datapacket.ADataPacket, java.lang.Object[])
	 */

	@Override
	public String apply(Class<?> index, DataPacketUser<IUserInstallCmdType> host, String... params) {
		// TODO Auto-generated method stub
		DataPacketUserAlgoCmd<?> cmd = host.getData().getCmd();
		cmd.setCmd2ModelAdpt(adpt);
		cmdMngr.setCmd(host.getData().getCmdId(), cmd);
		return null;
	}

}
