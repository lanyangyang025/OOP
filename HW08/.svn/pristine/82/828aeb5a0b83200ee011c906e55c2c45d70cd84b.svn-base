package model.cmd;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;

import java.util.List;

import javax.swing.ImageIcon;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.IChatRoom;
import common.ICmd2ModelAdapter;
import common.IInstallCmdType;
import common.IReceiver;
import common.IRequestCmdType;
import common.IUser;
import model.ChatRoom;
import provided.datapacket.DataPacketAlgo;

public class RequestAlgoCmd extends DataPacketAlgoCmd<IRequestCmdType>{

	private DataPacketAlgo<String, String> dataAlgo;
	private IReceiver receiver;

	public RequestAlgoCmd(DataPacketAlgo<String, String> dataAlgo, IReceiver receiver) {
		// TODO Auto-generated constructor stub
		this.dataAlgo = dataAlgo;
		this.receiver = receiver;
	}

	@Override
	public String apply(Class<?> index, DataPacketChatRoom<IRequestCmdType> host, String... params) {
		// TODO Auto-generated method stub
		DataPacketAlgoCmd<?> cmd = (DataPacketAlgoCmd<?>)dataAlgo.getCmd(host.getData().getCmdId());
		System.out.println("Call Install");

		try {
			
			host.getSender().receive(new DataPacketChatRoom<IInstallCmdType>(IInstallCmdType.class,new IInstallCmdType() {

				@Override
				public DataPacketAlgoCmd<?> getCmd() {
					return (DataPacketAlgoCmd<?>) cmd;
				}

				@Override
				public Class<?> getCmdId() {
					return host.getData().getCmdId();
				}


			},receiver));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		// TODO Auto-generated method stub
	}

}
