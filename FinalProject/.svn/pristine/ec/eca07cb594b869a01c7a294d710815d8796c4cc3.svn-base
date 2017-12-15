package yl128_pg23.model.room.cmd;

import common.DataPacketCR;
import common.DataPacketCRAlgoCmd;
import common.ICRCmd2ModelAdapter;
import yl128_pg23.model.datatype.IStringType;

/**
 * The command to deal with sending the text in the lobby
 * @author Yiqing Lu, Peisheng Guo
 *
 */
public class CmdText extends DataPacketCRAlgoCmd<IStringType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5906094671924213594L;

	private transient ICRCmd2ModelAdapter adpt;

	/**
	 * @param iCmd2ModelAdapter
	 */
	public CmdText(ICRCmd2ModelAdapter iCmd2ModelAdapter) {
		this.adpt = iCmd2ModelAdapter;
	}

	/* (non-Javadoc)
	 * @see provided.datapacket.ADataPacketAlgoCmd#apply(java.lang.Class, provided.datapacket.ADataPacket, java.lang.Object[])
	 */
	@Override
	public String apply(Class<?> index, DataPacketCR<IStringType> host, String... params) {
		adpt.appendMsg(host.getData().getString(), "Text");
		return host.getData().getString();
	}

	/* (non-Javadoc)
	 * @see provided.datapacket.ADataPacketAlgoCmd#setCmd2ModelAdpt(java.lang.Object)
	 */
	@Override
	public void setCmd2ModelAdpt(ICRCmd2ModelAdapter adpt) {
		this.adpt = adpt;
	}

}
