package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SalesOrderCtr;
import db.DataAccessException;
import model.SaleOrder;

import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;

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
		panel.add(btnNewOrder, "cell 0 3");
		
		lstSaleOrder = new JList();
		lstSaleOrder.setCellRenderer(new SaleOrderListCellRenderer());
		scrollPane.setViewportView(lstSaleOrder);

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
}
