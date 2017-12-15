package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import model.strategy.paint.IPaintFac;
import model.strategy.update.IStrategyFac;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JComboBox;

import java.awt.GridLayout;

/**
 * the ballGUI of the MVC system
 * @author Yiqing Lu
 * @author Haoyuan Yue
 */
public class BallGUI<T> extends JFrame {

	/**
	 *  the serial version UID of main frame
	 */
	private static final long serialVersionUID = 3655441274873775934L;

	/**
	 * The model adapter is initialized to a no-op to insure that system always has well-defined behavior
	 */
	private IView2ModelAdapter<T> _view2ModelAdpt = new IView2ModelAdapter.NullFactory<T>().make();
	
	/**
	 * The paint adapter is initialized to a no-op to insure that system always has well-defined behavior
	 */
	private IModelPaintAdapter _modelPaintAdpt = new IModelPaintAdapter.NullFactory().make();
	/**
	 *  the container panel of main frame
	 */
	private JPanel contentPane;

	/**
	 *  the north panel
	 */
	private final JPanel pnlNorth = new JPanel();
	
	/**
	 * make ball button in the north panel
	 */
	private final JButton btnMakeBall = new JButton("Make Ball");
	
	/**
	 * text field in north panel
	 */
	private final JTextField txtStratName = new JTextField();
	
	/**
	 * clear all button in the north panel
	 */
	private final JButton btnClearall = new JButton("ClearAll");
	
	/**
	 * A panel holds component
	 */
	private final JPanel panel = new JPanel();
	
	/**
	 * A panel holds component
	 */
	private final JPanel panel_1 = new JPanel();
	
	/**
	 * A panel holds component
	 */
	private final JPanel panel_2 = new JPanel();
	
	/**
	 * A button that adds strategy factory to list
	 */
	private final JButton btnAddToList = new JButton("Add to List!");
	
	/**
	 * A combo box for strategy
	 */
	private final JComboBox<IStrategyFac<T>> strategy1 = new JComboBox<IStrategyFac<T>>();
	
	/**
	 * A combo box for strategy
	 */
	private final JComboBox<IStrategyFac<T>> strategy2 = new JComboBox<IStrategyFac<T>>();
	
	/**
	 * A button to combine strategy
	 */
	private final JButton btnCombine = new JButton("Combine!");
	
	/**
	 * A button to create a switcher
	 */
	private final JButton btnMakeSwicher = new JButton("make Swicher");
	
	/**
	 * A button to switch strategy
	 */
	private final JButton btnSwitch = new JButton("Switch!");
	
	/**
	 * A panel to hold components
	 */
	private final JPanel panel_3 = new JPanel();
	
	/**
	 * A text field for typing class name
	 */
	private final JTextField _textPaint = new JTextField();
	
	/**
	 * A button to add paint strategy factory
	 */
	private final JButton _btnAddPaint = new JButton("Add");
	
	/**
	 * A combo box for paint strategy
	 */
	private final JComboBox<IPaintFac> _comboPaint = new JComboBox<IPaintFac>();
	
	/**
	 * A panel for painting
	 */
	private final JPanel pnlCenter = new JPanel() {

		private static final long serialVersionUID = -6952656931251224807L;

		public void paintComponent(Graphics g) {
			super.paintComponent(g); // Do everything normally done first, e.g. clear the screen.
			_modelPaintAdpt.update(g); // call back to the model to paint the sprites
		}
	};

	/**
	 * Starts the already initialized frame, making it
	 * visible and ready to interact with the user.
	 */
	public void start() {
		setVisible(true);
	}

	/**
	 * Create the frame.
	 * @param view2ModelAdpt adapter talks to model according to commands
	 * @param modelPaintAdpt adapter talks to model to paint
	 */
	public BallGUI(IView2ModelAdapter<T> view2ModelAdpt, IModelPaintAdapter modelPaintAdpt) {
		_textPaint.setText("Ball");
		_textPaint.setToolTipText("the field to type the paint strategy name of ball");
		_textPaint.setColumns(10);
		_view2ModelAdpt = view2ModelAdpt;
		_modelPaintAdpt = modelPaintAdpt;
		initGUI();
	}

