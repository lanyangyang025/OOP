/**
 * 
 */
package yl128_pg23.model;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import common.DataPacketUser;
import common.DataPacketUserAlgoCmd;
import common.IChatRoom;
import common.IComponentFactory;
import common.IUser;
import common.IUserCmd2ModelAdapter;
import common.IUserMessageType;
import common.datatype.IRequestCmdType;
import common.datatype.user.IInvitationType;
import common.datatype.user.IUserInstallCmdType;
import provided.datapacket.DataPacketAlgo;
import provided.mixedData.IMixedDataDictionary;
import provided.mixedData.MixedDataDictionary;
import provided.mixedData.MixedDataKey;
import yl128_pg23.model.user.cmd.CmdCommInvite;
import yl128_pg23.model.user.cmd.CmdCommUserInstallCmd;
import yl128_pg23.model.user.cmd.CmdCommUserRequestCmd;

/**
 * The user
 * @author Yiqing Lu
 *
 */
public class User implements IUser {

	private List<IUser> connectedPeers;
	private transient IViewAdapter adpt;
	private String userName;
	private UUID uuid;
	//private DataPacketAlgo<String,String> cmdMngr;
	private transient ChatRoomManager crMngr;
	private DataPacketAlgo<String, String> cmdMngr;
	private transient IUserCmd2ModelAdapter c2mAdpt;
	private transient IMixedDataDictionary mixDict = new MixedDataDictionary();
	private transient ChatModel cm;

	public User(String name, IViewAdapter adpt) {
		uuid = UUID.randomUUID();
		connectedPeers = new ArrayList<IUser>();
		crMngr = new ChatRoomManager(adpt, this, mixDict);
		this.adpt = adpt;
		userName = name;
		initC2MAdpt();
		initCmdMngr();
	}

	public List<String> getConnectedPeersNameList() {
		List<String> nameList = new ArrayList<String>();
		for (int i = 0; i < connectedPeers.size(); i++) {
			nameList.add(getName());
		}
		return nameList;

	}

	public void setUserName(String name) {
		userName = name;
	}

	@Override
	public String toString() {
		return getName();
	}

	/* (non-Javadoc)
	 * @see common.IUser#getUUID()
	 */
	@Override
	public UUID getUUID() {
		// TODO Auto-generated method stub
		return uuid;
	}

