package yl128_pg23.model.room.cmd;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import common.DataPacketCR;
import common.DataPacketCRAlgoCmd;
import common.ICRCmd2ModelAdapter;
import common.IComponentFactory;
import yl128_pg23.model.datatype.IImageIconType;

/**
 * The command to deal with sending the image
 * @author Yiqing Lu, Peisheng Guo
 *
 */
public class CmdImage extends DataPacketCRAlgoCmd<IImageIconType> {

	private static final long serialVersionUID = -3838770341127745921L;

	private transient ICRCmd2ModelAdapter adpt;

	/**
	 * @param c2madpt
	 */
	public CmdImage(ICRCmd2ModelAdapter c2madpt) {
		this.adpt = c2madpt;
	}

	/* (non-Javadoc)
	 * @see provided.datapacket.ADataPacketAlgoCmd#setCmd2ModelAdpt(java.lang.Object)
	 */
	@Override
	public void setCmd2ModelAdpt(ICRCmd2ModelAdapter adpt) {
		this.adpt = adpt;

	}

	/* (non-Javadoc)
	 * @see provided.datapacket.ADataPacketAlgoCmd#apply(java.lang.Class, provided.datapacket.ADataPacket, java.lang.Object[])
	 */
	@Override
	public String apply(Class<?> index, DataPacketCR<IImageIconType> host, String... params) {
		ImageIcon ii = host.getData().getImageIcon();
		adpt.buildScrollableComponent(new IComponentFactory() {
			@Override
			public Component makeComponent() {
				JLabel lblImg = new JLabel();
				lblImg.setIcon(ii);
				return lblImg;
			}

		}, "Image");

		return null;
	}

}
