package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.OrderLineItem;

public class OrderLineItemListCellRenderer implements ListCellRenderer<OrderLineItem> {
	private DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
	@Override
	public Component getListCellRendererComponent(JList<? extends OrderLineItem> list, OrderLineItem value, int index, boolean isSelected, boolean cellHasFocus) {
		JLabel renderer = (JLabel) dlcr.getListCellRendererComponent(list, createStringForView(value), index, isSelected, cellHasFocus);
		return renderer;
	}

	private String createStringForView(OrderLineItem oli) {
		String text = oli.getProduct().getName() + "    " + oli.getQuantity();
		return text;
	}
}
