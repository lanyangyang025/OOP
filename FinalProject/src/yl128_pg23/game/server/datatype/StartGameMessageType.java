package yl128_pg23.game.server.datatype;

import java.util.List;

import common.ICRMessageType;
import yl128_pg23.game.server.model.IPosition;
import yl128_pg23.game.server.model.Team;

/**
 * 
 * @author Yiqing Lu
 *
 */

public class StartGameMessageType implements ICRMessageType {

	/**
	 * Compiler generated unique ID
	 */
	private static final long serialVersionUID = -1910338096932711898L;
	Team team;
	List<IPosition> ls;

	public StartGameMessageType(Team team, List<IPosition> ls) {
		this.team = team;
		this.ls = ls;
	}

	public Team getTeam() {
		return team;
	}

	public List<IPosition> getPlaces() {
		return ls;
	}
}
