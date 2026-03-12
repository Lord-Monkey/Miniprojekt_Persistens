package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SalesOrderCtr;
import db.DataAccessException;
import model.SaleOrder;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class SaleOrderGui extends JFrame {
	private SalesOrderCtr soCtr;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<SaleOrder> lstSaleOrder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleOrderGui frame = new SaleOrderGui();
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
	public SaleOrderGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setRowHeaderView(panel);
		panel.setLayout(new MigLayout("", "[]", "[][][][][][][][][][][][][]"));
		
		JButton btnNewOrder = new JButton("Ny ordre");
		btnNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openNewOrder();
			}
		});
		panel.add(btnNewOrder, "cell 0 3");
		
		lstSaleOrder = new JList<>();
		lstSaleOrder.setCellRenderer(new SaleOrderListCellRenderer());
		scrollPane.setViewportView(lstSaleOrder);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setHorizontalAlignment(SwingConstants.RIGHT);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		panel_1.add(btnCancel);

		init();
	}

	private void init() { lstSaleOrder.setCellRenderer(new SaleOrderListCellRenderer());
		try {
			this.soCtr = new SalesOrderCtr();
		} catch (DataAccessException e) {
			JOptionPane.showInternalMessageDialog(null, "Problems initializing the system " + e.getMessage());
		}
		updateSaleOrderList();
	}
	
	private void updateSaleOrderList() {
		try {
			List<SaleOrder> sol = soCtr.findAll();
			DefaultListModel<SaleOrder> dlm = new DefaultListModel<>();
			for(int i = 0 ; i < sol.size(); i++) {
				dlm.addElement(sol.get(i));
			}
			this.lstSaleOrder.setModel(dlm);
		} catch (DataAccessException e) {
			JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
		}
	}
	
	private void openNewOrder() {
		NewSaleGui nsg = new NewSaleGui();
		nsg.setVisible(true);
		nsg.setLocation(300, 300);
	}
}
