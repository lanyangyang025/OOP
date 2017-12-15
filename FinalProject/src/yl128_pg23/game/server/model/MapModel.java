package yl128_pg23.game.server.model;

import yl128_pg23.game.map.MapLayer;
import yl128_pg23.game.server.datatype.FindTreaMessageType;
import yl128_pg23.game.server.datatype.GameChatMessageType;
import yl128_pg23.game.server.datatype.PlaceTreaMessageType;
import yl128_pg23.game.server.datatype.PlayerReadyMessageType;
import yl128_pg23.game.server.datatype.StartPlaceMessageType;
import yl128_pg23.game.server.datatype.StartGameMessageType;
import yl128_pg23.game.server.datatype.ShowResMessageType;
import yl128_pg23.model.ChatRoom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import common.DataPacketCR;
import common.IReceiver;
import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.Position;

/**
 * 
 * @author Yiqing Lu
 *
 */

public class MapModel {
	IGameModel2ViewAdapter _adpt;
	private IReceiver receiver;
	private ChatRoom chatroom;
	private Team team;
	private boolean isStart = false, isPlay = false;
	private List<IPosition> ls = new ArrayList<IPosition>();
	private List<MapLayer> ls_layer = new ArrayList<MapLayer>();
	private List<MapLayer> ls_layer_find = new ArrayList<MapLayer>();
	private int placeNum = 5;
	private Map<Team, List<IPosition>> map = new HashMap<Team, List<IPosition>>();
	private List<IPosition> ls_find = new ArrayList<IPosition>();
	private int count = 0;

	public MapModel(IGameModel2ViewAdapter adpt, IReceiver receiver, ChatRoom chatroom) {
		_adpt = adpt;
		this.receiver = receiver;
		this.chatroom = chatroom;
	}

	/**
	 * get the info of the position when clicking right on mouse
	 * @param p
	 */
	public void click(Position p) {
		if (isStart && !isPlay) {
			System.out.println("Mouse clicked at: " + p + " altitude = " + p.getAltitude());
			IPosition position = new IPosition(p.getLatitude().getDegrees(), p.getLongitude().getDegrees(),
					p.getAltitude());
			chatroom.sendPacket(new DataPacketCR<PlaceTreaMessageType>(PlaceTreaMessageType.class,
					new PlaceTreaMessageType(team, position), receiver));
		}

		if (isPlay) {
			double lat = p.getLatitude().getDegrees();
			double lon = p.getLongitude().getDegrees();

			for (int i = 0; i < ls_find.size(); i++) {
				IPosition temp = ls_find.get(i);
				if (Math.abs(temp.getLat() - lat) < 3 && Math.abs(temp.getLon() - lon) < 3) {
					chatroom.sendPacket(new DataPacketCR<FindTreaMessageType>(FindTreaMessageType.class,
							new FindTreaMessageType(team, temp), receiver));
					break;
				}
			}
		}
	}

	public void start() {
	}

	/**
	 * send message to team members
	 * @param text text data
	 */
	public void sendMsgRoom(String text) {
		// TODO Auto-generated method stub
		chatroom.sendPacket(new DataPacketCR<GameChatMessageType>(GameChatMessageType.class,
				new GameChatMessageType(team, text), receiver));
	}

	/**
	 * let user join the team and update to other team members
	 * @param team
	 */
	public void getTeamReady(Team team) {
		// TODO Auto-generated method stub
		this.team = team;
		chatroom.sendPacket(new DataPacketCR<PlayerReadyMessageType>(PlayerReadyMessageType.class,
				new PlayerReadyMessageType(team), receiver));
		_adpt.showTeam(team);
	}

	/**
	 * show number of team members and enable the "Place" button
	 * @param team
	 */
	public void showTeamNum(Team team) {
		_adpt.showTeamNum(team);
		if (this.team != null && this.team.equals(team)) {
			_adpt.enableStart();
		}
	}

	/**
	 * append message to team
	 * @param text the message
	 * @param team2 the team need to be sent
	 */
	public void appendChatMsg(String text, Team team2) {
		// TODO Auto-generated method stub
		if (team == null) {
			return;
		}
		if (team.toString().equals(team2.toString())) {
			_adpt.appendChatMsg(text);
		}
	}

