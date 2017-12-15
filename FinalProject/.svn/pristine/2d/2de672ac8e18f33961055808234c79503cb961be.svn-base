package yl128_pg23.model.user.cmd;

import common.DataPacketUser;
import common.DataPacketUserAlgoCmd;
import common.IChatRoom;
import common.IUserCmd2ModelAdapter;
import common.datatype.user.IInvitationType;
import yl128_pg23.model.IViewAdapter;
import yl128_pg23.model.User;

public class CmdCommInvite extends DataPacketUserAlgoCmd<IInvitationType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7812621475021445680L;
	private transient User user;
	private transient IUserCmd2ModelAdapter cmd2ModelAdpt;
	private transient IViewAdapter adpt;

	public CmdCommInvite(User user2, IUserCmd2ModelAdapter c2mAdpt, IViewAdapter adpt2) {
		// TODO Auto-generated constructor stub
		this.setUser(user2);
		this.cmd2ModelAdpt = c2mAdpt;
		this.adpt = adpt2;
	}

	@Override
	public String apply(Class<?> index, DataPacketUser<IInvitationType> host, String... params) {
		// TODO Auto-generated method stub
		IChatRoom cr = host.getData().getChatRoom();
		adpt.addWindow(host.getSender(), cr);
		return null;
	}

	@Override
	public void setCmd2ModelAdpt(IUserCmd2ModelAdapter cmd2ModelAdpt) {
		// TODO Auto-generated method stub
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
