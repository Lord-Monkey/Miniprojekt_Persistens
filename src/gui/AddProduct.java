package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ProductCtr;
import db.DataAccessException;
import model.Customer;
import model.Product;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AddProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<Product> productList;
	private ProductCtr pctr;
	private NewSaleGui otherPage;
	private Product selectedProduct;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProduct frame = new AddProduct(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddProduct(NewSaleGui otherPage) {
		this.otherPage = otherPage;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JButton btnAdd = new JButton("Tilføj");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedProduct = productList.getSelectedValue();
				otherPage.setProduct(selectedProduct);
				dispose();
			}
		});
		panel.add(btnAdd);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnCancel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);

		productList = new JList<>();
		productList.setCellRenderer(new ProductListCellRenderer());
		scrollPane.setViewportView(productList);

		productList.addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				Product selected = productList.getSelectedValue();
				if (selected != null) {
					System.out.println(selected.getName());
				}
			}
		});
		init();
	}

	private void init() {productList.setCellRenderer(new ProductListCellRenderer());
	try {
		this.pctr = new ProductCtr();
	} catch (DataAccessException e) {
		JOptionPane.showInternalMessageDialog(null, "Problems initializing the system " + e.getMessage());
	}
	updateProductList();
	}

	private void updateProductList() {
		try {
			List<Product> pl = pctr.findAllProducts();
			DefaultListModel<Product> dlm = new DefaultListModel<>();
			for(Product p : pl) {
				dlm.addElement(p);
			}
			this.productList.setModel(dlm);
		} catch (DataAccessException e) {
			JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
		}
	}
}
