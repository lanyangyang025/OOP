/**
 * 
 */
package yl128_pg23.model.room.cmd;

import java.rmi.RemoteException;

import common.DataPacketCR;
import common.DataPacketCRAlgoCmd;
import common.ICRCmd2ModelAdapter;
import common.IReceiver;
import common.datatype.IRequestCmdType;
import common.datatype.chatroom.ICRInstallCmdType;
import provided.datapacket.DataPacketAlgo;

/**
 * The command to deal with requesting the command
 * @author Yiqing Lu, Peisheng Guo
 *
 */
public class CmdCommRequestCmd extends DataPacketCRAlgoCmd<IRequestCmdType> {

	private transient IReceiver recv;
	private DataPacketAlgo<String, String> cmdMngr;
	private transient ICRCmd2ModelAdapter adpt;

	public CmdCommRequestCmd(DataPacketAlgo<String, String> cmdMngr, IReceiver recv, ICRCmd2ModelAdapter adpt) {
		this.recv = recv;
		this.cmdMngr = cmdMngr;
		this.setAdpt(adpt);
	}

	private static final long serialVersionUID = -5473442460103576115L;

	@Override
	public void setCmd2ModelAdpt(ICRCmd2ModelAdapter cmd2ModelAdpt) {

	}

	@Override
	public String apply(Class<?> index, DataPacketCR<IRequestCmdType> host, String... params) {
		//cmd2ModelAdpt.appendMsg("Case IAddReceiver " + host.getData());
		//cmd2ModelAdpt.addReceiver(host.getData().getReceiverStub());
		//chatRoom.addIReceiverStubLocally(host.getData().getReceiverStub());
		/*
		for(Class<?> a:cmdMngr.getAllIndices()) {
			System.out.println(a);			
		}
		System.out.println(host.getData().getCmdId());
		*/
		DataPacketCRAlgoCmd<?> cmd = (DataPacketCRAlgoCmd<?>) cmdMngr.getCmd(host.getData().getCmdId());

		System.out.println(host.getData().getCmdId());

		try {
			//System.out.println("Call Install");
			host.getSender()
					.receive(new DataPacketCR<ICRInstallCmdType>(ICRInstallCmdType.class, new ICRInstallCmdType() {

						private static final long serialVersionUID = 1L;

						@Override
						public DataPacketCRAlgoCmd<?> getCmd() {
							return (DataPacketCRAlgoCmd<?>) cmd;
						}

						@Override
						public Class<?> getCmdId() {
							return host.getData().getCmdId();
						}

					}, recv));
			//crMngr.getCR(host.getSender().getUUID()).addConn(host.getData().getReceiverStub());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ICRCmd2ModelAdapter getAdpt() {
		return adpt;
	}

	public void setAdpt(ICRCmd2ModelAdapter adpt) {
		this.adpt = adpt;
	}
}
