/**
 * 
 */
package yl128_pg23.view;

import java.awt.Component;
import java.rmi.RemoteException;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import common.IUser;

/**
 * @author Yiqing Lu, Peisheng Guo
 *
 */
public class IPeerListCellRenderer extends DefaultListCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4964108972931922121L;

	/* (non-Javadoc)
	 * @see javax.swing.ListCellRenderer#getListCellRendererComponent(javax.swing.JList, java.lang.Object, int, boolean, boolean)
	 */
	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index,
			boolean isSelected, boolean cellHasFocus) {
		Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		try {
			setText(((IUser) value).getName());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return c;
	}

}
