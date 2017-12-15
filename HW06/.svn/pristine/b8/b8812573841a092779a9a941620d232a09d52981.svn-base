package controller;

import java.awt.EventQueue;

import model.*;
import provided.player.SequencePlayer2;
import view.MusicPlayerView;
import view.IView2ModelControlAdapter;
import provided.util.ABCInstrument;

/**
 * @author Alexander Hansen
 * @author Yiqing Lu
 * The Controller class
 */
public class MusicPlayerController {
	/**
	 * the ball world model
	 */
	private MusicPlayerModel musicPlayerModel;
	/**
	 * the GUI Window view.
	 */
	private MusicPlayerView<ABCInstrument> musicPlayerView;

	/**
	 * Controller constructor builds the system
	 */
	public MusicPlayerController() {

		// set the view field
		musicPlayerView = new MusicPlayerView<ABCInstrument>(new IView2ModelControlAdapter() {
			public String loadFile(String file) {
				return musicPlayerModel.loadFile(file);
			}

			public String parseFile() {
				return musicPlayerModel.parseFile();
			}

			public void playFile() {
				musicPlayerModel.playFile(musicPlayerView.getSelectedInstrumentIndex());
			}

			public void stopFile() {
				musicPlayerModel.stopFile();
			}
		});

		// set the model field
		musicPlayerModel = new MusicPlayerModel(new IModel2ViewAdapter() {
			public SequencePlayer2 getPlayer() {
				return musicPlayerModel.getPlayer();
			}

		});
	}

	/**
	 * Start the system
	 */
	public void start() {
		musicPlayerModel.start(); // It is usually better to start the model first but not always.
		musicPlayerView.start();
	}

	/**
	 * Launch the application.
	 * @param args Arguments given by the system or command line.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { // Java specs say that the system must be constructed on the GUI event thread.
			public void run() {
				try {
					MusicPlayerController controller = new MusicPlayerController(); // instantiate the system
					controller.start(); // start the system
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