	/* (non-Javadoc)
	 * @see common.IUser#getPeerName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return userName;
	}

	/* (non-Javadoc)
	 * @see common.IUser#connect(common.IUser)
	 */
	@Override
	public void connect(IUser peer) {
		boolean exists = false;
		for (int i = 0; i < connectedPeers.size(); i++) {
			IUser p = connectedPeers.get(i);
			try {
				if (p.getUUID().equals(peer.getUUID())) {
					exists = true;
					break;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		if (!exists) {
			connectedPeers.add(peer);
			adpt.addConnPeer(peer);
		}
	}

	/* (non-Javadoc)
	 * @see common.IUser#fetchCRList()
	 */
	@Override
	public List<IChatRoom> getChatRooms() {
		return new ArrayList<IChatRoom>(crMngr.getCRList());
		//List<ChatRoom> list = crMngr.getCRList();
		//return new ArrayList<IChatRoom>();

	}

	public boolean leaveCR(ChatWindow cw) {
		crMngr.leaveCR(cw);
		//adpt.updateCRs(new ArrayList<IChatRoom>(crMngr.getCRList()));
		return true;
	}

	/**
	 * @param chatModel 
	 * 
	 */
	public ChatWindow createCR(ChatModel chatModel) {
		//crMngr.createCR(new ChatRoom(userName+":"+crMngr.getCRList().size(),cmdMngr));
		this.setCm(chatModel);
		return crMngr.createCR(userName, chatModel);

	}

	public ChatWindow joinCR(IUser iPeer, IChatRoom cr, ChatModel chatModel) {
		this.setCm(chatModel);
		Collection<IChatRoom> clcRooms = null;
		try {
			clcRooms = iPeer.getChatRooms();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		if (clcRooms == null)
			return null;
		List<IChatRoom> crList = new ArrayList<IChatRoom>();
		for (IChatRoom tcr : clcRooms) {
			crList.add(tcr);
		}
		if (crList != null) {
			IChatRoom targetCR = null;
			for (IChatRoom c : crList) {
				if (c.getUUID().equals(cr.getUUID()))
					targetCR = c;
			}
			if (targetCR != null) {
				//crMngr.createCR(new ChatRoom(targetCR,cmdMngr));
				return crMngr.createCR(targetCR, chatModel);
			}
		}
		return null;
	}

	/*
	@Override
	public ADataPacketAlgoCmdGroupF getNewCommand(Class requestClass) throws RemoteException {
		return (ADataPacketAlgoCmdGroupF) dataPacketAlgo.getCmd(requestClass);
	}
	*/

	/* (non-Javadoc)
	 * @see common.IUser#setDataPacketAlgoCmd(provided.datapacket.ADataPacketAlgoCmd)
	 */
	/*
	@Override
	public void setDataPacketAlgoCmd(ADataPacketAlgoCmd dataPacketAlgoCmd) throws RemoteException {
		dataPacketAlgoCmd.setCmd2ModelAdpt(adpt);
		cmdMngr.setCmd(dataPacketAlgoCmd.getClass(), dataPacketAlgoCmd);
	}
	 */
	/* (non-Javadoc)
	 * @see common.IUser#getDataPacketAlgoCmd(java.lang.Class)
	 */
	/*
	@Override
	public ADataPacketAlgoCmd getDataPacketAlgoCmd(Object c) throws RemoteException {
		return (ADataPacketAlgoCmd) cmdMngr.getCmd(c.getClass());
	}
	*/

	/**
	 * @param remoteStub
	 * @return
	 */
	public boolean exists(IUser remoteStub) {
		for (int i = 0; i < connectedPeers.size(); i++) {
			IUser p = connectedPeers.get(i);
			try {
				if (p.getUUID().equals(remoteStub.getUUID()))
					return true;
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public <T extends IUserMessageType> void receive(DataPacketUser<T> data) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Received:" + data.getData().getClass());
		String rtn = data.execute(getCmdMngr());
		//}
		//System.out.println("Fire execute");
		if (rtn != null && rtn.compareTo("DEFAULT") == 0) {
			data.execute(getCmdMngr());
		}
	}

	private DataPacketAlgo<String, String> getCmdMngr() {
		// TODO Auto-generated method stub
		return cmdMngr;
	}

	private void initC2MAdpt() {
		c2mAdpt = new IUserCmd2ModelAdapter() {

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return userName;
			}

			@Override
			public void appendMsg(String text, String name) {
				// TODO Auto-generated method stub				
			}

			@Override
			public void buildScrollableComponent(IComponentFactory fac, String label) {
				// TODO Auto-generated method stub				
			}

			@Override
			public void buildNonScrollableComponent(IComponentFactory fac, String label) {
				// TODO Auto-generated method stub				
			}

			@Override
			public <T> T put(MixedDataKey<T> key, T value) {
				// TODO Auto-generated method stub
				mixDict.put(key, value);
				return value;
			}

			@Override
			public <T> T get(MixedDataKey<T> key) {
				// TODO Auto-generated method stub
				return mixDict.get(key);
			}

			@Override
			public <T extends IUserMessageType> void sendTo(IUser target, Class<T> id, T data) {
				// TODO Auto-generated method stub				
			}
		};
	}

	private void initCmdMngr() {

		//cmdMngr = new DataPacketAlgo<String, String>(new CmdDefault());
		cmdMngr = new DataPacketAlgo<String, String>(new DataPacketUserAlgoCmd<IUserMessageType>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 6784895235535334323L;

			@Override
			public String apply(Class<?> index, DataPacketUser<IUserMessageType> host, String... params) {

				try {
					host.getSender()
							.receive(new DataPacketUser<IRequestCmdType>(IRequestCmdType.class, new IRequestCmdType() {

								private static final long serialVersionUID = 2901583931947226654L;

								@Override
								public Class<?> getCmdId() {
									return host.getData().getClass();
								}

							}, null));
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				//return "Default case called. data = "+ x;
				return "DEFAULT";
			}

			@Override
			public void setCmd2ModelAdpt(IUserCmd2ModelAdapter cmd2ModelAdpt) {
				// TODO Auto-generated method stub
				c2mAdpt = cmd2ModelAdpt;
			}

		});

		cmdMngr.setCmd(IRequestCmdType.class, new CmdCommUserRequestCmd(this, cmdMngr, c2mAdpt));
		cmdMngr.setCmd(IUserInstallCmdType.class, new CmdCommUserInstallCmd(cmdMngr, c2mAdpt));

		cmdMngr.setCmd(IInvitationType.class, new CmdCommInvite(this, c2mAdpt, adpt));
	}

	public ChatModel getCm() {
		return cm;
	}

	public void setCm(ChatModel cm) {
		this.cm = cm;
	}

}
