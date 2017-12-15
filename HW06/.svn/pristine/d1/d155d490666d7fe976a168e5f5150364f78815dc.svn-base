package provided.music.visitor;

import provided.music.APhraseVisitor;
import provided.music.IPhrase;
import provided.music.IPhraseVisitorCmd;
import provided.music.MTSeqList;
import provided.music.NESeqList;

/**
 * @author Yiqing Lu
 * @author Alexander Hansen
 * Create the toStringAlgo class extend APhraseVisitor
 * The toStringAlgo provides the recursive forward accumulating helper (inner) algorithm.
 * It helps to represents the music. All the elements are divided by commas, and the parenthesis
 * holds these elements.
 */

public class toStringAlgo extends APhraseVisitor {

	/**
	 * Constructor for toStringAlgo.
	 */

	public toStringAlgo() {
		/*
		 * install commands to deal with non-empty sequence list
		 */
		this.addCmd(NESeqList.ID, new IPhraseVisitorCmd() {
			public Object apply(String id, IPhrase host, Object... params) {
				NESeqList ne_list = (NESeqList) host;
				NESeqList.setToStringAlgo(toStringAlgo.this);
				return ne_list.getRest().execute(NESeqList.getToStringAlgo(), params[0] + "," + ne_list.getFirst());
			}
		});

		/*
		 * install commands to deal with empty sequence list
		 */
		this.addCmd(MTSeqList.ID, new IPhraseVisitorCmd() {
			public Object apply(String id, IPhrase host, Object... params) {
				return params[0] + "}";
			}
		});

	}

}
