/**
 * 
 */
package yl128_pg23.model;

import java.rmi.RemoteException;
import java.util.UUID;

import common.DataPacketCR;
import common.ICRMessageType;
import common.IReceiver;
import common.IUser;

/**
 * @author Yiqing Lu, Peisheng Guo
 *
 */
public class Connect implements IReceiver {

	private UUID uuid;
	private ChatRoom cr;
	private transient IViewAdapter adpt;
	private transient IUser user;

	public Connect(ChatRoom cr, IViewAdapter adpt, User user) {
		this.uuid = UUID.randomUUID();
		this.cr = cr;
		this.setAdpt(adpt);
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see common.IReceiver#sendDataPacket(provided.datapacket.DataPacket)
	 */
	/*
	@Override
	public String sendDataPacket(DataPacket dp) throws RemoteException {
		//cr.processDataPacket(dp);
		//dp = new DataPacket<String,IReceiver>(String.class, "Stuff", null);
		;
		//cr.getCmdMngr().getCmd(dp.getClass()).apply(dp.getClass(), dp.execute(algo, params), dp.getData());
		cr.appendMsg(dp.execute(cr.getCmdMngr())+"\n");
		//adpt.updateMsg();
		return "";
	}
	*/
	/* (non-Javadoc)
	 * @see common.IReceiver#newConnection(common.IReceiver)
	 */
	/*
	@Override
	public void newConnection(IReceiver conn) throws RemoteException {
		cr.addConn(conn);
	
	}
	*/
	/* (non-Javadoc)
	 * @see common.IReceiver#removeConnection(common.IReceiver)
	 */
	/*
	@Override
	public void removeConnection(UUID uuid) throws RemoteException {
		cr.removeConn(uuid);
	}
	*/
	/* (non-Javadoc)
	 * @see common.IReceiver#getUUID()
	 */
	@Override
	public UUID getUUID() throws RemoteException {
		return uuid;
	}

	/* (non-Javadoc)
	 * @see common.IReceiver#receive(common.DataPacketChatRoom)
	 */
	@Override
	public <T extends ICRMessageType> void receive(DataPacketCR<T> data) throws RemoteException {

		//System.out.println(data.getData().getClass());
		//if(cr.getCmdMngr().getCmd(data.getData().getClass())==null) {
		//System.out.println("Fire execute");
		/*
		System.out.println("MARK");
		if(cr==null||cr.getCmdMngr()==null) {
			System.out.println("NULL");
		}
		*/
		System.out.println("Received:" + data.getData().getClass());
		String rtn = data.execute(cr.getCmdMngr());
		//}
		//System.out.println("Fire execute");
		if (rtn != null && rtn.compareTo("DEFAULT") == 0) {
			data.execute(cr.getCmdMngr());
		}
		//
		//cr.appendMsg(data.execute(cr.getCmdMngr())+"\n");

		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see common.IReceiver#getUserStub()
	 */
	@Override
	public IUser getUserStub() throws RemoteException {
		return user;
	}

	public IViewAdapter getAdpt() {
		return adpt;
	}

	public void setAdpt(IViewAdapter adpt) {
		this.adpt = adpt;
	}

}
