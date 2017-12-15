package yl128_pg23.model;

import java.util.List;

import yl128_pg23.game.server.model.IPosition;
import yl128_pg23.game.server.model.Team;

/**
 * 
 * @author Yiqing Lu
 *
 */

public interface ICR2GameAdapter {

	void appendMsgGlobal(String text);

	void getTeamReady(Team team);

	void appendChatMsg(String text, Team team);

	void sendStart(Team team);

	void sendPosition(Team team, IPosition iPosition);

	void startGameReady(Team team, List<IPosition> list);

	void findPosition(Team team, IPosition position);

	void showResult(Team team);
}
