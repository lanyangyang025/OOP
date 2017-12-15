package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EngineView extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JButton button = new JButton("Quit");
	private final JTextField textField = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea textArea = new JTextArea();

	private IEngineModelAdapter _iModelAdapter;
	
	/**
	 * Launch the application.
	 */
	public void start() {
		setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public EngineView(IEngineModelAdapter iEngineModelAdapter) {
		initGUI();
		this._iModelAdapter = iEngineModelAdapter;
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(panel, BorderLayout.NORTH);
		button.setToolTipText("Click to quit the server");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_iModelAdapter.quit();
			}
		});
		
		panel.add(button);
		textField.setToolTipText("Hit Enter to send the message to engine");
		textField.setText("Hit Enter to send msg...");
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_iModelAdapter.sendMsg(textField.getText());;
			}
		});
		
		textField.setColumns(20);
		textField.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Send msg to remote client's view", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		panel.add(textField);
		
		contentPane.add(scrollPane, BorderLayout.CENTER);
		textArea.setToolTipText("All the status and results will be shown here");
		
		scrollPane.setViewportView(textArea);
	}
	
	public void outputToTextArea(String string) {
		// append string
		textArea.append(string);
		
		// force scroll down to the newest string appended
		textArea.setCaretPosition(textArea.getText().length());
	}
}
