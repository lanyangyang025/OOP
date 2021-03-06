package yl128_pg23.game.server.datatype;

import common.ICRMessageType;
import yl128_pg23.game.server.model.Team;

/**
 * 
 * @author Yiqing Lu
 *
 */

public class GameChatMessageType implements ICRMessageType {

	private Team team;
	private String text;

	public GameChatMessageType(Team team, String text) {
		// TODO Auto-generated constructor stub
		this.team = team;
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public Team getTeam() {
		return this.team;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4481392716748512537L;

}
