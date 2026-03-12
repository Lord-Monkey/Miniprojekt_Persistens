package gui;

import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui frame = new MainGui();
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
	public MainGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_North = new JPanel();
		contentPane.add(panel_North, BorderLayout.NORTH);
		
		JPanel panel_Center = new JPanel();
		contentPane.add(panel_Center, BorderLayout.CENTER);
		panel_Center.setLayout(new MigLayout("", "[85px][85px]", "[21px][][][][][][]"));
		
		JButton btnOrders = new JButton("Ordrer");
		btnOrders.setMargin(new Insets(2, 31, 2, 31));
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openOrders();
			}
		});
		
		panel_Center.add(btnOrders, "cell 0 1,alignx left,aligny top");
		
		JButton btn_Customer = new JButton("Kunder");
		btn_Customer.setMargin(new Insets(2, 30, 2, 30));
		panel_Center.add(btn_Customer, "cell 0 2");
		
		JButton btn_Products = new JButton("Produkter");
		btn_Products.setMargin(new Insets(2, 24, 2, 24));
		panel_Center.add(btn_Products, "cell 0 3");
		
		JButton btn_Notifications = new JButton("Notifikationer");
		btn_Notifications.setMargin(new Insets(2, 16, 2, 16));
		panel_Center.add(btn_Notifications, "cell 0 4,alignx left,aligny top");
		
		JPanel panel_South = new JPanel();
		contentPane.add(panel_South, BorderLayout.SOUTH);

	}

	private void openOrders() {
			SaleOrderGui sog = new SaleOrderGui();
			sog.setLocationRelativeTo(sog);
			sog.setVisible(true);
		}
}
