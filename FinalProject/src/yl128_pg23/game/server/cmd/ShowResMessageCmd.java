package yl128_pg23.game.server.cmd;

import java.util.UUID;
import common.DataPacketCR;
import common.DataPacketCRAlgoCmd;
import common.ICRCmd2ModelAdapter;
import provided.mixedData.MixedDataKey;
import yl128_pg23.game.server.controller.GameController;
import yl128_pg23.game.server.datatype.ShowResMessageType;
import yl128_pg23.game.server.model.Team;
import yl128_pg23.model.ICR2GameAdapter;

public class ShowResMessageCmd extends DataPacketCRAlgoCmd<ShowResMessageType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 455333575494285643L;

	private transient ICRCmd2ModelAdapter adpt;

	public ShowResMessageCmd(ICRCmd2ModelAdapter iCmd2ModelAdapter) {
		this.adpt = iCmd2ModelAdapter;
	}

	@Override
	public void setCmd2ModelAdpt(ICRCmd2ModelAdapter cmd2ModelAdpt) {
		this.adpt = cmd2ModelAdpt;
	}

	/**
	 * let all users show the result of the game
	 */
	@Override
	public String apply(Class<?> index, DataPacketCR<ShowResMessageType> host, String... params) {
		UUID gameID = UUID.fromString(GameController.getGameId());
		ICR2GameAdapter gameAdpater = adpt
				.get(new MixedDataKey<>(gameID, GameController.getDes(), ICR2GameAdapter.class));
		Team team = host.getData().getTeam();
		gameAdpater.showResult(team);
		return team.toString();
	}

}
