/**
 * 
 */
package yl128_pg23.view;

import java.util.List;

import javax.swing.JPanel;

import common.IChatRoom;
import common.IUser;

/**
 * @author Yiqing Lu, Peisheng Guo
 *
 */
public interface IModelAdapter {
	public void connectPeer(String addr);

	public void setSelfName(String name);

	public JPanel createCR();

	/**
	 * @param iPeer
	 * @return
	 */
	public List<IChatRoom> fetchCRList(IUser iPeer);

	/**
	 * @param iPeer 
	 * @param elementAt
	 */
	public JPanel joinCR(IUser iPeer, IChatRoom cr);

	/**
	 * @return
	 */
	public String getIP();

	/**
	 * @return
	 */
	public String getUserName();

	/**
	 * @param jPanel
	 */
	public void leaveCR(JPanel jPanel);

	/**
	 * @param elementAt
	 * @param i
	 * @param text
	 */
	public void sendDataPacket(IChatRoom elementAt, String dpType, String text);

}
