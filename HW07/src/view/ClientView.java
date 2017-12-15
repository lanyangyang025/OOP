package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import provided.client.model.taskUtils.ITaskFactory;
import provided.compute.ITask;

import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;


/**
 * View for Client
 * @author Zihan Wang, Yiqing Lu
 *
 */
public class ClientView extends JFrame {

	private JPanel contentPane;
	private JTextField txtHostAddress;
	private JTextField txtAddTask;
	private JTextField txtParam;
	private JTextArea textArea;
	private JComboBox comboFirstTask, comboSecondTask;
	
	
	/**
	 * Fix serialVersionUID warning
	 */
	private static final long serialVersionUID = 5651484136730732585L;
	
	/**
	 * initial model to view
	 */
	private IClientModelAdapter adapter;
	private JTextField txtMsg;
	
	/**
	 * set GUI to visible
	 */
	public void start() {
		adapter.init();
		setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public ClientView(IClientModelAdapter adapter) {
		this.adapter = adapter;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adapter.quit();
			}
		});
		btnQuit.setToolTipText("Click to quit client view and stop client execution");
		panel_1.add(btnQuit);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Remote Host:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		txtHostAddress = new JTextField();
		txtHostAddress.setToolTipText("Type in host's IP address");
		panel_2.add(txtHostAddress);
		txtHostAddress.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hostAddress = txtHostAddress.getText();
				outputToTextArea("Attempting to connect to " + hostAddress);
				
				outputToTextArea(adapter.connect(hostAddress));
			}
		});
		panel_2.add(btnConnect);
		
		Box verticalBox = Box.createVerticalBox();
		panel_2.add(verticalBox);
		panel_2.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtHostAddress, btnConnect}));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Send msg to remote host's view", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_3);
		
		txtMsg = new JTextField();
		txtMsg.setToolTipText("msg to be sent, hit Enter to send it");
		txtMsg.setText("Hit Enter to send msg...");
		panel_3.add(txtMsg);
		txtMsg.setColumns(10);
		
		txtMsg.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					adapter.sendMsgToComputeEngine(txtMsg.getText());
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					adapter.sendMsgToComputeEngine(txtMsg.getText());
//				}
			}
			
		});
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		
		txtAddTask = new JTextField();
		txtAddTask.setToolTipText("Type in the task class name");
		panel_4.add(txtAddTask);
		txtAddTask.setColumns(10);
		
		JButton btnAddToLists = new JButton("Add to lists");
		btnAddToLists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String task = txtAddTask.getText();
				ITaskFactory<?> loaded = adapter.addTask(task);
				System.out.println(loaded);
				comboFirstTask.insertItemAt(loaded, 0);
				comboSecondTask.insertItemAt(loaded, 0);
				

				// Set the selected index to be the first one of the two combo boxes
				comboFirstTask.setSelectedIndex(0);
				comboSecondTask.setSelectedIndex(0);
			}
		});
		
		btnAddToLists.setToolTipText("Click to add task to list");
		panel_4.add(btnAddToLists);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		JButton btnRunTask = new JButton("Run Task");
		btnRunTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String param = txtParam.getText();
				
				ITaskFactory<?> select = (ITaskFactory<?>) comboFirstTask.getSelectedItem();
				
				ITask<?> task = select.make(param);
				
				outputToTextArea(adapter.runTask(task) + '\n');
			}
		});
		btnRunTask.setToolTipText("Click to run the first selected Task");
		panel_5.add(btnRunTask);
		
		comboFirstTask = new JComboBox();
		comboFirstTask.setToolTipText("Select a task to run");
		panel_5.add(comboFirstTask);
		
		comboSecondTask = new JComboBox();
		comboSecondTask.setToolTipText("Select a task to combine with the first task");
		panel_5.add(comboSecondTask);
		
		
		
		JButton btnCombine = new JButton("Combine Tasks");
		btnCombine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String param = txtParam.getText();
				
//				ITask<?> task1 = ((ITaskFactory<?>) comboFirstTask.getSelectedItem()).make(param);
//				ITask<?> task2 = ((ITaskFactory<?>) comboSecondTask.getSelectedItem()).make(param);
				
				ITaskFactory<?> task1 = (ITaskFactory<?>) comboFirstTask.getSelectedItem();
				ITaskFactory<?> task2 = (ITaskFactory<?>) comboSecondTask.getSelectedItem();
				
				ITaskFactory<?> loaded = adapter.combineTask(task1, task2, param);
				
				if (loaded != null) {
					comboFirstTask.insertItemAt(loaded, 0);
					comboSecondTask.insertItemAt(loaded, 0);
					
					// Set the selected index to be the first one of the two combo boxes
					comboFirstTask.setSelectedIndex(0);
					comboSecondTask.setSelectedIndex(0);
				}
				
			}
		});
		
		
		btnCombine.setToolTipText("Click to combine tasks");
		panel_5.add(btnCombine);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Run Parameter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_7);
		
		txtParam = new JTextField();
		txtParam.setText("1,2,3,4,5");
		txtParam.setToolTipText("Click to add parameter for the task");
		panel_7.add(txtParam);
		txtParam.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		
		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		textArea.setToolTipText("The status and task outputs will be shown here");
		contentPane.add(scroll, BorderLayout.CENTER);
		
	}
	
	/**
	 * Append status string to the JTextArea and force scroll
	 * @param string status string to be displayed
	 */
	public void outputToTextArea(String string) {
		// append string
		textArea.append(string);
		
		// force scroll down to the newest string appended
		textArea.setCaretPosition(textArea.getText().length());
	}
	
	public void setRemoteAdress(String string) {
		txtHostAddress.setText(string);
	}

}
