package model;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import javax.swing.ImageIcon;

import common.DataPacketChatRoom;
import common.IAddReceiverType;
import common.IChatRoom;
import common.ICmd2ModelAdapter;
import common.IComponentFactory;
import common.IReceiver;
import common.IRemoveReceiverType;
import model.cmd.AddReceiverAlgoCmd;
import model.cmd.DefaultDataPacketAlgoCmd;
import model.cmd.ImageDataPacketAlgoCmd;
import model.cmd.RemoveReceiverAlgoCmd;
import model.cmd.StringDataPacketAlgoCmd;

import provided.datapacket.DataPacketAlgo;
import view.ChatroomView;

/**
 * Model for the chat room
 *
 */
public class ChatRoom implements IChatRoom {

	private static final long serialVersionUID = -4835621848594850799L;

	String room;
	UUID id = UUID.randomUUID();
	/**
	 * The list of receivers/ user stubs
	 */
	ArrayList<IReceiver> receiver_list;

	/**
	 * model to view adapter
	 */
	transient IMini2ViewAdapter imini2viewadapter;

	/**
	 * Current user stub
	 * The user, on which model does the operation
	 */
	IReceiver receiver;

	transient ICmd2ModelAdapter cmd2modeladapter;

	transient DefaultDataPacketAlgoCmd default_cmd = new DefaultDataPacketAlgoCmd();
	transient DataPacketAlgo<String, String> dataAlgo = new DataPacketAlgo<String, String>(default_cmd);

	/**
	 * Constructor for the chat room model
	 * @param room the room name
	 */
	public ChatRoom(String room) {
		// TODO Auto-generated constructor stub
		this.room = room;
		receiver_list = new ArrayList<IReceiver>();
		setCmdAdapter();
	}

	/**
	 * Constructor for the char room model
	 * @param room an instantiation of chat room
	 */
	public ChatRoom(IChatRoom room) {
		this.id = room.getUUID();
		this.room = room.getName();

		receiver_list = new ArrayList<IReceiver>();

		for (IReceiver receiver : room.getIReceiverStubs()) {
			receiver_list.add(receiver);
		}
		setCmdAdapter();
	}

	/**
	 * getter for chat room name
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return room;
	}

	@Override
	/**
	 * getter for chatroom id
	 */
	public UUID getUUID() {
		// TODO Auto-generated method stub
		return id;
	}

	/**
	 * Getter for the list of user stubs
	 */
	@Override
	public Collection<IReceiver> getIReceiverStubs() {
		// TODO Auto-generated method stub
		return receiver_list;
	}

	/**
	 * Date package algorithms
	 * @return the matching algorithm
	 */
	public DataPacketAlgo<String, String> getdataAlgo() {
		return dataAlgo;
	}

	public void setMiniView(IMini2ViewAdapter imini2viewadapter) {
		this.imini2viewadapter = imini2viewadapter;
	}

