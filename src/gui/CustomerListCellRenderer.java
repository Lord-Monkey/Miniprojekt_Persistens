package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Customer;

public class CustomerListCellRenderer implements ListCellRenderer<Customer> {
	private DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
	@Override
	public Component getListCellRendererComponent(JList<? extends Customer> list, Customer value, int index, boolean isSelected, boolean cellHasFocus) {
		JLabel renderer = (JLabel) dlcr.getListCellRendererComponent(list, createStringForView(value), index, isSelected, cellHasFocus);
		return renderer;
	}

	private String createStringForView(Customer customer) {
		String text = customer.getName() + "   " + customer.getMail() + "   " + customer.getType();
		return text;
	}
}
