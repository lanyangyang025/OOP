/**
 * 
 */
package yl128_pg23.model;

import java.util.List;

import common.IChatRoom;
import common.IUser;

/**
 * @author Yiqing Lu, Peisheng Guo
 *
 */
public interface IViewAdapter {

	//public void updateConnectedPeersNameList();
	public void addConnPeer(IUser Peer);

	/**
	 * @param cr
	 */
	public void addConnCR(ChatRoom cr);

	/**
	 * 
	 */
	public void updateMsg();

	/**
	 * @param connCRs 
	 * 
	 */
	public void updateCRs(List<IChatRoom> connCRs);

	/**
	 * @param connectedPeers
	 */
	public void updatePeers(List<IUser> connectedPeers);

	void addWindow(IUser user, IChatRoom chatRoom);

}
