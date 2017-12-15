package provided.music.visitor;

import provided.music.APhraseVisitor;
import provided.music.Chord;
import provided.music.Header;
import provided.music.IPhrase;
import provided.music.IPhraseVisitorCmd;
import provided.music.MTSeqList;
import provided.music.NESeqList;
import provided.music.Note;
import provided.music.Triplet;
import provided.player.SequencePlayer2;
import provided.util.ABCUtil;
import provided.util.KeySignature;

/**
 * @author Yiqing Lu
 * @author Alexander Hansen
 * Create the playerAlgo class extend APhraseVisitor
 * The playerAlgo installs commands to handle all of those hosts.
 */

public class playerAlgo extends APhraseVisitor {

	private KeySignature key_signature;
	private SequencePlayer2 sp;

	/**
	 * Constructor for playerAlgo.
	 */
	public playerAlgo() {

		/*
		 * install commands to deal with headers you do not care about
		 */
		String headerString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < headerString.length(); i++) {
			this.addCmd("" + headerString.charAt(i), new IPhraseVisitorCmd() {
				public Object apply(String id, IPhrase host, Object... params) {
					return params[1];
				}
			});
		}

		/*
		 * install commands to deal with "L" header
		 */
		this.addCmd("L", new IPhraseVisitorCmd() {
			public Object apply(String id, IPhrase host, Object... params) {
				Header head = (Header) host;
				sp = (SequencePlayer2) params[0];
				double defaultLengthPerNote = ABCUtil.Singleton.parseFraction(head.getValue());
				double ticks = 64 * defaultLengthPerNote;
				sp.setTicksPerDefaultNote((int) ticks);
				return params[1];
			}
		});

		/*
		 * install commands to deal with "K" header
		 */
		this.addCmd("K", new IPhraseVisitorCmd() {
			public Object apply(String id, IPhrase host, Object... params) {
				Header head = (Header) host;
				key_signature = new KeySignature(head.getValue());
				return params[1];
			}
		});

		/*
		 * install commands to deal with "Q" header
		 */
		this.addCmd("Q", new IPhraseVisitorCmd() {
			public Object apply(String id, IPhrase host, Object... params) {
				Header head = (Header) host;
				sp = (SequencePlayer2) params[0];
				double tempo = ABCUtil.Singleton.parseTempo(head.getValue(),
						1.0 * sp.getTicksPerQuarterNote() / sp.getTicksPerDefaultNote());
				sp.setTempo((int) tempo);
				return params[1];
			}
		});

		/*
		 * install commands to deal with Chord
		 */
		this.addCmd(Chord.ID, new IPhraseVisitorCmd() {
			public Object apply(String id, IPhrase host, Object... params) {
				Chord chord = (Chord) host;
				sp = (SequencePlayer2) params[0];
				int param = (int) params[1];
				for (Note temp_note : chord.getNotes()) {
					param = (int) temp_note.execute(playerAlgo.this, params);
				}
				return param;
			}
		});
		/*
		 * install commands to deal with Triplet
		 */
		this.addCmd(Triplet.ID, new IPhraseVisitorCmd() {
			public Object apply(String id, IPhrase host, Object... params) {
				Triplet triplet = (Triplet) host;
				sp = (SequencePlayer2) params[0];
				int param = (int) params[1];
				for (Note temp_note : triplet.getNotes()) {
					temp_note.setDuration(temp_note.getDuration() * 2.0 / 3);
					param = (int) temp_note.execute(playerAlgo.this, params);
				}
				return param;
			}
		});

		/*
		 * install commands to deal with Note
		 */
		this.addCmd(Note.ID, new IPhraseVisitorCmd() {

			public Object apply(String id, IPhrase host, Object... params) {
				sp = (SequencePlayer2) params[0];
				Note note = (Note) host;
				if (key_signature != null) {
					note = key_signature.adjust(note);
				}
				return sp.addNote(note, (int) params[1]);
			}
		});

		/*
		 * install commands to deal with non-empty sequence list
		 */
		this.addCmd(NESeqList.ID, new IPhraseVisitorCmd() {
			public Object apply(String id, IPhrase host, Object... params) {
				NESeqList ne_list = (NESeqList) host;
				int param = (int) ne_list.getFirst().execute(playerAlgo.this, params);
				return ne_list.getRest().execute(playerAlgo.this, params[0], param);
			}
		});

		/*
		 * install commands to deal with empty sequence list
		 */
		this.addCmd(MTSeqList.ID, new IPhraseVisitorCmd() {
			public Object apply(String id, IPhrase host, Object... params) {
				return params[1];
			}
		});

	}
}
