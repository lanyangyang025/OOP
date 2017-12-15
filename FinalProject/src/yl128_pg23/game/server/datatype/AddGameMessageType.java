package yl128_pg23.game.server.datatype;

import common.ICRMessageType;
import common.IReceiver;

/**
 * 
 * @author Yiqing Lu
 *
 */

public class AddGameMessageType implements ICRMessageType {

	/**
	 * Compiler generated unique ID
	 */
	private static final long serialVersionUID = -1910338096932711898L;

	private IReceiver receiver;

	public AddGameMessageType(IReceiver self) {
		// TODO Auto-generated constructor stub
		this.receiver = self;
	}

	public IReceiver getReceiver() {
		return this.receiver;
	}
}
