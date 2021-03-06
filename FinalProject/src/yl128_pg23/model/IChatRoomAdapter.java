/**
 * 
 */
package yl128_pg23.model;

import java.util.UUID;

/**
 * @author Yiqing Lu, Peisheng Guo
 *
 */
public interface IChatRoomAdapter {

	/**
	 * @return
	 */
	UUID getUUID();

	/**
	 * @return
	 */
	String getTitle();

	/**
	 * @param i
	 * @param text
	 */
	void sendDataPacket(String string, String content);

	void addGame();

	void addUser(String text);

}
