package view;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import provided.util.ABCInstrument;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSplitPane;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextPane;

/**
 * @author Alexander Hansen
 * @author Yiqing Lu
 * The player GUI class
 */

public class MusicPlayerView<TInst> extends JFrame {

	/**
	 * serialization number
	 */
	private static final long serialVersionUID = 432253693325539503L;
	/**
	 * ContentPanel for the app
	 */
	private JPanel contentPane;
	/**
	 * text filed for inputting filename
	 */
	private JTextField txtFile;
	/**
	 * panel which holds the controls
	 */
	private JPanel panelControls;
	/**
	 * label for user guidance
	 */
	private JLabel lblFile;
	/**
	 * button for loading file
	 */
	private JButton btnLoad;
	/**
	 * button for parsing file
	 */
	private JButton btnParse;
	/**
	 * combobox which contains a list of avalible instruments
	 */
	private JComboBox<TInst> comboBoxInstruments;
	/**
	 * button for playing a file
	 */
	private JButton btnPlay;
	/**
	 * interface for interacting with the model
	 */
	private IView2ModelControlAdapter _iView2Model;
	private JSplitPane splitPane;
	private JScrollPane scrollPane_file;
	private JScrollPane scrollPane_parse;
	private JTextPane textPane_file;
	private JTextPane textPane_parse;
	private JButton btnStop;

	/**
	 * Create the frame.
	 * @param iView2Model view to model adapter
	 */
	public MusicPlayerView(IView2ModelControlAdapter iView2Model) {
		setMinimumSize(new Dimension(600, 0));

		_iView2Model = iView2Model;
		init();
	}

	/**
	 * initiates the frame.
	 */
	public void init() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelControls = new JPanel();
		panelControls.setBackground(Color.LIGHT_GRAY);
		panelControls.setToolTipText("Panel containing all the controls\r\n");
		contentPane.add(panelControls, BorderLayout.NORTH);

		lblFile = new JLabel("File:");
		lblFile.setToolTipText("File Descriptior");
		panelControls.add(lblFile);

		txtFile = new JTextField();
		txtFile.setToolTipText("File to load.");
		txtFile.setText("File");
		panelControls.add(txtFile);
		txtFile.setColumns(10);

		btnLoad = new JButton("Load");
		btnLoad.setToolTipText("Loads the indicated file\r\n");
		panelControls.add(btnLoad);
		btnLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnParse.setEnabled(true);
				textPane_file.setText(_iView2Model.loadFile(txtFile.getText()));
			}
		});

		btnParse = new JButton("Parse");
		btnParse.setEnabled(false);

		btnParse.setToolTipText("Parses the selected file\r\n");
		panelControls.add(btnParse);
		btnParse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textPane_parse.setText(_iView2Model.parseFile());
			}
		});

		comboBoxInstruments = new JComboBox<TInst>();
		comboBoxInstruments.setToolTipText("The avalible instruments to choose from - please pick one");
		panelControls.add(comboBoxInstruments);
		for (TInst i : getInstruments())
			comboBoxInstruments.addItem(i);

		btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_iView2Model.playFile();
			}
		});
		btnPlay.setToolTipText("Plays the file, once it is loaded");
		panelControls.add(btnPlay);

		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_iView2Model.stopFile();
			}
		});
		btnStop.setToolTipText("Stop playing the music");
		panelControls.add(btnStop);

		splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.CENTER);

		scrollPane_file = new JScrollPane();
		scrollPane_file.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"File Content", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		splitPane.setLeftComponent(scrollPane_file);

		textPane_file = new JTextPane();
		scrollPane_file.setViewportView(textPane_file);

		scrollPane_parse = new JScrollPane();
		scrollPane_parse.setViewportBorder(
				new TitledBorder(null, "Parsed IPhrase Structure", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane.setRightComponent(scrollPane_parse);

		textPane_parse = new JTextPane();
		scrollPane_parse.setViewportView(textPane_parse);
	}

	/**
	 * Returns a list of some instruments
	 * @return the content in combo box
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<TInst> getInstruments() {
		ArrayList<TInst> instruments = new ArrayList<TInst>();
		instruments.add((TInst) (new ABCInstrument("Piano 1", 0)));
		instruments.add((TInst) (new ABCInstrument("Bright Acoustic Piano", 1)));
		instruments.add((TInst) (new ABCInstrument("Harpsichord", 6)));
		instruments.add((TInst) (new ABCInstrument("Clavi", 7)));
		instruments.add((TInst) (new ABCInstrument("Music Box", 10)));
		instruments.add((TInst) (new ABCInstrument("Harmonica", 22)));
		return instruments;
	}

	/**
	 * returns the index of the selected instrument of the combo box
	 * @return return the number of the instrument
	 */
	public int getSelectedInstrumentIndex() {
		ABCInstrument i = (ABCInstrument) comboBoxInstruments.getSelectedItem();
		return i.getValue();
	}

	/**
	 * starts the view
	 */
	public void start() {
		setVisible(true);
	}

}
