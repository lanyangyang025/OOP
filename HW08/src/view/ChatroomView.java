package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Image;
import java.rmi.RemoteException;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import common.IReceiver;
import model.ChatRoom;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

import javax.swing.JSplitPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * View for the chat room
 *
 */
public class ChatroomView extends JPanel {

	private static final long serialVersionUID = -6314403003364664653L;
	/**
	 * view to model adapter
	 */
	IMini2ModelAdapter _imodeladapter;
	private final JPanel panel = new JPanel();
	private final JSplitPane splitPane = new JSplitPane();
	private final JTextField textField = new JTextField();
	private final JButton btnNewButton = new JButton("Send");
	private final JButton btnNewButton_1 = new JButton("Image");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JPanel textPanel = new JPanel();

	private DefaultListModel<String> userlistModel = new DefaultListModel<String>();

	private final JList<String> user_list = new JList<>(userlistModel);

	private IReceiver receiver;

	public ChatroomView(IMini2ModelAdapter _imodeladapter, IReceiver receiver) {
		textField.setColumns(10);
		this._imodeladapter = _imodeladapter;
		this.receiver = receiver;
		initGUI();
	}

	private void initGUI() {
		setLayout(new BorderLayout(0, 0));

		add(panel, BorderLayout.SOUTH);

		panel.add(textField);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_imodeladapter.sendDataPacket(textField.getText(), receiver);
				textField.setText("");
			}
		});

		panel.add(btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FileDialog fileDialog = new FileDialog(new JFrame(), "Select a image", FileDialog.LOAD);
				fileDialog.setVisible(true);
				String imagePath = fileDialog.getDirectory() + fileDialog.getFile();

				try {
					ImageIcon image = new ImageIcon(ImageIO.read(new FileInputStream(imagePath)));
					_imodeladapter.sendImage(image);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		panel.add(btnNewButton_1);
		splitPane.setResizeWeight(0.2);

		add(splitPane, BorderLayout.CENTER);

		splitPane.setLeftComponent(scrollPane);

		scrollPane.setViewportView(user_list);

		splitPane.setRightComponent(scrollPane_1);
		textPanel.setBackground(Color.WHITE);

		scrollPane_1.setViewportView(textPanel);
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
	}

	public void outputTotextPanel(String string) {
		// append string
		JLabel label = new JLabel(string);
		textPanel.add(label);
		textPanel.revalidate();
	}

	public void clearUserList() {
		((DefaultListModel<String>) user_list.getModel()).removeAllElements();
	}

	public void addUserList(IReceiver receiver1) throws RemoteException {
		if (!userlistModel.contains(receiver1.getUserStub().getName())) {
			userlistModel.addElement(receiver1.getUserStub().getName());
		}
	}

	public String getName() {
		return _imodeladapter.getName();
	}

	public void addImage(ImageIcon data) {
		// TODO Auto-generated method stub

		Image image = data.getImage(); // transform it 
		Image newimg = image.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newicon = new ImageIcon(newimg);
		JLabel label = new JLabel(newicon);
		textPanel.add(label);
		textPanel.revalidate();
	}

	public void removeUserList(IReceiver receiver2) {
		// TODO Auto-generated method stub
		try {
			if (userlistModel.contains(receiver2.getUserStub().getName())) {
				userlistModel.removeElement(receiver2.getUserStub().getName());

			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object getUUID() {
		// TODO Auto-generated method stub
		return _imodeladapter.getUUID();
	}

	public void quit() {
		// TODO Auto-generated method stub
		_imodeladapter.quit();
	}

	public ChatRoom getChatRoom() {
		// TODO Auto-generated method stub
		return _imodeladapter.getChatRoom();
	}

}
