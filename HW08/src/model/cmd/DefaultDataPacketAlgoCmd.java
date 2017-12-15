package model.cmd;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.ICmd2ModelAdapter;

public class DefaultDataPacketAlgoCmd extends DataPacketAlgoCmd<Object> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8896083890577994969L;
	ICmd2ModelAdapter cmd2ModelAdapter;

	/**
	 * Set command to model adapter
	 */
	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdapter = cmd2ModelAdpt;
	}

	@Override
	public String apply(Class<?> index, DataPacketChatRoom<Object> host, String... params) {
		// TODO Auto-generated method stub
		Object data = host.getData();

		return "Default Algo: " + data;
	}
}
