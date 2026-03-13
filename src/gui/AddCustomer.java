package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CustomerCtr;
import db.DataAccessException;
import model.Customer;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AddCustomer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Customer selectedCustomer;
	private JList<Customer> customerList;
	private CustomerCtr cctr;
	private NewSaleGui otherPage;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomer frame = new AddCustomer(null);
					frame.setVisible(true);
					
					Customer chosen = frame.getSelectedCustomer();
					if (chosen != null) {
						System.out.println("Selected customer: " + chosen.getName());
					} else {
						System.out.println("No customer selected.");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddCustomer(NewSaleGui nsg) {
		otherPage = nsg;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_South = new JPanel();
		contentPane.add(panel_South, BorderLayout.SOUTH);
		panel_South.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		customerList = new JList<>();
		customerList.setCellRenderer(new CustomerListCellRenderer());
		scrollPane.setViewportView(customerList);

		customerList.addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				Customer selected = customerList.getSelectedValue();
				if (selected != null) {
					System.out.println(selected.getName());
				}
			}
		});
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedCustomer = customerList.getSelectedValue();
				otherPage.setCustomer(selectedCustomer);
				dispose();
			}
		});
		panel_South.add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedCustomer = null;
				dispose();
			}
		});
		panel_South.add(btnCancel);

		init();
	}

	private void init() { customerList.setCellRenderer(new CustomerListCellRenderer());
		try {
			this.cctr = new CustomerCtr();
		} catch (DataAccessException e) {
			JOptionPane.showInternalMessageDialog(null, "Problems initializing the system " + e.getMessage());
		}
		updateCustomerList();
	}

	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}

	private void updateCustomerList(){
		try {
			List<Customer> cl = cctr.findAll();
			DefaultListModel<Customer> dlm = new DefaultListModel<>();
			for(Customer c : cl) {
				dlm.addElement(c);
			}
			this.customerList.setModel(dlm);
		} catch (DataAccessException e) {
			JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
		}	
	}
}
