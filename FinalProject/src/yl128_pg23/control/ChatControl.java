/**
 * 
 */
package yl128_pg23.control;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JPanel;

import common.IChatRoom;
import common.IUser;
import yl128_pg23.model.ChatModel;
import yl128_pg23.model.ChatRoom;
import yl128_pg23.model.ChatWindow;
import yl128_pg23.model.IViewAdapter;
import yl128_pg23.view.ChatView;
import yl128_pg23.view.IModelAdapter;

/**
 * @author Yiqing Lu, Peisheng Guo
 *
 */
public class ChatControl {

	/**
	 * main model of the whole chat room
	 */

	private ChatModel mainModel;

	/**
	 * main view of the whole chat room
	 */
	private ChatView mainView;

	/**
	 * controller of the whole chat room
	 */
	public ChatControl() {

		mainModel = new ChatModel(new IViewAdapter() {
			/**
			 * add user in the user list of the GUI
			 * @param user User to be added
			 */
			@Override
			public void addConnPeer(IUser peer) {
				mainView.addConnPeer(peer);
			}

			/**
			 * add a new chat room
			 * @param cr chat room to be added
			 */
			@Override
			public void addConnCR(ChatRoom cr) {
				mainView.addConnCR(cr);

			}

			@Override
			public void updateCRs(List<IChatRoom> lst) {
				//mainView.updateCRs(lst);
			}

			/**
			 * update the user list in the main view
			 * @param connectedPeers the user list
			 */
			@Override
			public void updatePeers(List<IUser> connectedPeers) {
				mainView.updatePeers(connectedPeers);
			}

			@Override
			public void updateMsg() {
				// TODO Auto-generated method stub

			}

			/**
			 * the user add the chat room 
			 * @param user the user which need to add the chat room
			 */
			@Override
			public void addWindow(IUser user, IChatRoom chatRoom) {
				// TODO Auto-generated method stub
				mainView.addWindow(user, chatRoom);
			}

		});

		mainView = new ChatView(new IModelAdapter() {

			/**
			 * connect the user based on the ip address
			 * @param addr the ip address of the user
			 */
			@Override
			public void connectPeer(String addr) {
				mainModel.connectPeer(addr);
			}

			/**
			 * set the name of user
			 * @param user name
			 */
			@Override
			public void setSelfName(String name) {
				mainModel.setSelfName(name);

			}

			/**
			 * create chat room view
			 */
			@Override
			public ChatWindow createCR() {
				return mainModel.createCR();
			}

			/**
			 * get the room list of the user
			 * @param iPeer the user we want to get chat room list
			 */
			@Override
			public List<IChatRoom> fetchCRList(IUser iPeer) {
				return mainModel.fetchCRList(iPeer);
			}

			/**
			 * get the room list of the user
			 * @param iPeer the user we want to get chat room list
			 */
			@Override
			public ChatWindow joinCR(IUser iPeer, IChatRoom icr) {
				return mainModel.joinCR(iPeer, icr);

			}

			/**
			 * get ip address
			 */
			@Override
			public String getIP() {
				return mainModel.getIP();
			}

			/**
			 * get user name
			 */
			@Override
			public String getUserName() {

				return mainModel.getUserName();
			}

			/**
			 * leave the chat room and remove the chat room view
			 * @param icr the chat room view
			 */
			@Override
			public void leaveCR(JPanel icr) {
				mainModel.leaveCR(icr);

			}

			/**
			 * send other receivers the data
			 * @param icr the current chat room
			 * @param dpType data packet type
			 * @param text the data
			 */
			@Override
			public void sendDataPacket(IChatRoom icr, String dpType, String text) {
				mainModel.sendDataPacket(icr, dpType, text);
			}

		});
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatControl mainCtrl = new ChatControl();
					mainCtrl.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void start() {
		mainModel.start();
		mainView.start();
	}
}
