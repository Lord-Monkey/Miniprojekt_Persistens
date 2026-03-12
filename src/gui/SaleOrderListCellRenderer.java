package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.SaleOrder;

public class SaleOrderListCellRenderer implements ListCellRenderer<SaleOrder> {

	private DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
	@Override
	public Component getListCellRendererComponent(JList<? extends SaleOrder> list, SaleOrder order, int index, 
			boolean isSelected, boolean cellHasFocus) {
		JLabel renderer = (JLabel) dlcr.getListCellRendererComponent(list, createStringForView(order), index, isSelected, cellHasFocus);
		return renderer;
	}
	
	private String createStringForView(SaleOrder order) {
		String text = order.getOrderNo() + "      " + order.getCustomer().getName() + "      " + order.getDeliveryStatus();
		return text;
	}
	
	
}
