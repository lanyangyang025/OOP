package view;

import java.util.UUID;

import javax.swing.ImageIcon;

import common.IReceiver;
import model.ChatRoom;

public interface IMini2ModelAdapter {

	public String getName();

	public UUID getUUID();

	void sendDataPacket(String text, IReceiver receiver);

	public void sendImage(ImageIcon image);

	public void quit();

	public ChatRoom getChatRoom();

	void sendImage(ImageIcon image, IReceiver receiver);
}
