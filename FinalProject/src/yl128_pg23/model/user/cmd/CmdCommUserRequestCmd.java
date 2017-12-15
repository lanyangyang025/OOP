/**
 * 
 */
package yl128_pg23.model.user.cmd;

import java.rmi.RemoteException;

import common.DataPacketUser;
import common.DataPacketUserAlgoCmd;
import common.IUser;
import common.IUserCmd2ModelAdapter;
import common.datatype.IRequestCmdType;
import common.datatype.user.IUserInstallCmdType;
import provided.datapacket.DataPacketAlgo;

/**
 * The command to deal with requesting the command
 * @author Yiqing Lu, Peisheng Guo
 *
 */
public class CmdCommUserRequestCmd extends DataPacketUserAlgoCmd<IRequestCmdType> {

	private DataPacketAlgo<String, String> cmdMngr;
	private transient IUserCmd2ModelAdapter adpt;
	private transient IUser user;

	public CmdCommUserRequestCmd(IUser user, DataPacketAlgo<String, String> cmdMngr, IUserCmd2ModelAdapter adpt) {
		this.cmdMngr = cmdMngr;
		this.setAdpt(adpt);
		this.user = user;
	}

	private static final long serialVersionUID = -5473442460103576115L;

	@Override
	public void setCmd2ModelAdpt(IUserCmd2ModelAdapter cmd2ModelAdpt) {
		this.setAdpt(cmd2ModelAdpt);
	}

	@Override
	public String apply(Class<?> index, DataPacketUser<IRequestCmdType> host, String... params) {
		//cmd2ModelAdpt.appendMsg("Case IAddReceiver " + host.getData());
		//cmd2ModelAdpt.addReceiver(host.getData().getReceiverStub());
		//chatRoom.addIReceiverStubLocally(host.getData().getReceiverStub());
		/*
		for(Class<?> a:cmdMngr.getAllIndices()) {
			System.out.println(a);			
		}
		System.out.println(host.getData().getCmdId());
		*/
		DataPacketUserAlgoCmd<?> cmd = (DataPacketUserAlgoCmd<?>) cmdMngr.getCmd(host.getData().getCmdId());

		try {
			//System.out.println("Call Install");
			host.getSender().receive(
					new DataPacketUser<IUserInstallCmdType>(IUserInstallCmdType.class, new IUserInstallCmdType() {

						private static final long serialVersionUID = 1L;

						@Override
						public DataPacketUserAlgoCmd<?> getCmd() {
							return (DataPacketUserAlgoCmd<?>) cmd;
						}

						@Override
						public Class<?> getCmdId() {
							return host.getData().getCmdId();
						}

					}, user));
			//crMngr.getCR(host.getSender().getUUID()).addConn(host.getData().getReceiverStub());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public IUserCmd2ModelAdapter getAdpt() {
		return adpt;
	}

	public void setAdpt(IUserCmd2ModelAdapter adpt) {
		this.adpt = adpt;
	}
}
