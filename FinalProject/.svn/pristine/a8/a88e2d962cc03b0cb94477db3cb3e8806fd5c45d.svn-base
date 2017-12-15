/**
 * 
 */
package yl128_pg23.model;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.List;
import java.util.UUID;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import common.IReceiver;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JButton;

/**
 * @author Yiqing Lu, Peisheng Guo
 *
 */
public class ChatWindow extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -751599912303795709L;
	private DefaultListModel<IReceiver> lstUserModel = new DefaultListModel<IReceiver>();
	private final JList<IReceiver> lstUsers = new JList<IReceiver>(lstUserModel);
	private final JTextField txfInput = new JTextField();
	private IChatRoomAdapter cradpt;
	private final JLabel lblTitle = new JLabel("New label");
	private final JPanel panel = new JPanel();
	private final JComboBox<String> cmbMsgType = new JComboBox<String>();
	private final JScrollPane scpMsg = new JScrollPane();
	private final JPanel pnlMsg = new JPanel();
	private final JPanel pnlUserLst = new JPanel();
	private final JButton btnNewButton = new JButton("Start game");
	private final JButton btnInvite = new JButton("invite");
	private final JTextField textField = new JTextField();
	ChatRoomManager crMngr;

	/**
	 * Create the panel.
	 * @param iChatRoomAdapter 
	 */
	public ChatWindow(IChatRoomAdapter cradpt) {
		this.cradpt = cradpt;
		initGUI();
	}

	private void initGUI() {
		setLayout(new BorderLayout(0, 0));

		add(scpMsg, BorderLayout.CENTER);
		pnlMsg.setBackground(Color.WHITE);

		scpMsg.setViewportView(pnlMsg);
		pnlMsg.setLayout(new BoxLayout(pnlMsg, BoxLayout.Y_AXIS));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setText(cradpt.getTitle());
		add(lblTitle, BorderLayout.NORTH);

		add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 107, 0, 0, 0, 66, 0 };
		gbl_panel.rowHeights = new int[] { 36 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0 };
		panel.setLayout(gbl_panel);

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cradpt.addGame();
			}
		});
		panel.add(btnNewButton, gbc_btnNewButton);
		GridBagConstraints gbc_cmbMsgType = new GridBagConstraints();
		gbc_cmbMsgType.fill = GridBagConstraints.BOTH;
		gbc_cmbMsgType.insets = new Insets(0, 0, 5, 5);
		gbc_cmbMsgType.gridx = 1;
		gbc_cmbMsgType.gridy = 0;
		cmbMsgType.setFont(new Font("Andalus", Font.PLAIN, 14));
		panel.add(cmbMsgType, gbc_cmbMsgType);
		cmbMsgType.addItem("Text");
		cmbMsgType.addItem("Image");
		cmbMsgType.addItem("File");
		GridBagConstraints gbc_txfInput = new GridBagConstraints();
		gbc_txfInput.insets = new Insets(0, 0, 5, 0);
		gbc_txfInput.gridwidth = 3;
		gbc_txfInput.fill = GridBagConstraints.BOTH;
		gbc_txfInput.gridx = 2;
		gbc_txfInput.gridy = 0;
		txfInput.setFont(new Font("Andalus", Font.PLAIN, 14));
		panel.add(txfInput, gbc_txfInput);
		txfInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txfInput.getText().isEmpty()) {
					cradpt.sendDataPacket(cmbMsgType.getModel().getElementAt(cmbMsgType.getSelectedIndex()),
							txfInput.getText());
					txfInput.setText("");
				}
			}
		});
		txfInput.setColumns(10);

		GridBagConstraints gbc_btnInvite = new GridBagConstraints();
		gbc_btnInvite.insets = new Insets(0, 0, 0, 5);
		gbc_btnInvite.gridx = 0;
		gbc_btnInvite.gridy = 1;
		btnInvite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cradpt.addUser(textField.getText());
				textField.setText("");
			}
		});
		panel.add(btnInvite, gbc_btnInvite);

		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 4;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		textField.setFont(new Font("Dialog", Font.PLAIN, 14));
		textField.setColumns(10);
		panel.add(textField, gbc_textField);

		add(pnlUserLst, BorderLayout.WEST);
		pnlUserLst.setLayout(new BorderLayout(0, 0));
		lstUsers.setFont(new Font("Andalus", Font.PLAIN, 14));
		lstUsers.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlUserLst.add(lstUsers);
		lstUsers.setCellRenderer(new IReceiverListCellRenderer());
	}

	/**
	 * 
	 */
	public void start() {
		setVisible(true);
	}

	public UUID getUUID() {
		return cradpt.getUUID();
	}

	@Override
	public String toString() {
		return cradpt.getTitle();
	}

	/**
	 * @param msgText
	 */
	public void updateMsg(String msgText) {
		JLabel lbl = new JLabel(msgText);
		lbl.setFont(new Font("Andalus", Font.PLAIN, 14));
		pnlMsg.add(lbl);
		pnlMsg.revalidate();
		pnlMsg.repaint();

	}

	/**
	 * @param c
	 */
	public void popWindow(Component c) {
		pnlMsg.add(c);
		//JOptionPane.showMessageDialog(this, c);

	}

	public void updateUserList(List<IReceiver> lst) {
		lstUserModel.clear();
		for (IReceiver r : lst) {
			lstUserModel.addElement(r);
		}
	}
}
