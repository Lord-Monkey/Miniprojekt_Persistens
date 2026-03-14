package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.List;

import controller.SalesOrderCtr;
import db.DataAccessException;
import model.Customer;
import model.OrderLineItem;
import model.Product;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class NewSaleGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCustomer;
	private JLabel lblShowCustomer;
	private Customer customer;
	private SalesOrderCtr soc;
	private Product product;
	private JList<OrderLineItem> orderLineItemList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewSaleGui frame = new NewSaleGui();
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
	public NewSaleGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		try {
			soc = new SalesOrderCtr();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JPanel panel_South = new JPanel();
		contentPane.add(panel_South, BorderLayout.SOUTH);
		panel_South.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JButton btnCreate = new JButton("Opret");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createSale();
			}
		});
		btnCreate.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_South.add(btnCreate);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_South.add(btnCancel);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new MigLayout("", "[]", "[][][]"));

		btnCustomer = new JButton("Tilføj kunde");
		btnCustomer.setMargin(new Insets(2, 18, 2, 19));
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					soc.createSaleOrder();
				} catch (DataAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				addCustomerToSale();
			}
		});

		lblShowCustomer = new JLabel("Ingen kunde valgt");
		panel.add(lblShowCustomer, "cell 0 0");
		panel.add(btnCustomer, "cell 0 1");

		JButton btnProduct = new JButton("Tilføj produkt");
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				addProductToSale();
			}});
		panel.add(btnProduct, "cell 0 2");

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		orderLineItemList = new JList<>();
		orderLineItemList.setCellRenderer(new OrderLineItemListCellRenderer());
		scrollPane.setViewportView(orderLineItemList);

		init();
	}

	private void addCustomerToSale() {
		AddCustomer addCustomer = new AddCustomer(this);
		addCustomer.setLocation(400, 400);
		addCustomer.setVisible(true);

		customer = addCustomer.getSelectedCustomer();

		if (customer != null) {
			lblShowCustomer.setText(customer.getName() + " (" + customer.getMail() + ")");
			btnCustomer.setText("Ændr kunde");		}
		else {
			System.out.println("Ingen kunde valgt");
		}
	}

	private void createSale() {
		// Checks if a customer have been added to the offer
		soc.finaliseSaleOrder();
		dispose();

	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
		lblShowCustomer.setText(customer.getName() + " (" + customer.getMail() + ")");
		try {
			soc.enterCustomer(customer.getMail());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void setProduct(Product product) {
		this.product = product;
		int quantity = 0;
		while(quantity == 0) {
			String qtyStr = JOptionPane.showInputDialog(this,"Ønsket antal af " + product.getName(), "Antal", JOptionPane.QUESTION_MESSAGE);
			if (qtyStr == null) return;

			try {
				int tempqty = Integer.parseInt(qtyStr);
				if (tempqty <= 0) throw new NumberFormatException();
				else {
					quantity = tempqty;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Antal skal være et positivt tal over 0!");
			}
		}
		if(product != null) {
			soc.addOrderLine(product, quantity);
		}
	}

	public AddProduct addProductToSale() {
		AddProduct addProduct = new AddProduct(this);
		addProduct.setLocation(400, 400);
		addProduct.setVisible(true);
		return addProduct;


	}

	private void init() {orderLineItemList.setCellRenderer(new OrderLineItemListCellRenderer());
	updateOrderLineItemList();

	}
	public void updateOrderLineItemList() {
		if (customer != null) {
			List<OrderLineItem> olii = soc.getOrderLines();
			DefaultListModel<OrderLineItem> dlm = new DefaultListModel<>();
			for(OrderLineItem oli : olii) {
				dlm.addElement(oli);
			}
			this.orderLineItemList.setModel(dlm);
		}
	}
}