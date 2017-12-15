package view;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class BallGUI extends JFrame {

	private static final long serialVersionUID = 5621850870582071800L;
	/**
	 * view to model adapter
	 */
	private IView2ModelAdapter _view2ModelAdpt = IView2ModelAdapter.NULL_OBJECT;
	private JPanel contentPane;
	private int count;
	private final JPanel _pnlCanvas = new JPanel() {

		private static final long serialVersionUID = -6952656931251224807L;

		public void paintComponent(Graphics g) {
			super.paintComponent(g); // Do everything normally done first, e.g. clear the screen.
			//			g.setColor(Color.RED); // Set the color to use when drawing
			//			g.fillOval(75, 100, 20, 20); // paint a filled 20x40 red ellipse whose upper left corner is at (75, 100) 
			_view2ModelAdpt.paint(g); // call back to the model to paint the sprites
		}
	};
	private final JTextField _fieldText = new JTextField();
	private final JPanel north_panel = new JPanel();
	private final JButton _btnMakeball = new JButton("Make Ball");
	private final JLabel _lblText = new JLabel("New label");
	private final JButton _btnClear = new JButton("Clear");

	/**
	 * Launch the application.
	 */

	public void start() {
		setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public BallGUI(IView2ModelAdapter _view2ModelAdpt) {
		this._view2ModelAdpt = _view2ModelAdpt;
		north_panel.add(_fieldText);
		_fieldText.setColumns(10);

		north_panel.add(_btnMakeball);
		_btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_view2ModelAdpt.clear();
			}
		});

		north_panel.add(_btnClear);
		north_panel.add(_lblText);
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		_pnlCanvas.setBackground(Color.ORANGE);

		contentPane.add(_pnlCanvas, BorderLayout.CENTER);

		contentPane.add(north_panel, BorderLayout.NORTH);
		action_Listener();
		get_canvas();
	}

	/**
	 * get the classname of the ball and send it to controller and model
	 */
	public void action_Listener() {
		_btnMakeball.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_view2ModelAdpt.set_ball(_fieldText.getText());
			}
		});
	}

	public void update() {
		_pnlCanvas.repaint();
		_lblText.setText("Ball Number: " + count);
	}

	/**
	 * get the canvas and send the canvas information to model through controller
	 */
	public void get_canvas() {
		_view2ModelAdpt.get_canvas(_pnlCanvas);
	}

	/**
	 * get count from controller and model
	 */
	public void get_count(int count) {
		this.count = count;
	}

}
