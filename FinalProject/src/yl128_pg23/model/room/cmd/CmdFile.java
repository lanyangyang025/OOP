package yl128_pg23.model.room.cmd;

import java.awt.Component;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JLabel;

import common.DataPacketCR;
import common.DataPacketCRAlgoCmd;
import common.ICRCmd2ModelAdapter;
import common.IComponentFactory;
import yl128_pg23.model.datatype.IFileType;

/**
 * The command to sending the file
 * @author Yiqing Lu
 *
 */
public class CmdFile extends DataPacketCRAlgoCmd<IFileType> {

	private static final long serialVersionUID = -3838770341127745921L;

	private transient ICRCmd2ModelAdapter adpt;

	/**
	 * @param c2madpt
	 */
	public CmdFile(ICRCmd2ModelAdapter c2madpt) {
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
	public String apply(Class<?> index, DataPacketCR<IFileType> host, String... params) {
		File dlDir = new File("download/");
		dlDir.mkdirs();
		File of = new File(new String(host.getData().getFile()[0]));
		if (!of.exists()) {
			try {
				of.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(of);
			fos.write(host.getData().getFile()[1]);

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		adpt.buildScrollableComponent(new IComponentFactory() {
			@Override
			public Component makeComponent() {
				return new JLabel("File received:[" + of.getName() + "]");
			}

		}, "File");

		return null;
	}

}
