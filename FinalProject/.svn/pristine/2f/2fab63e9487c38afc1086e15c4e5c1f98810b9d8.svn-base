package yl128_pg23.game.server.cmd;

import java.util.UUID;
import common.DataPacketCR;
import common.DataPacketCRAlgoCmd;
import common.ICRCmd2ModelAdapter;
import provided.mixedData.MixedDataKey;
import yl128_pg23.game.server.controller.GameController;
import yl128_pg23.game.server.datatype.StartGameMessageType;
import yl128_pg23.model.ICR2GameAdapter;

public class StartGameMessageCmd extends DataPacketCRAlgoCmd<StartGameMessageType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 455333575494285643L;

	private transient ICRCmd2ModelAdapter adpt;

	public StartGameMessageCmd(ICRCmd2ModelAdapter iCmd2ModelAdapter) {
		this.adpt = iCmd2ModelAdapter;
	}

	@Override
	public void setCmd2ModelAdpt(ICRCmd2ModelAdapter cmd2ModelAdpt) {
		this.adpt = cmd2ModelAdpt;
	}

	/**
	 * let the team ready to play the game after placing treasures and notify to all users
	 */
	@Override
	public String apply(Class<?> index, DataPacketCR<StartGameMessageType> host, String... params) {
		UUID gameID = UUID.fromString(GameController.getGameId());
		ICR2GameAdapter gameAdpater = adpt
				.get(new MixedDataKey<>(gameID, GameController.getDes(), ICR2GameAdapter.class));
		StartGameMessageType data = host.getData();
		gameAdpater.startGameReady(data.getTeam(), data.getPlaces());
		return null;
	}

}