	/**
	 * Initiate the GUI
	 */
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("the content panel");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		contentPane.add(pnlCenter, BorderLayout.CENTER);
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		pnlNorth.setToolTipText("panel in the north");
		pnlNorth.setBackground(new Color(152, 251, 152));
		pnlNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.setBackground(new Color(192, 192, 192));

		pnlNorth.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(txtStratName);
		txtStratName.setToolTipText("the field to type the strategy name of ball");
		txtStratName.setText("Straight");
		txtStratName.setColumns(10);
		btnAddToList.setToolTipText("add the strategy you typed to the right two list");
		btnAddToList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				strategy1.insertItemAt(_view2ModelAdpt.addStrategyFac(txtStratName.getText()), 0);
				strategy2.insertItemAt(_view2ModelAdpt.addStrategyFac(txtStratName.getText()), 0);
				strategy1.setSelectedIndex(0);
				strategy2.setSelectedIndex(0);
			}
		});
		btnAddToList.setAlignmentX(Component.CENTER_ALIGNMENT);

		panel.add(btnAddToList);

		pnlNorth.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		btnMakeBall.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(btnMakeBall);
		btnMakeBall.setToolTipText("make a ball with the strategy and the paint strategy in the first droplist below");
		strategy1.setToolTipText("the first strategy");
		panel_1.add(strategy1);
		strategy2.setToolTipText("the second strategy to combine");

		panel_1.add(strategy2);
		btnCombine.setToolTipText("combine the two strategies above to a new strategy");
		btnCombine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IStrategyFac<T> newFac = (IStrategyFac<T>) _view2ModelAdpt.combineFac(
						strategy1.getItemAt(strategy1.getSelectedIndex()),
						strategy2.getItemAt(strategy2.getSelectedIndex()));
				strategy1.insertItemAt(newFac, 0);
				strategy2.insertItemAt(newFac, 0);
				strategy1.setSelectedIndex(0);
				strategy2.setSelectedIndex(0);
			}
		});
		btnCombine.setAlignmentX(Component.CENTER_ALIGNMENT);

		panel_1.add(btnCombine);
		btnMakeBall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_view2ModelAdpt.loadBall(strategy1.getItemAt(strategy1.getSelectedIndex()),
						_comboPaint.getItemAt(_comboPaint.getSelectedIndex()), false);
			}
		});
		panel_2.setBorder(
				new TitledBorder(null, "Switcher Controls", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		pnlNorth.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		btnMakeSwicher.setToolTipText(
				"make a ball with straight strategy and the selected paint strategy that could be switched");
		btnMakeSwicher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_view2ModelAdpt.loadBall(strategy1.getItemAt(strategy1.getSelectedIndex()),
						_comboPaint.getItemAt(_comboPaint.getSelectedIndex()), true);
			}
		});

		panel_2.add(btnMakeSwicher);
		btnSwitch.setToolTipText("switch the strategies of the switchers made before");
		btnSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_view2ModelAdpt.switchStrategy(strategy1.getItemAt(strategy1.getSelectedIndex()));
			}
		});

		panel_2.add(btnSwitch);
		btnClearall.setToolTipText("clear all the ball in the center panel");

		pnlNorth.add(btnClearall);


		panel_3.setBorder(
				new TitledBorder(null, "Paint Strategies", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		pnlNorth.add(panel_3);

		pnlNorth.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));

		panel_3.add(_textPaint);
		_btnAddPaint.setToolTipText("add the paint strategy you typed to the right two list");
		_btnAddPaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_comboPaint.insertItemAt(_view2ModelAdpt.addPaintFac(_textPaint.getText()), 0);
				_comboPaint.setSelectedIndex(0);
			}
		});

		panel_3.add(_btnAddPaint);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		_comboPaint.setToolTipText("the paint strategy");

		panel_3.add(_comboPaint);
		btnClearall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_view2ModelAdpt.clearAll();
			}
		});

	}

	/**
	* Get the center panel
	* @return the center panel
	*/
	public Component getCenterPanel() {
		return pnlCenter;
	}

	/**
	* Updates the view by repainting the canvas
	*/
	public void update() {
		pnlCenter.repaint();
	}

}