	/**
	 * notify all users that the team is ready to place the treasure
	 */
	public void startGame() {
		// TODO Auto-generated method stub
		chatroom.sendPacket(new DataPacketCR<StartPlaceMessageType>(StartPlaceMessageType.class,
				new StartPlaceMessageType(team), receiver));
	}

	/**
	 * if the user is in the team, unable "Place" button, if the user hasn't join a team, delete the team in the comboBox
	 * @param team2 the team which is ready
	 */
	public void sendStart(Team team2) {
		// TODO Auto-generated method stub
		if (team == null) {
			_adpt.unableJoin(team2);
		} else {
			if (team.equals(team2)) {
				System.out.println(team);
				_adpt.unableStart();
			}
		}
		_adpt.sendStart(team2);
	}

	/**
	 * get the maximum number the team could place and set the place status to true
	 */
	public void setStart() {
		// TODO Auto-generated method stub
		placeNum = 5 * _adpt.getPlaceNum(team);
		isStart = true;
	}

	/**
	 * send the position to the team
	 * @param team2 the user team
	 * @param position the position the user clicked
	 */
	public void sendPosition(Team team2, IPosition position) {
		// TODO Auto-generated method stub
		if (team != null && team.equals(team2) && ls.size() < placeNum) {
			ls.add(position);
			MapLayer temp = new MapLayer();
			Position p = new Position(Angle.fromDegrees(position.getLat()), Angle.fromDegrees(position.getLon()),
					position.getEle());
			temp.addToggleAnnotation("Treasure", "Treasure Selected!", p);
			_adpt.show(temp);
			ls_layer.add(temp);
		}
	}

	/**
	 * notify all users that the team finishes placint
	 */
	public void waitToSTart() {
		// TODO Auto-generated method stub
		chatroom.sendPacket(new DataPacketCR<StartGameMessageType>(StartGameMessageType.class,
				new StartGameMessageType(team, ls), receiver));
	}

	/**
	 * tell the user team is ready and send the targeted position of team
	 * @param team2 the team which is ready
	 * @param ls2 the list of position the team placed
	 */
	public void startGameReady(Team team2, List<IPosition> ls2) {
		// TODO Auto-generated method stub
		if (team.equals(team2)) {
			_adpt.unableFinish();
			int num = ls_layer.size();
			for (int i = 0; i < num; i++) {
				_adpt.hide(ls_layer.get(i));
			}
		}
		map.put(team2, ls2);
		_adpt.sendTeamStart(team2);
	}

	/**
	 * send the targeted places of treasures
	 */
	public void sendPlaces() {
		// TODO Auto-generated method stub
		isPlay = true;
		for (Team t : map.keySet()) {
			if (!t.equals(team)) {
				ls_find = map.get(t);
			}
		}
	}

	/**
	 * the command when the user finds the treasure
	 * @param team2 the user team
	 * @param position the position the user found
	 */
	public void findTrea(Team team2, IPosition position) {
		// TODO Auto-generated method stub
		if (team.equals(team2)) {

			for (int i = 0; i < ls_find.size(); i++) {
				if (ls_find.get(i).equals(position)) {
					ls_find.remove(i);
					break;
				}
			}

			MapLayer temp = new MapLayer();
			Position p = new Position(Angle.fromDegrees(position.getLat()), Angle.fromDegrees(position.getLon()),
					position.getEle());
			temp.addToggleAnnotation("Treasure", "Treasure Selected!", p);
			_adpt.show(temp);
			ls_layer_find.add(temp);

			if (ls_find.size() == 0) {
				chatroom.sendPacket(new DataPacketCR<ShowResMessageType>(ShowResMessageType.class,
						new ShowResMessageType(team), receiver));
			}
		}

	}

	/**
	 * show result of the team
	 * @param team2 the winner team
	 */
	public void showResult(Team team2) {
		if (count < _adpt.getPlaceNum(team2) - 1) {
			count++;
		} else {
			if (team2.equals(team)) {
				JOptionPane.showMessageDialog(null, "You win!");
			} else {
				JOptionPane.showMessageDialog(null, "You lose!");
			}
			_adpt.close();
		}
	}

}
