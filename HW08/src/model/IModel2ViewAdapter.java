package model;

import common.IUser;
import view.ChatroomView;

public interface IModel2ViewAdapter {

	public void outputToTextArea(String string);

	public int getUserPort();

	public void setRemoteAdress(String localAddress);

	public int getServerPort();

	public void addtoConnectUser(IUser userStub);

	public void addTab(ChatroomView miniView);

}
