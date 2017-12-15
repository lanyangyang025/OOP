package yl128_pg23.game.server.cmd;

import java.util.UUID;

import common.DataPacketCR;
import common.DataPacketCRAlgoCmd;
import common.ICRCmd2ModelAdapter;
import provided.mixedData.MixedDataKey;
import yl128_pg23.game.server.controller.GameController;
import yl128_pg23.game.server.datatype.StartPlaceMessageType;
import yl128_pg23.model.ICR2GameAdapter;

public class StartPlaceMessageCmd extends DataPacketCRAlgoCmd<StartPlaceMessageType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2613281706890437720L;
	private transient ICRCmd2ModelAdapter adpt;

	public StartPlaceMessageCmd(ICRCmd2ModelAdapter iCmd2ModelAdapter) {
		this.adpt = iCmd2ModelAdapter;
	}

	/**
	 * let all users start to place treasures
	 */
	@Override
	public String apply(Class<?> index, DataPacketCR<StartPlaceMessageType> host, String... params) {
		// TODO Auto-generated method stub
		UUID gameID = UUID.fromString(GameController.getGameId());
		ICR2GameAdapter gameAdpater = adpt
				.get(new MixedDataKey<>(gameID, GameController.getDes(), ICR2GameAdapter.class));
		gameAdpater.sendStart(host.getData().getTeam());
		return null;
	}

	@Override
	public void setCmd2ModelAdpt(ICRCmd2ModelAdapter cmd2ModelAdpt) {
		// TODO Auto-generated method stub
		this.adpt = cmd2ModelAdpt;
	}

}
