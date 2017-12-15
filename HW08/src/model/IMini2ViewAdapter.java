package model;

import javax.swing.ImageIcon;

import common.IReceiver;
import view.ChatroomView;

public interface IMini2ViewAdapter {

	void append(String text, String name);

	void addUserList(IReceiver receiver);

	ChatroomView getRoomView();

	void addImage(ImageIcon data);

	void removeUserList(IReceiver receiver);

	ChatRoom getChatRoom();
}
