/**
 * 
 */
package yl128_pg23.model;

import java.awt.Component;
import java.util.List;

import common.IReceiver;
import common.IUser;

/**
 * @author Yiqing Lu, Peisheng Guo
 *
 */
public interface IChatWindowAdapter {

	/**
	 * @param msgText
	 */
	void updateMsg(String msgText);

	/**
	 * @param c
	 */
	void popWindow(Component c);

	/**
	 * @param conns
	 */
	void updateUser(List<IReceiver> conns);

	IUser addUser(String text);

}
