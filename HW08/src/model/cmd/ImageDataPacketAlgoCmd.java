package model.cmd;

//import java.awt.Color;
//import java.awt.Container;
import java.rmi.RemoteException;

//import javax.swing.Box;
import javax.swing.ImageIcon;
//import javax.swing.JLabel;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.ICmd2ModelAdapter;
//import common.IReceiver;
//import common.IUser;
import model.ChatRoom;

public class ImageDataPacketAlgoCmd extends DataPacketAlgoCmd<ImageIcon> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4140022508215607239L;
	ICmd2ModelAdapter cmd2ModelAdapter;
	ChatRoom chatroom;

	public ImageDataPacketAlgoCmd(ChatRoom chatroom) {
		this.chatroom = chatroom;
	}

	/**
	 * Set command to model adapter
	 */
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdapter = cmd2ModelAdpt;
	}

	@Override
	public String apply(Class<?> index, DataPacketChatRoom<ImageIcon> host, String... params) {
		// TODO Auto-generated method stub
		ImageIcon data = host.getData();
		try {
			chatroom.append("", host.getSender().getUserStub().getName());
			chatroom.getImage(data);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data.toString();
	}
}
