package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Product;

public class ProductListCellRenderer implements ListCellRenderer<Product> {

	private DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
	@Override
	public Component getListCellRendererComponent(JList<? extends Product> list, Product value, int index, boolean isSelected, boolean cellHasFocus) {
		JLabel renderer = (JLabel) dlcr.getListCellRendererComponent(list, createStringForView(value), index, isSelected, cellHasFocus);
		return renderer;
	}

	private String createStringForView(Product product) {
		String text = product.getProductNumber() + "   " + product.getName();
		return text;
	}

}