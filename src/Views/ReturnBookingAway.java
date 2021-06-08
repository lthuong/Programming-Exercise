package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ReturnBookingAway extends BookingUI {
	private String label = "OutBound";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBookingAway frame = new ReturnBookingAway();
					frame.setVisible(true);
					frame.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public ReturnBookingAway() {
		super();
		JLabel lbl_titel = new JLabel("Outbound");
		lbl_titel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_titel.setBounds(266, 10, 150, 24);
		getContentPane().add(lbl_titel);
	}

}
