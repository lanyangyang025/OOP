package view;

import shape.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

/**
 * The Class MainAppFrame is extended from Class java.awt.Frame.JFrame.
 * The Class MainAppFrame implements the graphic user interface of the application of HW01.
 * 
 * @author Chen Zeng, cz39@rice.edu
 * @author Yiqing Lu, yl128@rice.edu
 * @version 1.0.20170826.1
 * @since 1.0.20170826.1
 *
 */

public class MainAppFrame extends JFrame {

	/**
	 * The serialVersionUID of this MainAppFrame.
	 */
	private static final long serialVersionUID = 1057458952401270427L;

	/**
	 * A contentPanel which is the main panel of the main frame.
	 */
	private JPanel contentPane;

	/**
	 * A text file in the North of the main frame.
	 */
	private JTextField text_north;

	/**
	 * The shapeSpc is a single AShape Object. 
	 */
	private AShape shapeSpc = new SpecificShape(250, 100, 100, 100, 0, 180, Color.RED);

	/**
	 * Start the MainAppFrame.
	 * This method set the frame visible.
	 */
	private void start() {
		setVisible(true);
	}

	/**
	 * Launch the application.
	 * @param args Arguments received.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainAppFrame frame = new MainAppFrame();
					frame.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainAppFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		/**
		 * A panel in the North of the main frame.
		 * Button and Text are added here.
		 */
		JPanel panel_north = new JPanel();
		panel_north.setBackground(Color.YELLOW);
		contentPane.add(panel_north, BorderLayout.NORTH);

		/**
		 * A label in the panel_north.
		 */
		JLabel label_north = new JLabel("Hello World");
		panel_north.add(label_north);

		/**
		 * A button used to change text in label_north.
		 */
		JButton button_changeText = new JButton("Change Text!");
		button_changeText.setToolTipText(
				"The content in the panel will be changed if you type in the textField and then press the button \"Change Text!\"");
		button_changeText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = text_north.getText();
				label_north.setText(str);
				System.out.print("Button works!\n");
			}
		});
		panel_north.add(button_changeText);

		/**
		 * A textfield used to enter changed text.
		 */
		text_north = new JTextField();
		panel_north.add(text_north);
		text_north.setColumns(10);

		JPanel panel_center = new JPanel() {
			/**
			 * The version UID of panel in the center.
			 */
			private static final long serialVersionUID = 4503987996713838001L;

			/**
			* Overridden paintComponent method to paint a shape in the panel.
			* @param g The Graphics object to paint on.
			**/
			public void paintComponent(Graphics g) {
				super.paintComponent(g); // Do everything normally done first, e.g. clear the screen.
				g.setColor(Color.RED); // Set the color to use when drawing
				g.fillOval(75, 100, 20, 40); // paint a filled 20x40 red ellipse whose upper left corner is at (75, 100)
				shapeSpc.paint(g);
			}
		};
		panel_center.setBackground(Color.ORANGE);
		contentPane.add(panel_center, BorderLayout.CENTER);

		/**
		 * A panel used to put buttons.
		 */
		JPanel panel_south = new JPanel();
		panel_south.setBackground(Color.GREEN);
		contentPane.add(panel_south, BorderLayout.SOUTH);

		/**
		 * A button used to draw oval.
		 */
		JButton button_oval = new JButton("Oval!");
		button_oval.setToolTipText("The center panel will paint an oval shape if the button \"Oval!\" is pressed");
		button_oval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shapeSpc = new Oval(250, 100, 100, 50, Color.CYAN);
				panel_center.repaint();
			}
		});
		panel_south.add(button_oval);

		/**
		 * A button used to draw rectangle.
		 */
		JButton button_rectangle = new JButton("Rectangle!");
		button_rectangle.setToolTipText(
				"The center panel will paint a rectangle shape if the button \"Rectangle!\" is pressed");
		button_rectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shapeSpc = new Rectangle(250, 100, 100, 50, Color.blue);
				panel_center.repaint();
			}
		});
		panel_south.add(button_rectangle);

		/**
		 * A button used to draw compoundShape.
		 */
		JButton button_compound = new JButton("Compound!");
		button_compound
				.setToolTipText("The center panel will paint a conpound shape if the button \"Compound!\" is pressed");
		button_compound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * The shapeSpc is now a composite shape object.
				 */
				shapeSpc = new CompoundShape(new Oval(250, 40, 60, 60, Color.GRAY),
						new Rectangle(250, 100, 60, 60, Color.RED));
				panel_center.repaint();
			}
		});
		panel_south.add(button_compound);
	}

}
