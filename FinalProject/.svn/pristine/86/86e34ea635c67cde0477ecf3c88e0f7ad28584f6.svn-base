/**
 * 
 */
package yl128_pg23.model;

import java.awt.Component;
import java.rmi.RemoteException;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import common.IReceiver;

/**
 * @author Yiqing Lu, Peisheng Guo
 *
 */
public class IReceiverListCellRenderer extends DefaultListCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1357604528984677863L;

	/* (non-Javadoc)
	 * @see javax.swing.ListCellRenderer#getListCellRendererComponent(javax.swing.JList, java.lang.Object, int, boolean, boolean)
	 */
	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index,
			boolean isSelected, boolean cellHasFocus) {
		Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		try {
			setText(((IReceiver) value).getUserStub().getName());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return c;
	}

}
