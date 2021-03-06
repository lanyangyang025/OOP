package model.cmd;

//import java.awt.Color;
//import java.awt.Container;
//import java.rmi.RemoteException;
//import javax.swing.Box;
//import javax.swing.JLabel;
import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.ICmd2ModelAdapter;
//import common.IReceiver;
//import common.IUser;

/**
 * String data packet algorithm command
 * 
 */
public class StringDataPacketAlgoCmd extends DataPacketAlgoCmd<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9187134083829959301L;
	ICmd2ModelAdapter cmd2ModelAdapter;

	/**
	 * Set command to model adapter
	 */
	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdapter = cmd2ModelAdpt;
	}

	@Override
	public String apply(Class<?> index, DataPacketChatRoom<String> host, String... params) {
		// TODO Auto-generated method stub
		//IReceiver receiver = host.getSender();
		String data = host.getData();
		/*
		try {
			cmd2ModelAdapter.appendMsg(data, receiver.getUserStub().getName() + "\n");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		return data;
	}
}
