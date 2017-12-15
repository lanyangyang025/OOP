package model;

import provided.abcParser.ABCParser;
import provided.music.IPhrase;
import provided.music.NESeqList;
import provided.music.Note;
import provided.music.visitor.playerAlgo;
import provided.music.visitor.toStringAlgo;
import provided.player.ISequencePlayerStatus;
import provided.player.SequencePlayer2;
import provided.player.SequencePlayer2.IPlayable;
import provided.util.ABCUtil;

/**
 * @author Alexander Hansen
 * @author Yiqing Lu
 * the ball world model class
 */
public class MusicPlayerModel {
	/**
	 * Sequence Player object used in the model.
	 */
	private SequencePlayer2 player;
	/**
	 * interface used for interacting with the View.
	 */
	private IModel2ViewAdapter _iModel2View;

	private String fileName;

	private IPhrase phrase;

	private IPlayable make_playable;

	/**
	 * initiates the frame.
	 * @param iModel2View the IModel2ViewAdapter that will be used throughout the instance
	 */
	public MusicPlayerModel(IModel2ViewAdapter iModel2View) {

		_iModel2View = iModel2View;
	}

	/**
	 * starts the model
	 */
	public void start() {

	}

	/**
	 * loads the given file.
	 * @param filename the given file to load
	 * @return the content of the file
	 */
	public String loadFile(String filename) {
		this.fileName = "/songs/" + filename + ".abc";
		return ABCUtil.Singleton.getFileContents(this.fileName);
	}

	/**
	 * parses the given file.
	 * @return the parse content of the file
	 */
	public String parseFile() {
		NESeqList.setToStringAlgo(new toStringAlgo());
		phrase = new ABCParser(this.fileName).parse();
		return phrase.toString();
	}

	/**
	 * plays the given file.
	 * @param instrument the given instrument to play
	 */
	public void playFile(int instrument) {
		player = new SequencePlayer2(16, instrument);
		//		phrase = new Chord(new Note('G', 0, 0, 1.0, false), new Note('A', 0, 0, 1.0, false));
		//		phrase = new Triplet(new Note('G', 0, 0, 1.0, true), new Note('A', 0, 0, 1.0, false), new Note('C', 0, 0, 1.0, false));
		//		phrase = new Note('G', 0, 0, 1.0, false);

		player.setTicksPerDefaultNote(16);
		player.setTempo(120);

		phrase.execute(new playerAlgo(), player, 1);
		if (make_playable != null) {
			make_playable.stop();
		}
		make_playable = player.makePlayable(ISequencePlayerStatus.NULL);

		make_playable.start();
	}

	/**
	 * stops the given file.
	 */
	public void stopFile() {
		make_playable.stop();
	}

	/**
	 * returns the sequence player
	 * @return get the player
	 */
	public SequencePlayer2 getPlayer() {
		return player;
	}

}
