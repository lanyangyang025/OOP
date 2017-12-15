package view;

import java.util.Collection;

import common.IChatRoom;
import common.IUser;
import model.ChatRoom;

/**
 * View to Model Adapter of Client
 * @author Zihan Wang, Yiqing Lu
 *
 */
public interface IView2ModelAdapter {

	public void connect(String remoteIP, String string);

	public void createUser(String name);

	public void createChatRoom(String text);

	public Collection<IChatRoom> getChatRoom(IUser iUser);

	public void join(IChatRoom iChatRoom);

	public void leaveChatRoom(ChatRoom chatroom);

}
