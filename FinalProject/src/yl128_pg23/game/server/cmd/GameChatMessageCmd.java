package yl128_pg23.game.server.cmd;

import java.util.UUID;

import common.DataPacketCR;
import common.DataPacketCRAlgoCmd;
import common.ICRCmd2ModelAdapter;
import provided.mixedData.MixedDataKey;
import yl128_pg23.game.server.controller.GameController;
import yl128_pg23.game.server.datatype.GameChatMessageType;
import yl128_pg23.model.ICR2GameAdapter;

public class GameChatMessageCmd extends DataPacketCRAlgoCmd<GameChatMessageType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5716871397748651861L;
	private transient ICRCmd2ModelAdapter adpt;

	public GameChatMessageCmd(ICRCmd2ModelAdapter iCmd2ModelAdapter) {
		this.adpt = iCmd2ModelAdapter;
	}

	/**
	 * append the message to the team chat room
	 */
	@Override
	public String apply(Class<?> index, DataPacketCR<GameChatMessageType> host, String... params) {
		// TODO Auto-generated method stub
		UUID gameID = UUID.fromString(GameController.getGameId());
		ICR2GameAdapter gameAdpater = adpt
				.get(new MixedDataKey<>(gameID, GameController.getDes(), ICR2GameAdapter.class));
		GameChatMessageType message = host.getData();
		gameAdpater.appendChatMsg(message.getText(), message.getTeam());
		return null;
	}

	@Override
	public void setCmd2ModelAdpt(ICRCmd2ModelAdapter cmd2ModelAdpt) {
		// TODO Auto-generated method stub
		this.adpt = cmd2ModelAdpt;
	}

}