	/**
	 * Add a receiver stub to the chat room.
	 * @param receiver is the receiver stub to add to this chat room.
	 */
	@Override
	public boolean addIReceiverStubLocally(IReceiver receiver) {
		// TODO Auto-generated method stub
		try {
			for (IReceiver receiver1 : receiver_list) {
				if ((receiver1.getUUID()).equals(receiver.getUUID())) {
					return false;
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		receiver_list.add(receiver);
		imini2viewadapter.addUserList(receiver);
		return true;
	}

	/**
	 * Remove a receiver stub
	 * @param receiver is the receiver stub to remove from this chat room.
	 */
	@Override
	public boolean removeIReceiverStubLocally(IReceiver receiver) {
		// TODO Auto-generated method stub

		try {
			for (IReceiver receiver1 : receiver_list) {
				if ((receiver1.getUUID()).equals(receiver.getUUID())) {
					receiver_list.remove(receiver1);
					imini2viewadapter.removeUserList(receiver1);
					return true;
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public <T> void sendPacket(DataPacketChatRoom<T> data) {
		// TODO Auto-generated method stub
		new Thread(() -> {

			for (IReceiver receiver1 : receiver_list) {

				try {
					receiver1.receive(data);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void append(String string, String name) {
		// TODO Auto-generated method stub
		cmd2modeladapter.appendMsg(string, name);
	}

	public void newConnect(IReceiver new_receiver) {
		for (int index = 0; index < receiver_list.size(); index++) {

			IReceiver temp = receiver_list.get(index);

			try {
				temp.receive(new DataPacketChatRoom<IAddReceiverType>(IAddReceiverType.class, new IAddReceiverType() {

					private static final long serialVersionUID = -8843924670451014077L;

					@Override
					public IReceiver getReceiverStub() {
						return new_receiver;
					}
				}, new_receiver));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

	public void initSet(IReceiver receiverStub, Collection<IReceiver> collection) {
		// TODO Auto-generated method stub
		receiver = receiverStub;
		receiver_list = new ArrayList<IReceiver>();
		for (IReceiver temp : collection) {
			receiver_list.add(temp);
		}
		newConnect(receiver);
		addIReceiverStubLocally(receiver);
	}

	public ChatroomView getRoomView() {
		return imini2viewadapter.getRoomView();
	}

	public void setCmdAdapter() {

		cmd2modeladapter = new ICmd2ModelAdapter() {
			@Override
			public void appendMsg(String text, String name) {
				// TODO Auto-generated method stub
				imini2viewadapter.append(text, name);
			}

			@Override
			public void buildScrollableComponent(IComponentFactory fac, String label) {
				// TODO Auto-generated method stub

			}

			@Override
			public void buildNonScrollableComponent(IComponentFactory fac, String label) {
				// TODO Auto-generated method stub

			}
		};

		default_cmd.setCmd2ModelAdpt(cmd2modeladapter);
		StringDataPacketAlgoCmd stringDataPacketAlgoCmd = new StringDataPacketAlgoCmd();
		stringDataPacketAlgoCmd.setCmd2ModelAdpt(cmd2modeladapter);

		AddReceiverAlgoCmd addreceiverAlgoCmd = new AddReceiverAlgoCmd(this);
		addreceiverAlgoCmd.setCmd2ModelAdpt(cmd2modeladapter);

		RemoveReceiverAlgoCmd removereceiverAlgoCmd = new RemoveReceiverAlgoCmd(this);
		removereceiverAlgoCmd.setCmd2ModelAdpt(cmd2modeladapter);

		ImageDataPacketAlgoCmd imagedatapacketAlgoCmd = new ImageDataPacketAlgoCmd(this);
		imagedatapacketAlgoCmd.setCmd2ModelAdpt(cmd2modeladapter);

		dataAlgo.setCmd(String.class, stringDataPacketAlgoCmd);
		dataAlgo.setCmd(IAddReceiverType.class, addreceiverAlgoCmd);
		dataAlgo.setCmd(IRemoveReceiverType.class, removereceiverAlgoCmd);
		dataAlgo.setCmd(ImageIcon.class, imagedatapacketAlgoCmd);
	}

	public void getImage(ImageIcon data) {
		// TODO Auto-generated method stub
		imini2viewadapter.addImage(data);
	}

	public void leaveRoom(IReceiver receiver2) {
		// TODO Auto-generated method stub
		for (int index = 0; index < receiver_list.size(); index++) {

			IReceiver temp = receiver_list.get(index);
			try {
				temp.receive(new DataPacketChatRoom<IRemoveReceiverType>(IRemoveReceiverType.class,
						new IRemoveReceiverType() {

							/**
							 * 
							 */
							private static final long serialVersionUID = 6410931144191702459L;

							public IReceiver getReceiverStub() {
								return receiver2;
							}
						}, receiver2));

			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}
}
