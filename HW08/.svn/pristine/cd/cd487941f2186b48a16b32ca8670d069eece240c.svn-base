package model.cmd;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.ICmd2ModelAdapter;
import common.IInstallCmdType;
import provided.datapacket.DataPacketAlgo;

public class InstallAlgoCmd extends DataPacketAlgoCmd<IInstallCmdType>{

	DataPacketAlgo<String, String> dataAlgo;
	
	public InstallAlgoCmd(DataPacketAlgo<String, String> dataAlgo) {
		this.dataAlgo = dataAlgo;
	}

	@Override
	public String apply(Class<?> index, DataPacketChatRoom<IInstallCmdType> host, String... params) {
		// TODO Auto-generated method stub
		dataAlgo.setCmd(host.getData().getCmdId(), host.getData().getCmd());
		return null;
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		// TODO Auto-generated method stub
		
	}

}
