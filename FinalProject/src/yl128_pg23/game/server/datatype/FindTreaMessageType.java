package yl128_pg23.game.server.datatype;

import common.ICRMessageType;
import yl128_pg23.game.server.model.IPosition;
import yl128_pg23.game.server.model.Team;

/**
 * 
 * @author Yiqing Lu
 *
 */

public class FindTreaMessageType implements ICRMessageType {

	/**
	 * Compiler generated unique ID
	 */
	private static final long serialVersionUID = -1910338096932711898L;
	IPosition position;
	Team team;

	public FindTreaMessageType(Team team, IPosition position2) {
		this.position = position2;
		this.team = team;
	}

	public IPosition getPosition() {
		return position;
	}

	public Team getTeam() {
		return this.team;
	}
}
