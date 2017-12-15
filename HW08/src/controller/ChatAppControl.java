package controller;

import java.awt.EventQueue;

import java.util.Collection;

import common.IChatRoom;
import common.IUser;
import model.MainModel;

import view.ChatappView;
import view.ChatroomView;
import view.IView2ModelAdapter;
import model.ChatRoom;
import model.IModel2ViewAdapter;

/**
 * Controller of Client
 * @author Yiqing Lu, Yerong Li
 *
 */
public class ChatAppControl {

	/**
	 * Client Model
	 */
	private MainModel mainModel;
	private ChatappView chatappView;

	/**
	 * Client Controller construction
	 * Called when is being run
	 */
	public ChatAppControl() {
		chatappView = new ChatappView(new IView2ModelAdapter() {

			@Override
			/**
			 * Method for connect to server
			 */
			public void connect(String remoteIP, String name) {
				// TODO Auto-generated method stub
				mainModel.getUser(remoteIP, name);

			}

			@Override
			/**
			 * Method for initialization of a user
			 */
			public void createUser(String name) {
				// TODO Auto-generated method stub
				mainModel.initUser(name);
			}

			@Override
			public void createChatRoom(String text) {
				// TODO Auto-generated method stub
				mainModel.createChatRoom(text);
			}

			@Override
			public void join(IChatRoom request_room) {
				// TODO Auto-generated method stub
				mainModel.joinChatRoom(request_room);
			}

			@Override
			public Collection<IChatRoom> getChatRoom(IUser iUser) {
				// TODO Auto-generated method stub
				return mainModel.getChatRoom(iUser);
			}

			@Override
			public void leaveChatRoom(ChatRoom chatroom) {
				// TODO Auto-generated method stub
				mainModel.leaveChatRoom(chatroom);
			}

		});

		mainModel = new MainModel(new IModel2ViewAdapter() {

			@Override
			public void outputToTextArea(String string) {
				// TODO Auto-generated method stub
				chatappView.outputToTextArea(string);
			}

			@Override
			public int getUserPort() {
				// TODO Auto-generated method stub
				return chatappView.getUserPort();
			}

			@Override
			public void setRemoteAdress(String localAddress) {
				// TODO Auto-generated method stub
				chatappView.setRemoteAdress(localAddress);
			}

			@Override
			public int getServerPort() {
				// TODO Auto-generated method stub
				return chatappView.getServerPort();
			}

			@Override
			public void addtoConnectUser(IUser userStub) {
				// TODO Auto-generated method stub
				chatappView.addtoConnectUser(userStub);
			}

			@Override
			public void addTab(ChatroomView miniView) {
				// TODO Auto-generated method stub
				//_miniMVCadapterMap.put(miniView, )
				chatappView.addTab(miniView);
			}

		});

	}

	/**
	 * start the client application by starting the model and view
	 */
	public void start() {
		chatappView.start();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatAppControl controller = new ChatAppControl();
					controller.start(); // start the system
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
