package controller;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.UUID;

import javax.swing.ImageIcon;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.IInstallCmdType;
import common.IReceiver;
import model.ChatRoom;
import model.IMini2ViewAdapter;
import model.cmd.DefaultDataPacketAlgoCmd;
import provided.datapacket.DataPacketAlgo;
import view.ChatroomView;
import view.IMini2ModelAdapter;

/**
 * 
 * controller for mini-tabs/chatroom systems
 *
 */
public class MiniControl {
	/**
	 * view for the chat room
	 */
	private ChatroomView miniView;

	/**
	 * model for the chat room
	 */
	private ChatRoom room;

	/**
	 * Constructor for mini controller
	 * @param chatroom The chat room object of this chat room
	 * @param receiver IReceiver designated to the user
	 */
	public MiniControl(ChatRoom chatroom, IReceiver receiver) {

		room = chatroom;

		IMini2ViewAdapter imini2viewadapter = new IMini2ViewAdapter() {

			@Override
			public void addUserList(IReceiver receiver) {
				// TODO Auto-generated method stub
				try {
					miniView.addUserList(receiver);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			@Override
			public ChatroomView getRoomView() {
				// TODO Auto-generated method stub
				return miniView;
			}

			@Override
			public void append(String text, String name) {
				// TODO Auto-generated method stub
				miniView.outputTotextPanel(name + " : ");
				miniView.outputTotextPanel(text);
			}

			@Override
			public void addImage(ImageIcon data) {
				// TODO Auto-generated method stub
				miniView.addImage(data);
			}

			@Override
			public void removeUserList(IReceiver receiver) {
				miniView.removeUserList(receiver);
			}

			@Override
			public ChatRoom getChatRoom() {
				// TODO Auto-generated method stub
				return room;
			}
		};
		room.setMiniView(imini2viewadapter);

		miniView = new ChatroomView(new IMini2ModelAdapter() {

			/**
			 * getter for chat room name
			 */
			public String getName() {
				return room.getName();
			}

			/**
			 * getter for UIUD
			 */
			public UUID getUUID() {
				return room.getUUID();
			}

			@Override
			public void sendDataPacket(String text, IReceiver receiver) {
				// TODO Auto-generated method stub
				chatroom.sendPacket(new DataPacketChatRoom<String>(String.class, text, receiver));
			}

			@Override
			public void sendImage(ImageIcon image, IReceiver receiver) {
				// TODO Auto-generated method stub
				chatroom.sendPacket(new DataPacketChatRoom<ImageIcon>(ImageIcon.class, image, receiver));
			}

			@Override
			public void quit() {
				// TODO Auto-generated method stub
				room.leaveRoom(receiver);
			}

			@Override
			public ChatRoom getChatRoom() {
				// TODO Auto-generated method stub
				return room;
			}

			@Override
			public void sendImage(ImageIcon image) {
				// TODO Auto-generated method stub
				
			}
		}, receiver);

	}

	/**
	 * getter for mini view
	 * @return chat room view
	 */
	public ChatroomView getChatView() {
		return miniView;
	}

}
